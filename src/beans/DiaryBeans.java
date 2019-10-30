package beans;
import java.io.Serializable;

public class DiaryBeans implements Serializable{

	private String createDate;
	private String classCode;
	private String userId;
	private String goodPoint;
	private String badPoint;
	private String stdCom;
	private String tcrCom;


	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
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
	public void setTcr_com(String tcrCom) {
		this.tcrCom = tcrCom;
	}


}
