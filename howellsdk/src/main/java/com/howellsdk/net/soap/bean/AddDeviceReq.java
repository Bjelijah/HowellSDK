package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/14.
 */

public class AddDeviceReq {
    String account;
    String session;
    String devId;
    String devKey;
    String devName;
    boolean forcible;

    public AddDeviceReq() {
    }

    @Override
    public String toString() {
        return "AddDeviceReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devId='" + devId + '\'' +
                ", devKey='" + devKey + '\'' +
                ", devName='" + devName + '\'' +
                ", forcible=" + forcible +
                '}';
    }

    public AddDeviceReq(String account, String session, String devId, String devKey, String devName, boolean forcible) {
        this.account = account;
        this.session = session;
        this.devId = devId;
        this.devKey = devKey;
        this.devName = devName;
        this.forcible = forcible;
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

    public String getDevKey() {
        return devKey;
    }

    public void setDevKey(String devKey) {
        this.devKey = devKey;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public boolean isForcible() {
        return forcible;
    }

    public void setForcible(boolean forcible) {
        this.forcible = forcible;
    }
}
