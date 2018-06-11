package com.howellsdk.net.soap.bean;

public class DevVerRes {
	private String result;
	private String CurDevVer;
	private String NewDevVer;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getCurDevVer() {
		return CurDevVer;
	}
	public void setCurDevVer(String curDevVer) {
		CurDevVer = curDevVer;
	}
	public String getNewDevVer() {
		return NewDevVer;
	}
	public void setNewDevVer(String newDevVer) {
		NewDevVer = newDevVer;
	}
	@Override
	public String toString() {
		return "DevVerRes [result=" + result + ", CurDevVer=" + CurDevVer
				+ ", NewDevVer=" + NewDevVer + "]";
	}
	

}
