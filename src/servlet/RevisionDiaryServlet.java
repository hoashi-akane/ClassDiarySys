package servlet;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class RevisionDiaryServlet
 */
@WebServlet("/RevisionDiaryServlet")
public class RevisionDiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RevisionDiaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		DiaryDao diaryDao = new DiaryDao();

		LoginInfoBeans loginInfo = (LoginInfoBeans)session.getAttribute("loginInfo");
		List<DiaryListBeans> diaryList = diaryDao.getDelDiaryList(loginInfo.getUserId());


		request.setAttribute("diaryList", diaryList);
		request.getRequestDispatcher("WEB-INF/jsp/revisionDiary.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		//chkには添え字が入っている。
		String userId = ((LoginInfoBeans)session.getAttribute("loginInfo")).getUserId();
		String[] checks = request.getParameterValues("chk");
		List<DiaryListBeans> diaryList = new ArrayList<DiaryListBeans>();

		DiaryDao diaryDao = new DiaryDao();

		// 修正を行う日誌の値をリスト、ビーンズに格納
		for(String check : checks) {
			DiaryListBeans diary = new DiaryListBeans();

			String goodCom = request.getParameter("good_com"+check);
			String badCom = request.getParameter("bad_com"+ check);
			String stdCom = request.getParameter("std_Com"+ check);

			if(goodCom == null) {
				goodCom = "";
			}
			if(badCom == null) {
				badCom ="";
			}
			if(stdCom == null) {
				stdCom = "";
			}

			diary.setInsertDate(request.getParameter("day"+ check));
			diary.setGoodPoint(goodCom);
			diary.setBadPoint(badCom);
			diary.setStdCom(stdCom);
			diaryList.add(diary);
		}

		if(diaryDao.revisionDiary(diaryList, userId)) {
			String[] message = {"修正","修正が完了しました！"};
			request.setAttribute("message", message);
			request.getRequestDispatcher("WEB-INF/jsp/completeDiaryResist.jsp").forward(request, response);
		}else {
			String errorMsg = "エラーが発生しました。もう一度やり直してください";
			request.setAttribute("message", errorMsg);
			request.getRequestDispatcher("WEB-INF/jsp/revisionDiary.jsp").forward(request, response);
		}

	}

}
