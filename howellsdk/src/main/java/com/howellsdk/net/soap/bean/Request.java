package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/15.
 */

public class Request {
    String account;
    String session;
    String devID;
    int channelNo;

    @Override
    public String toString() {
        return "Request{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devID='" + devID + '\'' +
                ", channelId=" + channelNo +
                '}';
    }

    public Request() {
    }

    public Request(String account, String session, String devID, int channelNo) {

        this.account = account;
        this.session = session;
        this.devID = devID;
        this.channelNo = channelNo;
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

    public int getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(int channelNo) {
        this.channelNo = channelNo;
    }
}
