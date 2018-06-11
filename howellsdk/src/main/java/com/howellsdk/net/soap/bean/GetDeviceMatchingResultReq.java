package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/19.
 */

public class GetDeviceMatchingResultReq {
    String account;
    String session;
    String matchingCode;

    @Override
    public String toString() {
        return "GetDeviceMatchingResultReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", matchingCode='" + matchingCode + '\'' +
                '}';
    }

    public GetDeviceMatchingResultReq() {
    }

    public GetDeviceMatchingResultReq(String account, String session, String matchingCode) {

        this.account = account;
        this.session = session;
        this.matchingCode = matchingCode;
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

    public String getMatchingCode() {
        return matchingCode;
    }

    public void setMatchingCode(String matchingCode) {
        this.matchingCode = matchingCode;
    }
}
