package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/19.
 */

public class AndroidTokenRes {
    String result;
    String UDID;
    Boolean APNs;
    String deviceToken;

    @Override
    public String toString() {
        return "AndroidTokenRes{" +
                "result='" + result + '\'' +
                ", UDID='" + UDID + '\'' +
                ", APNs=" + APNs +
                ", deviceToken='" + deviceToken + '\'' +
                '}';
    }

    public AndroidTokenRes() {
    }

    public AndroidTokenRes(String result, String UDID, Boolean APNs, String deviceToken) {

        this.result = result;
        this.UDID = UDID;
        this.APNs = APNs;
        this.deviceToken = deviceToken;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
}
