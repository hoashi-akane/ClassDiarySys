package servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LoginInfoBeans;
import dao.DiaryDao;

/**
 * Servlet implementation class InputDiaryResistServlet
 */
@WebServlet("/InputDiaryResistServlet")
public class InputDiaryResistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputDiaryResistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		Calendar cal = Calendar.getInstance();
		//日付を設定
		String day = Integer.toString(cal.get(Calendar.YEAR))+"/"+Integer.toString(cal.get(Calendar.MONTH)+1)+"/"+Integer.toString(cal.get(Calendar.DATE));

		String message = (String)request.getAttribute("message");
		if(message == null) {
			message ="";
		}
		request.setAttribute("message", message);

		String classCode = ((LoginInfoBeans)session.getAttribute("loginInfo")).getClassCode();
		DiaryDao diaryDao= new DiaryDao();
//	今日の日誌を登録できるか調べる。できれば今日の日誌用の登録画面へ　無理なら過去の日誌登録画面へ遷移
		if(diaryDao.insertDiaryChecker(classCode, day)) {
			request.setAttribute("day",day);
			request.getRequestDispatcher("WEB-INF/jsp/inputDiary.jsp").forward(request, response);
		}else {
//	ここに入れるのは一覧から入力できる公欠日を取得するサーブレットの値

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
