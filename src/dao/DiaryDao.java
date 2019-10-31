package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.DiaryBeans;
import beans.DiaryListBeans;

public class DiaryDao extends DaoBase{

//	クラスの日誌一覧を取得
	public List<DiaryListBeans> getDiaryList(String classCode){
//		格納用
		List<DiaryListBeans> diaryList = new ArrayList<DiaryListBeans>();


		try {
			super.connect();
			stmt = this.con.prepareStatement("SELECT d.insert_date, d.good_point, d.bad_point,d.student_comment, d.teacher_comment, s.student_name FROM diary AS d INNER JOIN student AS s ON d.student_id = s.student_id WHERE d.class_code = ?");
			this.stmt.setString(1, classCode);
			rs = this.stmt.executeQuery();
			while(rs.next()) {
				DiaryListBeans diary = new DiaryListBeans();
				diary.setInsertDate(this.rs.getString("insert_date"));
				diary.setGoodPoint(this.rs.getString("good_point"));
				diary.setBadPoint(this.rs.getString("bad_point"));
				diary.setStdCom(this.rs.getString("student_comment"));
				diary.setTcrCom(this.rs.getString("teacher_comment"));
				diary.setUserName(this.rs.getString("student_name"));
				diaryList.add(diary);

			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			super.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return diaryList;
	}

	//	既に登録されているか調べる
	public boolean insertDiaryChecker(String className, String day) {

		boolean isSuccess = false;

		try {
			super.connect();
			stmt = this.con.prepareStatement("SELECT  * FROM diary WHERE class_code = ? and insert_date = ? ");
			this.stmt.setString(1, className);
			this.stmt.setString(2, day);
			rs = this.stmt.executeQuery();
//			なければtrue 既にある場合falseを返す
			isSuccess = !rs.next();

		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			super.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	//　日誌の登録を行う
	public boolean insertDiaryRegist(DiaryBeans diary){

		boolean isSuccess = false;
		try {
			super.connect();
			stmt = this.con.prepareStatement("INSERT INTO diary(class_code, insert_date, student_id, good_point, bad_point, student_comment, teacher_comment) VALUES(?,?,?,?,?,?,?);");
			this.stmt.setString(1, diary.getClassCode());
			this.stmt.setString(2, diary.getInsertDate());
			this.stmt.setString(3, diary.getUserId());
			this.stmt.setString(4, diary.getGoodPoint());
			this.stmt.setString(5, diary.getBadPoint());
			this.stmt.setString(6, diary.getStdCom());
			this.stmt.setString(7, diary.getTcrCom());
			this.stmt.executeUpdate();

			isSuccess = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			super.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
}
