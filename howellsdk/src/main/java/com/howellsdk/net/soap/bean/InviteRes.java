package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/16.
 */

public class InviteRes {
    String result;
    String dialogId;
    String sdpMessage;

    @Override
    public String toString() {
        return "InviteRes{" +
                "result='" + result + '\'' +
                ", dialogId='" + dialogId + '\'' +
                ", sdpMessage='" + sdpMessage + '\'' +
                '}';
    }

    public InviteRes() {
    }

    public InviteRes(String result, String dialogId, String sdpMessage) {

        this.result = result;
        this.dialogId = dialogId;
        this.sdpMessage = sdpMessage;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
