package com.howellsdk.net.soap.bean;
/**
 * @author 霍之昊 
 *
 * 类说明
 */
public class NoticesReq {
	private String account;
	private String loginSession;
	private Integer pageNo;
	private String searchID;
	private Integer pageSize;
	private String status;
	private String time;
	private String sender;

	@Override
	public String toString() {
		return "NoticesReq{" +
				"account='" + account + '\'' +
				", loginSession='" + loginSession + '\'' +
				", pageNo=" + pageNo +
				", searchID='" + searchID + '\'' +
				", pageSize=" + pageSize +
				", status='" + status + '\'' +
				", time='" + time + '\'' +
				", sender='" + sender + '\'' +
				'}';
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getLoginSession() {
		return loginSession;
	}

	public void setLoginSession(String loginSession) {
		this.loginSession = loginSession;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public String getSearchID() {
		return searchID;
	}

	public void setSearchID(String searchID) {
		this.searchID = searchID;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public NoticesReq() {

	}

	public NoticesReq(String account, String loginSession, Integer pageNo, Integer pageSize, String searchID, String status, String time, String sender) {

		this.account = account;
		this.loginSession = loginSession;
		this.pageNo = pageNo;
		this.searchID = searchID;
		this.pageSize = pageSize;
		this.status = status;
		this.time = time;
		this.sender = sender;
	}
}
