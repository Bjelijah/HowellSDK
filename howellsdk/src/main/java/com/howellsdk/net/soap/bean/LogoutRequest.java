package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/14.
 */

public class LogoutRequest {
    String account;
    String session;

    @Override
    public String toString() {
        return "LogoutRequest{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                '}';
    }

    public LogoutRequest(String account, String session) {
        this.account = account;
        this.session = session;
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
}
