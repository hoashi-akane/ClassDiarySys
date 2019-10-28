package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LoginInfoBeans;
import dao.UserDao;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String check = request.getParameter("pwdkeep");

		//daoインスタンス
		UserDao userDao = new UserDao();
		LoginInfoBeans loginInfo = userDao.getBy(userId,password);


		//遷移先
		String path = "";
		HttpSession session = request.getSession();

		if(check == null) {
			//パスワード保持にチェックが入っていない
			password="";
		}else {
			session.setAttribute("password", password);
		}
		if(loginInfo != null) {
			//取得できた
			session.setAttribute("loginInfo",loginInfo);
			path = "MenuServlet";
			response.sendRedirect(path);
		} else {
			//取得できない
			session.setAttribute("loginFailed", true);
			path = "/WEB-INF/jsp/login.jsp";
			String msg="正しい学籍番号またはパスワードを入力してください";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(path).forward(request, response);
		}

	}

}
