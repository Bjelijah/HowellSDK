package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/14.
 */

public class CodingParamReq {
    String account;
    String session;
    String devId;
    int channelNo;
    String streamType;

    @Override
    public String toString() {
        return "CodingParamReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devId='" + devId + '\'' +
                ", channelNo=" + channelNo +
                ", streamType='" + streamType + '\'' +
                '}';
    }

    public CodingParamReq() {
    }

    public CodingParamReq(String account, String session, String devId, int channelNo, String streamType) {

        this.account = account;
        this.session = session;
        this.devId = devId;
        this.channelNo = channelNo;
        this.streamType = streamType;
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

    public int getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(int channelNo) {
        this.channelNo = channelNo;
    }

    public String getStreamType() {
        return streamType;
    }

    public void setStreamType(String streamType) {
        this.streamType = streamType;
    }
}
