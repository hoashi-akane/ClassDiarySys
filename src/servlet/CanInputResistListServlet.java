package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LoginInfoBeans;
import dao.DiaryDao;

/**
 * Servlet implementation class CanInputResistListServlet
 */
@WebServlet("/CanInputResistListServlet")
public class CanInputResistListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CanInputResistListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String classCode = ((LoginInfoBeans)session.getAttribute("loginInfo")).getClassCode();
		DiaryDao diaryDao = new DiaryDao();

		String message = (String)request.getAttribute("massage");
		if(message == null) {
			message = "";
		}
		request.setAttribute("message", message);

		//登録できない日付が入っている
		List<String> diaryDateList = diaryDao.getDiaryDateList(classCode);

		//登録できる日付を入れる
		List<String> canInputDiary = new ArrayList<String>();


		Calendar cal = Calendar.getInstance();
//		31日前まで（1か月) DATE型に変換しても-1が12月として認識されたからOK
		cal.add(Calendar.MONTH , -1);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


		for(int i = 0; i < 31; i++) {
			String day = sdf.format(cal.getTime()).toString();

			if(diaryDateList != null && diaryDateList.size() > 0) {

				if(day.equals(diaryDateList.get(0))){

					diaryDateList.remove(0);
				}else {
					canInputDiary.add(day);
				}
			}else {
				canInputDiary.add(day);
			}
			cal.add(Calendar.DAY_OF_MONTH, 1);
		}
		request.setAttribute("canInputDiary", canInputDiary);
		request.getRequestDispatcher("WEB-INF/jsp/canInputDiary.jsp").forward(request, response);
	}
}
