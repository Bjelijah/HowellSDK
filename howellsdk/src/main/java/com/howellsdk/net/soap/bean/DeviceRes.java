package com.howellsdk.net.soap.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/15.
 */

public class DeviceRes {
    String result;
    ArrayList<NodeList> nodeLists;
    WirelessNetwork wirelessNetwork;

    @Override
    public String toString() {
        return "DeviceRes{" +
                "result='" + result + '\'' +
                ", nodes=" + nodeLists +
                ", wirelessNetwork=" + wirelessNetwork +
                '}';
    }

    public DeviceRes() {
    }

    public DeviceRes(String result, ArrayList<NodeList> nodeLists, WirelessNetwork wirelessNetwork) {

        this.result = result;
        this.nodeLists = nodeLists;
        this.wirelessNetwork = wirelessNetwork;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ArrayList<NodeList> getNodeLists() {
        return nodeLists;
    }

    public void setNodeLists(ArrayList<NodeList> nodeLists) {
        this.nodeLists = nodeLists;
    }

    public WirelessNetwork getWirelessNetwork() {
        return wirelessNetwork;
    }

    public void setWirelessNetwork(WirelessNetwork wirelessNetwork) {
        this.wirelessNetwork = wirelessNetwork;
    }

    public static class NodeList{
        String devID;
        int channelID;
        String name;
        Boolean onLIne;
        Boolean ptzFlag;
        int securityArea;
        int eStoreFlag;
        String upnpIP;
        int upnpPort;
        String devVer;
        int curVideoNum;
        String lastUpdated;
        int SmsSubscribedFlag;
        int eMailSubscribedFlag;
        int sharingFlag;
        int applePushSubscribedFlag;
        int androidPushSubscribedFlag;
        int infraredFlag;
        int wirelessFlag;

        @Override
        public String toString() {
            return "Node{" +
                    "devID='" + devID + '\'' +
                    ", channelID=" + channelID +
                    ", name='" + name + '\'' +
                    ", onLIne=" + onLIne +
                    ", ptzFlag=" + ptzFlag +
                    ", securityArea=" + securityArea +
                    ", eStoreFlag=" + eStoreFlag +
                    ", upnpIP='" + upnpIP + '\'' +
                    ", upnpPort=" + upnpPort +
                    ", devVer='" + devVer + '\'' +
                    ", curVideoNum=" + curVideoNum +
                    ", lastUpdated='" + lastUpdated + '\'' +
                    ", SmsSubscribedFlag=" + SmsSubscribedFlag +
                    ", eMailSubscribedFlag=" + eMailSubscribedFlag +
                    ", sharingFlag=" + sharingFlag +
                    ", applePushSubscribedFlag=" + applePushSubscribedFlag +
                    ", androidPushSubscribedFlag=" + androidPushSubscribedFlag +
                    ", infraredFlag=" + infraredFlag +
                    ", wirelessFlag=" + wirelessFlag +
                    '}';
        }

        public NodeList() {
        }

        public NodeList(String devID, int channelID, String name, Boolean onLIne, Boolean ptzFlag, int securityArea, int eStoreFlag, String upnpIP, int upnpPort, String devVer, int curVideoNum, String lastUpdated, int smsSubscribedFlag, int eMailSubscribedFlag, int sharingFlag, int applePushSubscribedFlag, int androidPushSubscribedFlag, int infraredFlag, int wirelessFlag) {

            this.devID = devID;
            this.channelID = channelID;
            this.name = name;
            this.onLIne = onLIne;
            this.ptzFlag = ptzFlag;
            this.securityArea = securityArea;
            this.eStoreFlag = eStoreFlag;
            this.upnpIP = upnpIP;
            this.upnpPort = upnpPort;
            this.devVer = devVer;
            this.curVideoNum = curVideoNum;
            this.lastUpdated = lastUpdated;
            SmsSubscribedFlag = smsSubscribedFlag;
            this.eMailSubscribedFlag = eMailSubscribedFlag;
            this.sharingFlag = sharingFlag;
            this.applePushSubscribedFlag = applePushSubscribedFlag;
            this.androidPushSubscribedFlag = androidPushSubscribedFlag;
            this.infraredFlag = infraredFlag;
            this.wirelessFlag = wirelessFlag;
        }

        public String getDevID() {

            return devID;
        }

        public void setDevID(String devID) {
            this.devID = devID;
        }

        public int getChannelID() {
            return channelID;
        }

        public void setChannelID(int channelID) {
            this.channelID = channelID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Boolean getOnLIne() {
            return onLIne;
        }

        public void setOnLIne(Boolean onLIne) {
            this.onLIne = onLIne;
        }

        public Boolean getPtzFlag() {
            return ptzFlag;
        }

        public void setPtzFlag(Boolean ptzFlag) {
            this.ptzFlag = ptzFlag;
        }

        public int getSecurityArea() {
            return securityArea;
        }

        public void setSecurityArea(int securityArea) {
            this.securityArea = securityArea;
        }

        public int geteStoreFlag() {
            return eStoreFlag;
        }

        public void seteStoreFlag(int eStoreFlag) {
            this.eStoreFlag = eStoreFlag;
        }

        public String getUpnpIP() {
            return upnpIP;
        }

        public void setUpnpIP(String upnpIP) {
            this.upnpIP = upnpIP;
        }

        public int getUpnpPort() {
            return upnpPort;
        }

        public void setUpnpPort(int upnpPort) {
            this.upnpPort = upnpPort;
        }

        public String getDevVer() {
            return devVer;
        }

        public void setDevVer(String devVer) {
            this.devVer = devVer;
        }

        public int getCurVideoNum() {
            return curVideoNum;
        }

        public void setCurVideoNum(int curVideoNum) {
            this.curVideoNum = curVideoNum;
        }

        public String getLastUpdated() {
            return lastUpdated;
        }

        public void setLastUpdated(String lastUpdated) {
            this.lastUpdated = lastUpdated;
        }

        public int getSmsSubscribedFlag() {
            return SmsSubscribedFlag;
        }

        public void setSmsSubscribedFlag(int smsSubscribedFlag) {
            SmsSubscribedFlag = smsSubscribedFlag;
        }

        public int geteMailSubscribedFlag() {
            return eMailSubscribedFlag;
        }

        public void seteMailSubscribedFlag(int eMailSubscribedFlag) {
            this.eMailSubscribedFlag = eMailSubscribedFlag;
        }

        public int getSharingFlag() {
            return sharingFlag;
        }

        public void setSharingFlag(int sharingFlag) {
            this.sharingFlag = sharingFlag;
        }

        public int getApplePushSubscribedFlag() {
            return applePushSubscribedFlag;
        }

        public void setApplePushSubscribedFlag(int applePushSubscribedFlag) {
            this.applePushSubscribedFlag = applePushSubscribedFlag;
        }

        public int getAndroidPushSubscribedFlag() {
            return androidPushSubscribedFlag;
        }

        public void setAndroidPushSubscribedFlag(int androidPushSubscribedFlag) {
            this.androidPushSubscribedFlag = androidPushSubscribedFlag;
        }

        public int getInfraredFlag() {
            return infraredFlag;
        }

        public void setInfraredFlag(int infraredFlag) {
            this.infraredFlag = infraredFlag;
        }

        public int getWirelessFlag() {
            return wirelessFlag;
        }

        public void setWirelessFlag(int wirelessFlag) {
            this.wirelessFlag = wirelessFlag;
        }
    }

    public static class WirelessNetwork{
        String wirelessType;
        String ssid;
        int intensity;

        @Override
        public String toString() {
            return "WirelessNetwork{" +
                    "wirelessType='" + wirelessType + '\'' +
                    ", ssid='" + ssid + '\'' +
                    ", intensity=" + intensity +
                    '}';
        }

        public WirelessNetwork() {
        }

        public WirelessNetwork(String wirelessType, String ssid, int intensity) {

            this.wirelessType = wirelessType;
            this.ssid = ssid;
            this.intensity = intensity;
        }

        public String getWirelessType() {

            return wirelessType;
        }

        public void setWirelessType(String wirelessType) {
            this.wirelessType = wirelessType;
        }

        public String getSsid() {
            return ssid;
        }

        public void setSsid(String ssid) {
            this.ssid = ssid;
        }

        public int getIntensity() {
            return intensity;
        }

        public void setIntensity(int intensity) {
            this.intensity = intensity;
        }
    }

}
