package servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
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

	private static final String ALGORITHM = "PBKDF2WithHmacSHA256";
	private static final int ITERATION_COUNT = 13142;
	private static final int KEY_LENGTH = 256;
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

		//遷移先
		String path = "";
		HttpSession session = request.getSession();

		if(check == null) {
			//パスワード保持にチェックが入っていない
			password="";
		}else {
			session.setAttribute("password", password);
		}

		//　ハッシュ処理
		char[] passCharArray = password.toCharArray();
		byte[] salt = userDao.getSalt(userId);

		PBEKeySpec keySpec = new PBEKeySpec(passCharArray, salt, ITERATION_COUNT, KEY_LENGTH);

		SecretKeyFactory skf;

		try {
			skf = SecretKeyFactory.getInstance(ALGORITHM);
		}catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

		SecretKey secretKey;
		try {
			secretKey = skf.generateSecret(keySpec);
		}catch(InvalidKeySpecException e) {
			throw new RuntimeException(e);
		}
		byte[] passByteArray = secretKey.getEncoded();

		//16進数の文字列に変換
		StringBuilder sb = new StringBuilder(64);
		for(byte b : passByteArray) {
			sb.append(String.format("%02x", b & 0xff));
		}
		String hashPass = sb.toString();

		LoginInfoBeans loginInfo = userDao.getBy(userId,hashPass);

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
