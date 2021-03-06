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
 * Servlet implementation class DispClassDiaryServlet
 */
@WebServlet("/DispClassDiaryServlet")
public class DispClassDiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispClassDiaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    //　リダイレクト対応 クラスが1つのみの場合
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	HttpSession session = request.getSession();
    	DiaryDao diaryDao = new DiaryDao();

    	// クラス一覧をセッションから取得
    	String classCode = (String)session.getAttribute("classCode");

    	List<DiaryListBeans> diaryList = new ArrayList<DiaryListBeans>();
		diaryList = diaryDao.getDiaryList(classCode);
		if(diaryList != null) {
			request.setAttribute("diaryList", diaryList);
			request.getRequestDispatcher("WEB-INF/jsp/tcrDispDiaryList.jsp").forward(request, response);
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String classCode = request.getParameter("classCode");
		DiaryDao diaryDao = new DiaryDao();
		List<DiaryListBeans> diaryList = new ArrayList<DiaryListBeans>();

		diaryList = diaryDao.getDiaryList(classCode);
		if(diaryList != null) {
			request.setAttribute("diaryList", diaryList);
			request.getRequestDispatcher("WEB-INF/jsp/tcrDispDiaryList.jsp").forward(request, response);
		}
	}

}
