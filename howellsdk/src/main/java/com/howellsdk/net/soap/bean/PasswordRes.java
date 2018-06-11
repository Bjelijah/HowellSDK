package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/16.
 */

public class PasswordRes {
    String result;
    String address;

    @Override
    public String toString() {
        return "PasswordRes{" +
                "result='" + result + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public PasswordRes() {
    }

    public PasswordRes(String result, String address) {

        this.result = result;
        this.address = address;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
