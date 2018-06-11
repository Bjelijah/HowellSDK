package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/16.
 */

public class GetAuxiliaryReq {
    String account;
    String session;
    String devID;
    String auxiliary;

    @Override
    public String toString() {
        return "GetAuxiliaryReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devID='" + devID + '\'' +
                ", auxiliary='" + auxiliary + '\'' +
                '}';
    }

    public GetAuxiliaryReq() {
    }

    public GetAuxiliaryReq(String account, String session, String devID, String auxiliary) {

        this.account = account;
        this.session = session;
        this.devID = devID;
        this.auxiliary = auxiliary;
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

    public String getAuxiliary() {
        return auxiliary;
    }

    public void setAuxiliary(String auxiliary) {
        this.auxiliary = auxiliary;
    }
}
