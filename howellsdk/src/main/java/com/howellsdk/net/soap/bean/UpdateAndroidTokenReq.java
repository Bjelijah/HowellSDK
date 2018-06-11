package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/16.
 */

public class UpdateAndroidTokenReq {
    String account;
    String session;
    String UDID;
    Boolean APNs;
    String deviceToken;
    String androidOS;

    @Override
    public String toString() {
        return "UpdateAndroidTokenReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", UDID='" + UDID + '\'' +
                ", APNs=" + APNs +
                ", deviceToken='" + deviceToken + '\'' +
                ", androidOS='" + androidOS + '\'' +
                '}';
    }

    public UpdateAndroidTokenReq() {
    }

    public UpdateAndroidTokenReq(String account, String session, String UDID, Boolean APNs, String deviceToken, String androidOS) {

        this.account = account;
        this.session = session;
        this.UDID = UDID;
        this.APNs = APNs;
        this.deviceToken = deviceToken;
        this.androidOS = androidOS;
    }

    public String getAccount() {

        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getUDID() {
        return UDID;
    }

    public void setUDID(String UDID) {
        this.UDID = UDID;
    }

    public Boolean getAPNs() {
        return APNs;
    }

    public void setAPNs(Boolean APNs) {
        this.APNs = APNs;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getAndroidOS() {
        return androidOS;
    }

    public void setAndroidOS(String androidOS) {
        this.androidOS = androidOS;
    }
}
