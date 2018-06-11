package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/16.
 */

public class NotifyNATResultReq {
    String account;
    String session;
    String dialogID;
    String NATType;

    @Override
    public String toString() {
        return "NotifyNATResultReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", dialogID='" + dialogID + '\'' +
                ", NATType='" + NATType + '\'' +
                '}';
    }

    public NotifyNATResultReq() {
    }

    public NotifyNATResultReq(String account, String session, String dialogID, String NATType) {

        this.account = account;
        this.session = session;
        this.dialogID = dialogID;
        this.NATType = NATType;
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

    public String getDialogID() {
        return dialogID;
    }

    public void setDialogID(String dialogID) {
        this.dialogID = dialogID;
    }

    public String getNATType() {
        return NATType;
    }

    public void setNATType(String NATType) {
        this.NATType = NATType;
    }
}
