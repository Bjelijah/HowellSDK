package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/19.
 */

public class MCUDeviceAuthenticatedReq {
    String UUID;

    @Override
    public String toString() {
        return "MCUDeviceAuthenticatedReq{" +
                "UUID='" + UUID + '\'' +
                '}';
    }

    public MCUDeviceAuthenticatedReq() {
    }

    public MCUDeviceAuthenticatedReq(String UUID) {

        this.UUID = UUID;
    }

    public String getUUID() {

        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }
}
