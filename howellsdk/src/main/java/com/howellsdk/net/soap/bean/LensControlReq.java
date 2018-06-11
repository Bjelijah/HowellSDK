package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/14.
 */

public class LensControlReq {
    String account;
    String session;
    String devID;
    int channelNo;
    String ptzLens;

    public LensControlReq(String account, String session, String devID, int channelNo, String ptzLens) {
        this.account = account;
        this.session = session;
        this.devID = devID;
        this.channelNo = channelNo;
        this.ptzLens = ptzLens;
    }

    public LensControlReq() {
    }

    @Override
    public String toString() {
        return "LensControlReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devID='" + devID + '\'' +
                ", channelNo=" + channelNo +
                ", ptzLens='" + ptzLens + '\'' +
                '}';
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

    public String getPtzLens() {
        return ptzLens;
    }

    public void setPtzLens(String ptzLens) {
        this.ptzLens = ptzLens;
    }
}
