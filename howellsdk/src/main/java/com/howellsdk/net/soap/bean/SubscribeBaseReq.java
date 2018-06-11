package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/16.
 */

public class SubscribeBaseReq {
    String account;
    String session;
    int subscribedFlag;
    String devID;
    int channelNo;


    @Override
    public String toString() {
        return "SubscribeBaseReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", subscribedFlag=" + subscribedFlag +
                ", devID='" + devID + '\'' +
                ", channelNo=" + channelNo +
                '}';
    }

    public SubscribeBaseReq() {
    }

    public SubscribeBaseReq(String account, String session, int subscribedFlag, String devID, int channelNo) {

        this.account = account;
        this.session = session;
        this.subscribedFlag = subscribedFlag;
        this.devID = devID;
        this.channelNo = channelNo;
    }

    public int getSubscribedFlag() {

        return subscribedFlag;
    }

    public void setSubscribedFlag(int subscribedFlag) {
        this.subscribedFlag = subscribedFlag;
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
