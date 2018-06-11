package com.howellsdk.net.soap.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/19.
 */

public class AddDeviceForceibleReq {
    String account;
    String session;
    ArrayList<Device> devices;

    @Override
    public String toString() {
        return "AddDeviceForceibleReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devices=" + devices +
                '}';
    }

    public AddDeviceForceibleReq() {
    }

    public AddDeviceForceibleReq(String account, String session, ArrayList<Device> devices) {

        this.account = account;
        this.session = session;
        this.devices = devices;
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

    public ArrayList<Device> getDevices() {
        return devices;
    }

    public void setDevices(ArrayList<Device> devices) {
        this.devices = devices;
    }

    public static class Device{
        String devID;
        String devKey;
        Integer channelNo;
        String devName;

        @Override
        public String toString() {
            return "Device{" +
                    "devID='" + devID + '\'' +
                    ", devKey='" + devKey + '\'' +
                    ", channelNo=" + channelNo +
                    ", devName='" + devName + '\'' +
                    '}';
        }

        public Device() {
        }

        public Device(String devID, String devKey, int channelNo, String devName) {

            this.devID = devID;
            this.devKey = devKey;
            this.channelNo = channelNo;
            this.devName = devName;
        }

        public String getDevID() {

            return devID;
        }

        public void setDevID(String devID) {
            this.devID = devID;
        }

        public String getDevKey() {
            return devKey;
        }

        public void setDevKey(String devKey) {
            this.devKey = devKey;
        }

        public Integer getChannelNo() {
            return channelNo;
        }

        public void setChannelNo(Integer channelNo) {
            this.channelNo = channelNo;
        }

        public String getDevName() {
            return devName;
        }

        public void setDevName(String devName) {
            this.devName = devName;
        }
    }
}
