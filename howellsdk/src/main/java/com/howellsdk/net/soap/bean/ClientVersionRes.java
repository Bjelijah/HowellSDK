package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/19.
 */

public class ClientVersionRes {
    String result;
    String version;
    String downloadAddress;

    @Override
    public String toString() {
        return "ClientVersionRes{" +
                "result='" + result + '\'' +
                ", version='" + version + '\'' +
                ", downloadAddress='" + downloadAddress + '\'' +
                '}';
    }

    public ClientVersionRes() {
    }

    public ClientVersionRes(String result, String version, String downloadAddress) {

        this.result = result;
        this.version = version;
        this.downloadAddress = downloadAddress;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDownloadAddress() {
        return downloadAddress;
    }

    public void setDownloadAddress(String downloadAddress) {
        this.downloadAddress = downloadAddress;
    }
}
