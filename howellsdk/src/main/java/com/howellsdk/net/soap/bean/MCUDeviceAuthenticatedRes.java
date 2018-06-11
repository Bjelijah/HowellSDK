package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/19.
 */

public class MCUDeviceAuthenticatedRes {
    String result;
    Boolean authenticated;

    @Override
    public String toString() {
        return "MCUDeviceAuthenticatedRes{" +
                "result='" + result + '\'' +
                ", authenticated=" + authenticated +
                '}';
    }

    public MCUDeviceAuthenticatedRes() {
    }

    public MCUDeviceAuthenticatedRes(String result, Boolean authenticated) {

        this.result = result;
        this.authenticated = authenticated;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }
}
