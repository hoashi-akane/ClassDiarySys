package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.DiaryListBeans;

public class DiaryDao extends DaoBase{

//	クラスの日誌一覧を取得
	public List<DiaryListBeans> getDiaryList(String classCode){
//		格納用
		List<DiaryListBeans> diaryList = new ArrayList<DiaryListBeans>();


		try {
			super.connect();
			stmt = this.con.prepareStatement("select d.insert_date, d.good_point, d.bad_point,d.student_comment, d.teacher_comment, s.student_name" +
					"from diary as d inner join student as s on d.student_id = s.student_id"+
					"where class_code = ?");
			stmt.setString(1, classCode);
			rs = stmt.executeQuery();
			while(rs.next()) {
				DiaryListBeans diary = new DiaryListBeans();
				diary.setCreateDate(this.rs.getString("insert_date"));
				diary.setGoodPoint(this.rs.getString("good_point"));
				diary.setBadPoint(this.rs.getString("bad_point"));
				diary.setStd_com(this.rs.getString("student_comment"));
				diary.setTcr_com(this.rs.getString("teacher_comment"));
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
}
