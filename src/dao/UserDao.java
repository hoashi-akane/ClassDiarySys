package dao;

import java.sql.SQLException;

import beans.LoginInfoBeans;

public class UserDao extends DaoBase{


	public LoginInfoBeans getBy(String userId, String password) {

		//アカウントがあるかを調べる（ログイン処理）
		LoginInfoBeans loginInfo = new LoginInfoBeans();
		try {
			super.connect();
			stmt = this.con.prepareStatement("SELECT * FROM student WHERE student_id = ? AND student_password = ?;");
			stmt.setString(1, userId);
			stmt.setString(2, password);
			rs = this.stmt.executeQuery();
			rs.next();

			loginInfo.setUserId(this.rs.getString("student_id"));
			loginInfo.setUserName(this.rs.getString("student_name"));
			loginInfo.setClassCode(this.rs.getString("class_code"));

			super.close();

		}catch(SQLException e) {
			loginInfo = null;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return loginInfo;
	}

	public byte[] getSalt(String userId) {

		byte[] salt;
		try {
			super.connect();
			stmt = this.con.prepareStatement("SELECT salt FROM student WHERE student_id = ?;");
			stmt.setString(1, userId);
			rs = this.stmt.executeQuery();
			rs.next();

			salt = this.rs.getBytes("salt");

		}catch(SQLException e) {
			salt = new byte[0];
			e.printStackTrace();
		}
		return salt;
	}
}
