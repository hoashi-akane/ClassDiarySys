package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DiaryListBeans;
import beans.LoginInfoBeans;
import dao.DiaryDao;

/**
 * Servlet implementation class DispDiaryListServlet
 */
@WebServlet("/DispDiaryListServlet")
public class DispDiaryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispDiaryListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		//userIdから一覧を呼び出す
		String class_code = ((LoginInfoBeans)session.getAttribute("loginInfo")).getClassCode();
		DiaryDao diaryDao = new DiaryDao();
		List<DiaryListBeans> diaryList = diaryDao.getDiaryList(class_code);
		session.setAttribute("daiaryList",diaryList);
		request.getRequestDispatcher("WEB-INF/jsp/dispDiaryList.jsp").forward(request, response);
	}

}
