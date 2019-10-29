package beans;
import java.io.Serializable;

public class DiaryBeans implements Serializable{

	private String createDate;
	private String classCode;
	private String userId;
	private String goodPoint;
	private String badPoint;
	private String std_com;
	private String tcr_com;


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
	public String getStd_com() {
		return std_com;
	}
	public void setStd_com(String std_com) {
		this.std_com = std_com;
	}
	public String getTcr_com() {
		return tcr_com;
	}
	public void setTcr_com(String tcr_com) {
		this.tcr_com = tcr_com;
	}


}
