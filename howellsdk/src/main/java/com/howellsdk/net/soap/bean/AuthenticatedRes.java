package com.howellsdk.net.soap.bean;

/**
 * query result if this phone has been authenticated to server<br/>
 * @author howell
 */
public class AuthenticatedRes {
	String Result;
	boolean Authenticated;
	public String getResult() {
		return Result;
	}
	public void setResult(String result) {
		Result = result;
	}
	public boolean isAuthenticated() {
		return Authenticated;
	}
	public void setAuthenticated(boolean authenticated) {
		Authenticated = authenticated;
	}
	public AuthenticatedRes(String result, boolean authenticated) {
		super();
		Result = result;
		Authenticated = authenticated;
	}
	public AuthenticatedRes() {
		super();
	}
	@Override
	public String toString() {
		return "AuthenticatedRes [Result=" + Result + ", Authenticated=" + Authenticated + "]";
	}
	
}
