package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/19.
 */

public class nullifyDeviceForcibleReq {
    String account;
    String session;
    String devID;
    String devKey;
    Integer channelNo;

    @Override
    public String toString() {
        return "nullifyDeviceForcibleReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devID='" + devID + '\'' +
                ", devKey='" + devKey + '\'' +
                ", channelNo='" + channelNo + '\'' +
                '}';
    }

    public nullifyDeviceForcibleReq() {
    }

    public nullifyDeviceForcibleReq(String account, String session, String devID, String devKey, int channelNo) {

        this.account = account;
        this.session = session;
        this.devID = devID;
        this.devKey = devKey;
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

    public String getDevKey() {
        return devKey;
    }

    public void setDevKey(String devKey) {
        this.devKey = devKey;
    }

    public Integer getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(Integer channelNo) {
        this.channelNo = channelNo;
    }
}
