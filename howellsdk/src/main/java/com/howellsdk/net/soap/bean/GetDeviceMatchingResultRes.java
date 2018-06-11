package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/19.
 */

public class GetDeviceMatchingResultRes {
    String result;
    String devID;

    @Override
    public String toString() {
        return "GetDeviceMatchingResultRes{" +
                "result='" + result + '\'' +
                ", devID='" + devID + '\'' +
                '}';
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDevID() {
        return devID;
    }

    public void setDevID(String devID) {
        this.devID = devID;
    }

    public GetDeviceMatchingResultRes() {

    }

    public GetDeviceMatchingResultRes(String result, String devID) {

        this.result = result;
        this.devID = devID;
    }
}
