package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.LoginInfoBeans;
import beans.TcrClassInfoBeans;
import beans.TcrLoginInfoBeans;

public class UserDao extends DaoBase{


	public LoginInfoBeans getBy(String userId, String password) {

		//アカウントがあるかを調べる（ログイン処理）
		LoginInfoBeans loginInfo = new LoginInfoBeans();
		try {
			// ユーザ情報、クラスコード取得
			super.connect();
			stmt = this.con.prepareStatement("SELECT * FROM student WHERE student_id = ? AND student_password = ?;");
			stmt.setString(1, userId);
			stmt.setString(2, password);
			rs = this.stmt.executeQuery();
			rs.next();

			loginInfo.setUserId(this.rs.getString("student_id"));
			loginInfo.setUserName(this.rs.getString("student_name"));
			loginInfo.setClassCode(this.rs.getString("class_code"));

			// クラス名とコース情報を取得
			stmt = this.con.prepareStatement("SELECT class.class_name,course.course_code, course.course_name FROM class inner join course ON class.course_code = course.course_code WHERE class.class_code = ?");
			stmt.setString(1, loginInfo.getClassCode());
			rs = this.stmt.executeQuery();
			rs.next();

			loginInfo.setClassName(this.rs.getString("class_name"));
			loginInfo.setCourseCode(this.rs.getString("course_code"));
			loginInfo.setCourseName(this.rs.getString("course_name"));

			super.close();

		}catch(SQLException e) {
			loginInfo = null;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return loginInfo;
	}

// ユーザーIDからソルトを取得する
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
			salt = null;
		}
		return salt;
	}

	//教員用ログイン処理
	public TcrLoginInfoBeans getTcrBy(String userId, String password) {

		//アカウントがあるか調べr
		TcrLoginInfoBeans tcrLoginInfo = new TcrLoginInfoBeans();

		try {
			super.connect();
			stmt = this.con.prepareStatement("SELECT * FROM teacher WHERE teacher_code = ? AND teacher_password = ?");
			stmt.setString(1, userId);
			stmt.setString(2, password);
			rs = this.stmt.executeQuery();

			rs.next();
			tcrLoginInfo.setUserId(this.rs.getString("teacher_code"));
			tcrLoginInfo.setUserName(this.rs.getString("teacher_name"));
			super.close();

		}catch(SQLException e) {
			tcrLoginInfo = null;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return tcrLoginInfo;
	}

	// ユーザーIDからソルトを取得する
	public byte[] getTcrSalt(String userId) {

		byte[] salt;
		try {
			super.connect();
			stmt = this.con.prepareStatement("SELECT salt FROM teacher WHERE teacher_code = ?;");
			stmt.setString(1, userId);
			rs = this.stmt.executeQuery();
			rs.next();
			salt = this.rs.getBytes("salt");

		}catch(SQLException e) {
			salt = null;
		}
		return salt;
	}

	//　教員クラス判別
	public List<TcrClassInfoBeans> getTcrClass(String userId) {

		List<TcrClassInfoBeans> tcrClassList = new ArrayList<TcrClassInfoBeans>();

		try {
			super.connect();
			stmt = this.con.prepareStatement("SELECT class.class_code, class.class_name, course.course_name, class.grade FROM (class LEFT OUTER JOIN teacher ON class.teacher_code = teacher.teacher_code) left outer join course on class.course_code = course.course_code WHERE teacher.teacher_code = ? ORDER BY course.course_code ASC,class.grade DESC,class.class_code ASC");
			stmt.setString(1, userId);
			rs = this.stmt.executeQuery();
			while(rs.next()) {
				TcrClassInfoBeans tcrClass = new TcrClassInfoBeans();
				tcrClass.setClassCode(this.rs.getString("class_code"));
				tcrClass.setClassName(this.rs.getString("class_name"));
				tcrClass.setCourseName(this.rs.getString("course_name"));
				tcrClass.setGrade(this.rs.getString("grade"));

				tcrClassList.add(tcrClass);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			tcrClassList = null;
		}
		return tcrClassList;
	}
}
