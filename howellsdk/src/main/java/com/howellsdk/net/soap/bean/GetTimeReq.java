package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/15.
 */

public class GetTimeReq {
    String account;
    String session;
    String devId;

    public GetTimeReq() {
    }

    public GetTimeReq(String account, String session, String devId) {

        this.account = account;
        this.session = session;
        this.devId = devId;
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
}
