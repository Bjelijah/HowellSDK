package com.howellsdk.net.soap.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/19.
 */

public class TrustedAuthorityLoginRes {
    String result;
    String session;
    Info info;
    String userName;
    String account;
    ArrayList<Device> devices;

    public ArrayList<Device> getDevices() {
        return devices;
    }

    public void setDevices(ArrayList<Device> devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "TrustedAuthorityLoginRes{" +
                "result='" + result + '\'' +
                ", session='" + session + '\'' +
                ", info=" + info +
                ", userName='" + userName + '\'' +
                ", account='" + account + '\'' +
                '}';
    }

    public TrustedAuthorityLoginRes() {
    }

    public TrustedAuthorityLoginRes(String result, String session, Info info, String userName, String account) {

        this.result = result;
        this.session = session;
        this.info = info;
        this.userName = userName;
        this.account = account;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public static class Info{
        String devID;
        int channelNo;
        String name;
        Boolean onLine;
        Boolean ptzFlag;
        int sharingFlag;
        int wirelessFlag;

        @Override
        public String toString() {
            return "Info{" +
                    "devID='" + devID + '\'' +
                    ", channelNo=" + channelNo +
                    ", name='" + name + '\'' +
                    ", onLine=" + onLine +
                    ", ptzFlag=" + ptzFlag +
                    ", sharingFlag=" + sharingFlag +
                    ", wirelessFlag=" + wirelessFlag +
                    '}';
        }

        public Info() {
        }

        public Info(String devID, int channelNo, String name, Boolean onLine, Boolean ptzFlag, int sharingFlag, int wirelessFlag) {

            this.devID = devID;
            this.channelNo = channelNo;
            this.name = name;
            this.onLine = onLine;
            this.ptzFlag = ptzFlag;
            this.sharingFlag = sharingFlag;
            this.wirelessFlag = wirelessFlag;
        }

        public String getDevID() {

            return devID;
        }

        public void setDevID(String devID) {
            this.devID = devID;
        }

        public int getChannelNo() {
            return channelNo;
        }

        public void setChannelNo(int channelNo) {
            this.channelNo = channelNo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Boolean getOnLine() {
            return onLine;
        }

        public void setOnLine(Boolean onLine) {
            this.onLine = onLine;
        }

        public Boolean getPtzFlag() {
            return ptzFlag;
        }

        public void setPtzFlag(Boolean ptzFlag) {
            this.ptzFlag = ptzFlag;
        }

        public int getSharingFlag() {
            return sharingFlag;
        }

        public void setSharingFlag(int sharingFlag) {
            this.sharingFlag = sharingFlag;
        }

        public int getWirelessFlag() {
            return wirelessFlag;
        }

        public void setWirelessFlag(int wirelessFlag) {
            this.wirelessFlag = wirelessFlag;
        }
    }


}
