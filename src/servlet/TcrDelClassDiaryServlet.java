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
import dao.DiaryDao;

/**
 * Servlet implementation class TcrDelClassDiaryServlet
 */
@WebServlet("/TcrDelClassDiaryServlet")
public class TcrDelClassDiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TcrDelClassDiaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
    	String classCode = request.getParameter("classCode");
		DiaryDao diaryDao = new DiaryDao();
		List<DiaryListBeans> diaryList = new ArrayList<DiaryListBeans>();

		diaryList = diaryDao.getDiaryList(classCode);
		if(diaryList != null) {
			session.setAttribute("classCode", classCode);
			request.setAttribute("diaryList", diaryList);
			request.getRequestDispatcher("WEB-INF/jsp/tcrDelDiary.jsp").forward(request, response);
		}
	}

}
