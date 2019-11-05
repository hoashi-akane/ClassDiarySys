package servlet;

import java.io.IOException;
import java.util.Calendar;

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
 * Servlet implementation class ConfirmDiaryResistServlet
 */
@WebServlet("/DiaryResistServlet")
public class DiaryResistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiaryResistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		String nowday =Integer.toString(cal.get(Calendar.YEAR))+"/"+Integer.toString(cal.get(Calendar.MONTH)+1)+"/"+Integer.toString(cal.get(Calendar.DATE));
		String inputDay = request.getParameter("day");
		String message ="";

		if(!(nowday.equals(inputDay))) {
			message = "現在の日付と記入された時点の日付が異なります。";
			request.setAttribute("message", message);
			response.sendRedirect("InputDiaryResistServlet");
		}else {

			HttpSession session = request.getSession();

			DiaryDao diaryDao = new DiaryDao();
			LoginInfoBeans loginInfo = (LoginInfoBeans)session.getAttribute("loginInfo");
			String classCode = loginInfo.getClassCode();

			String good = request.getParameter("good_com");
			String bad = request.getParameter("bad_com");
			String com = request.getParameter("std_com");

			DiaryBeans diaryBeans = new DiaryBeans();
			diaryBeans.setInsertDate(inputDay);
			diaryBeans.setClassCode(classCode);
			diaryBeans.setUserId(loginInfo.getUserId());
			diaryBeans.setGoodPoint(good);
			diaryBeans.setBadPoint(bad);
			diaryBeans.setStdCom(com);
			diaryBeans.setTcr_Com("");

			if(diaryDao.insertDiaryRegist(diaryBeans)) {
				request.getRequestDispatcher("WEB-INF/jsp/completeDiaryResist.jsp").forward(request, response);
			}else {
				message = "登録に失敗しました。今日の日誌は既に登録されている可能性があります。";
				request.setAttribute("message",message);
				response.sendRedirect("InputDiaryResistServlet");
			}
		}
	}
}

