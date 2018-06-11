package com.howellsdk.net.soap.bean;

/**
 * query request if this phone has been authenticated to server<br/>
 * uuid the unique id of this phone (in this example we used imei);
 *
 * @author howell
 */
public class AuthenticatedReq {


	String UUID;

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public AuthenticatedReq(String uUID) {
		super();
		UUID = uUID;
	}

	@Override
	public String toString() {
		return "AuthenticatedReq [UUID=" + UUID + "]";
	}
	
}
