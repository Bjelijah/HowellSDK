package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/14.
 */

public class RebootReq {
    String account;
    String session;
    String devID;

    @Override
    public String toString() {
        return "RebootReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devID='" + devID + '\'' +
                '}';
    }

    public RebootReq() {
    }

    public RebootReq(String account, String session, String devID) {

        this.account = account;
        this.session = session;
        this.devID = devID;
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

    public String getDevID() {
        return devID;
    }

    public void setDevID(String devID) {
        this.devID = devID;
    }
}
