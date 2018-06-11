package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/15.
 */

public class SetTimeReq {
    String account;
    String session;
    String devId;
    String time;
    String timeZone;
    String POSIXTimeZone;

    @Override
    public String toString() {
        return "SetTimeReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devId='" + devId + '\'' +
                ", time='" + time + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", POSIXTimeZone='" + POSIXTimeZone + '\'' +
                '}';
    }

    public SetTimeReq() {
    }

    public SetTimeReq(String account, String session, String devId, String time, String timeZone, String POSIXTimeZone) {

        this.account = account;
        this.session = session;
        this.devId = devId;
        this.time = time;
        this.timeZone = timeZone;
        this.POSIXTimeZone = POSIXTimeZone;
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

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getPOSIXTimeZone() {
        return POSIXTimeZone;
    }

    public void setPOSIXTimeZone(String POSIXTimeZone) {
        this.POSIXTimeZone = POSIXTimeZone;
    }
}
