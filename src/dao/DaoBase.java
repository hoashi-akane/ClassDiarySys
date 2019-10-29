package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class DaoBase {

	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	int rsno = 0;


	//DB
	DataSource ds = null;

	public void connect() {
		try {
			//JDBCドライバロード
			Class.forName("com.mysql.cj.jdbc.Driver");
			//指定するDB接続
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/diary1801182?characterEncoding=UTF-8&serverTimezone=JST","root","root");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		//接続したものが空でなければ閉じる
		try {
			if(rs != null) {
				rs.close();
			}if(con != null) {
				con.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
