package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/16.
 */

public class InviteReq {
    String account;
    String session;
    String devID;
    int ChannelNo;
    String streamType;
    String dialogId;
    String sdpMessage;

    @Override
    public String toString() {
        return "InviteReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devID='" + devID + '\'' +
                ", ChannelNo=" + ChannelNo +
                ", streamType='" + streamType + '\'' +
                ", dialogId='" + dialogId + '\'' +
                ", sdpMessage='" + sdpMessage + '\'' +
                '}';
    }

    public InviteReq() {
    }

    public InviteReq(String account, String session, String devID, int channelNo, String streamType, String dialogId, String sdpMessage) {

        this.account = account;
        this.session = session;
        this.devID = devID;
        ChannelNo = channelNo;
        this.streamType = streamType;
        this.dialogId = dialogId;
        this.sdpMessage = sdpMessage;
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
        return ChannelNo;
    }

    public void setChannelNo(int channelNo) {
        ChannelNo = channelNo;
    }

    public String getStreamType() {
        return streamType;
    }

    public void setStreamType(String streamType) {
        this.streamType = streamType;
    }

    public String getDialogId() {
        return dialogId;
    }

    public void setDialogId(String dialogId) {
        this.dialogId = dialogId;
    }

    public String getSdpMessage() {
        return sdpMessage;
    }

    public void setSdpMessage(String sdpMessage) {
        this.sdpMessage = sdpMessage;
    }
}
