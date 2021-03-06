package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.TcrClassInfoBeans;
import beans.TcrLoginInfoBeans;
import dao.DiaryDao;
import dao.UserDao;

/**
 * Servlet implementation class TcrDispDiaryListServlet
 */
@WebServlet("/TcrDispDiaryListServlet")
public class TcrDispDiaryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int youClassNotFound = 0;
	private static final int onlyOneClassDiary = 1;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TcrDispDiaryListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String path ="";
		//userIdから一覧を呼び出す
		String userId = ((TcrLoginInfoBeans)session.getAttribute("tcrLoginInfo")).getUserId();
		UserDao userDao = new UserDao();

		//　教員が担当するクラスの数（１か2以上）に応じて処理を分割
		List<TcrClassInfoBeans> tcrClassList =userDao.getTcrClass(userId);

		DiaryDao diaryDao = new DiaryDao();

		//1クラスの場合のみリダイレクト使用
		switch(tcrClassList.size()) {
	//　未所属
		case youClassNotFound:
			path = "WEB-INF/jsp/youClassNotFound.jsp";
			request.getRequestDispatcher(path).forward(request, response);
			break;
	//　1クラスのみ
		case onlyOneClassDiary:
			session.setAttribute("classCode", tcrClassList.get(0).getClassCode());
			response.sendRedirect("DispClassDiaryServlet");
			break;
	//　2クラス以上の担任である場合、クラス選択画面へ
		default:
			String jspActionPath = "DispClassDiaryServlet";
			request.setAttribute("tcrClassList", tcrClassList);
			request.setAttribute("actionPath", jspActionPath);
			path = "WEB-INF/jsp/choiceDispClass.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

}
