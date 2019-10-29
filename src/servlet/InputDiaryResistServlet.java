package servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		Calendar cal = Calendar.getInstance();
		//日付を設定
		String day =Integer.toString(cal.get(Calendar.YEAR))+"年 "+Integer.toString(cal.get(Calendar.MONTH)+1)+"月 "+Integer.toString(cal.get(Calendar.DATE))+"日";
		request.setAttribute("day",day);
		request.getRequestDispatcher("WEB-INF/jsp/inputDiary.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
