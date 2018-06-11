package com.howellsdk.net.soap.bean;

public class NATServerReq {
	private String account;
	private String loginSession;
	public NATServerReq(String account, String loginSession) {
		super();
		this.account = account;
		this.loginSession = loginSession;
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
	
}
