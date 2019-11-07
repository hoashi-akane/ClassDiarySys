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

import beans.DiaryBeans;
import beans.LoginInfoBeans;
import dao.DiaryDao;

/**
 * Servlet implementation class MultiInputDiaryResistServlet
 */
@WebServlet("/MultiInputDiaryResistServlet")
public class MultiInputDiaryResistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiInputDiaryResistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//　作成する番号取得
		HttpSession session = request.getSession();
		LoginInfoBeans loginInfo = (LoginInfoBeans)session.getAttribute("loginInfo");
		String[] check = request.getParameterValues("chk");

		List<DiaryBeans> multiDiary = new ArrayList<DiaryBeans>();

		//値をすべてセット
		for(String num: check) {
			DiaryBeans diary = new DiaryBeans();
			diary.setUserId(loginInfo.getUserId());
			diary.setClassCode(loginInfo.getClassCode());
			diary.setGoodPoint(request.getParameter("good_com"+num));
			diary.setBadPoint(request.getParameter("bad_com"+num));
			diary.setInsertDate(request.getParameter("hid"+num));
			diary.setStdCom(request.getParameter("std_com"+num));
			diary.setTcr_Com("");
			multiDiary.add(diary);
		}

		DiaryDao diaryDao = new DiaryDao();
		if(diaryDao.multiInsertDiaryResist(multiDiary)) {
			String[] message = {"登録", "登録が完了しました！"};
			request.setAttribute("message", message);
			request.getRequestDispatcher("WEB-INF/jsp/completeDiaryResist.jsp").forward(request, response);
		}else {
			String errorMsg ="既に登録されている日誌が選択されています。";
			request.setAttribute("message", errorMsg);
			response.sendRedirect("CanInputResistListServlet");
		}
	}

}
