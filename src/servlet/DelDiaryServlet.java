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
 * Servlet implementation class DelAbsenceServlet
 */
@WebServlet("/DelDiaryServlet")
public class DelDiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelDiaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //日誌削除
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		DiaryDao diaryDao = new DiaryDao();

		LoginInfoBeans loginInfo = (LoginInfoBeans)session.getAttribute("loginInfo");
		List<DiaryListBeans> diaryList = diaryDao.getDelDiaryList(loginInfo.getUserId());


		request.setAttribute("diaryList", diaryList);
		request.getRequestDispatcher("WEB-INF/jsp/delDiary.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String[] check = request.getParameterValues("chk");
		String userId = ((LoginInfoBeans)session.getAttribute("loginInfo")).getUserId();
		DiaryDao diaryDao = new DiaryDao();

		if(diaryDao.delDiary(check, userId)) {
			String[] message = {"削除","削除が完了しました。"};
			request.setAttribute("message", message);
			request.getRequestDispatcher("WEB-INF/jsp/completeDiaryResist.jsp").forward(request, response);
		}else {

		}

	}

}
