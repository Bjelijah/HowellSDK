package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/16.
 */

public class PasswordReq {
    String account;
    String getBackType;

    @Override
    public String toString() {
        return "PasswordReq{" +
                "account='" + account + '\'' +
                ", getBackType='" + getBackType + '\'' +
                '}';
    }

    public PasswordReq(String account, String getBackType) {
        this.account = account;
        this.getBackType = getBackType;
    }

    public String getAccount() {

        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getGetBackType() {
        return getBackType;
    }

    public void setGetBackType(String getBackType) {
        this.getBackType = getBackType;
    }
}
