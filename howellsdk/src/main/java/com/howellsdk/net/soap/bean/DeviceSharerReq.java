package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/19.
 */

public class DeviceSharerReq {
    String account;
    String session;
    String devID;
    int channelNo;
    String sharerAccount;
    int sharingPriority;
    String sharingName;

    @Override
    public String toString() {
        return "DeviceSharerReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devID='" + devID + '\'' +
                ", channelNo=" + channelNo +
                ", sharerAccount='" + sharerAccount + '\'' +
                ", sharingPriority=" + sharingPriority +
                ", sharingName='" + sharingName + '\'' +
                '}';
    }

    public DeviceSharerReq() {
    }

    public DeviceSharerReq(String account, String session, String devID, int channelNo, String sharerAccount, int sharingPriority, String sharingName) {

        this.account = account;
        this.session = session;
        this.devID = devID;
        this.channelNo = channelNo;
        this.sharerAccount = sharerAccount;
        this.sharingPriority = sharingPriority;
        this.sharingName = sharingName;
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

    public String getSharerAccount() {
        return sharerAccount;
    }

    public void setSharerAccount(String sharerAccount) {
        this.sharerAccount = sharerAccount;
    }

    public int getSharingPriority() {
        return sharingPriority;
    }

    public void setSharingPriority(int sharingPriority) {
        this.sharingPriority = sharingPriority;
    }

    public String getSharingName() {
        return sharingName;
    }

    public void setSharingName(String sharingName) {
        this.sharingName = sharingName;
    }
}
