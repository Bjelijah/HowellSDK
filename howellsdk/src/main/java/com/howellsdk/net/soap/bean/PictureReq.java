package com.howellsdk.net.soap.bean;
/**
 * @author 霍之昊 
 *
 * 类说明
 */
public class PictureReq {
	private String account;
	private String loginSession;
	private String pictureID;
	public PictureReq(String account, String loginSession, String pictureID) {
		super();
		this.account = account;
		this.loginSession = loginSession;
		this.pictureID = pictureID;
	}
	public PictureReq() {
		super();
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
	public String getPictureID() {
		return pictureID;
	}
	public void setPictureID(String pictureID) {
		this.pictureID = pictureID;
	}
	
	

}
