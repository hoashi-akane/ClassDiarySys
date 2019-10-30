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
@WebServlet("/ConfirmDiaryResistServlet")
public class ConfirmDiaryResistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmDiaryResistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		String nowday =Integer.toString(cal.get(Calendar.YEAR))+"年 "+Integer.toString(cal.get(Calendar.MONTH)+1)+"月 "+Integer.toString(cal.get(Calendar.DATE))+"日";
		String inputDay = request.getParameter("day");
		String message ="";
		if(nowday != inputDay) {
			message = "現在の日付と記入された時点の日付が異なります。";
		}else {
			//	セッションの開始と重複確認
			HttpSession session = request.getSession();
			DiaryDao diaryDao = new DiaryDao();
			LoginInfoBeans loginInfo = (LoginInfoBeans)session.getAttribute("loginInfo");
			//			重複しなければif通る
			if(diaryDao.insertDiaryChecker(loginInfo.getClassCode(),inputDay)) {
				String good = request.getParameter("good");
				String bad = request.getParameter("bad");
				String com = request.getParameter("com");
				DiaryBeans diaryBeans = new DiaryBeans();
				diaryBeans.setGoodPoint(good);
				diaryBeans.setBadPoint(bad);
				diaryBeans.setStdCom(com);
			}else {
				message = "その日付の日誌は既に他のユーザーにより登録されています！";
		}
		}
	}

}
