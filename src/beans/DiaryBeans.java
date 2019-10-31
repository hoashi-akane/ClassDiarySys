package beans;
import java.io.Serializable;

public class DiaryBeans implements Serializable{

	private String insertDate;
	private String classCode;
	private String userId;
	private String goodPoint;
	private String badPoint;
	private String stdCom;
	private String tcrCom;


	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGoodPoint() {
		return goodPoint;
	}
	public void setGoodPoint(String goodPoint) {
		this.goodPoint = goodPoint;
	}
	public String getBadPoint() {
		return badPoint;
	}
	public void setBadPoint(String badPoint) {
		this.badPoint = badPoint;
	}
	public String getStdCom() {
		return stdCom;
	}
	public void setStdCom(String stdCom) {
		this.stdCom = stdCom;
	}
	public String getTcrCom() {
		return tcrCom;
	}
	public void setTcr_Com(String tcrCom) {
		this.tcrCom = tcrCom;
	}


}
