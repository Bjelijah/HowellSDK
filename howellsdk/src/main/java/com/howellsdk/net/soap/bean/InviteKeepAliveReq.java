package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/16.
 */

public class InviteKeepAliveReq {
    String account;
    String session;
    String dialogID;

    @Override
    public String toString() {
        return "InviteKeepAliveReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", dialogID='" + dialogID + '\'' +
                '}';
    }

    public InviteKeepAliveReq() {
    }

    public InviteKeepAliveReq(String account, String session, String dialogID) {

        this.account = account;
        this.session = session;
        this.dialogID = dialogID;
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
}
