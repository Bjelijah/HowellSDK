package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/19.
 */

public class DeviceSharingSourceRes {
    String result;
    String sharingSourceAccount;

    @Override
    public String toString() {
        return "DeviceSharingSourceRes{" +
                "result='" + result + '\'' +
                ", sharingSourceAccount='" + sharingSourceAccount + '\'' +
                '}';
    }

    public DeviceSharingSourceRes() {
    }

    public DeviceSharingSourceRes(String result, String sharingSourceAccount) {

        this.result = result;
        this.sharingSourceAccount = sharingSourceAccount;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSharingSourceAccount() {
        return sharingSourceAccount;
    }

    public void setSharingSourceAccount(String sharingSourceAccount) {
        this.sharingSourceAccount = sharingSourceAccount;
    }
}
