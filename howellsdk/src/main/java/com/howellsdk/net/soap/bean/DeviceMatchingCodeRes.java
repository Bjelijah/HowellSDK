package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/19.
 */

public class DeviceMatchingCodeRes {
    String result;
    String matchCode;

    public DeviceMatchingCodeRes() {
    }

    @Override

    public String toString() {
        return "DeviceMatchingCodeRes{" +
                "result='" + result + '\'' +
                ", matchCode='" + matchCode + '\'' +
                '}';
    }

    public DeviceMatchingCodeRes(String result, String matchCode) {
        this.result = result;
        this.matchCode = matchCode;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMatchCode() {
        return matchCode;
    }

    public void setMatchCode(String matchCode) {
        this.matchCode = matchCode;
    }
}
