package dao;

import java.sql.SQLException;

import beans.LoginInfoBeans;

public class UserDao extends DaoBase{


	public LoginInfoBeans getBy(String userId, String password) {

		//アカウントがあるかを調べる（ログイン処理）
		LoginInfoBeans loginInfo = new LoginInfoBeans();
		try {
			super.connect();
			stmt = this.con.prepareStatement("SELECT * FROM students WHERE student_id = ? AND student_password = ?;");
			stmt.setString(1, userId);
			stmt.setString(2, password);
			rs = this.stmt.executeQuery();
			rs.next();

			loginInfo.setUserId(this.rs.getString("student_id"));
			loginInfo.setUserName(this.rs.getString("student_name"));

			super.close();

		}catch(SQLException e) {
			loginInfo = null;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return loginInfo;
	}
}
