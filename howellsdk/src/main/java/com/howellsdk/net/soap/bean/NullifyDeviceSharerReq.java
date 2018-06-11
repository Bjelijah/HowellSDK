package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/19.
 */

public class NullifyDeviceSharerReq {
    String account;
    String session;
    String devID;
    int channelNo;
    String sharerASccount;

    @Override
    public String toString() {
        return "NullifyDeviceSharerReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devID='" + devID + '\'' +
                ", channelNo=" + channelNo +
                ", sharerASccount='" + sharerASccount + '\'' +
                '}';
    }

    public NullifyDeviceSharerReq() {
    }

    public NullifyDeviceSharerReq(String account, String session, String devID, int channelNo, String sharerASccount) {

        this.account = account;
        this.session = session;
        this.devID = devID;
        this.channelNo = channelNo;
        this.sharerASccount = sharerASccount;
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

    public String getSharerASccount() {
        return sharerASccount;
    }

    public void setSharerASccount(String sharerASccount) {
        this.sharerASccount = sharerASccount;
    }
}
