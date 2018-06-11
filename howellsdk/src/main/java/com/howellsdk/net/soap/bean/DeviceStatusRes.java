package com.howellsdk.net.soap.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/15.
 */

public class DeviceStatusRes {
    String result;
    int pageNo;
    int pageCount;
    int recordCount;
    ArrayList<Node> nodes;
    WirelessNetwork wirelessNetwork;
    int devType;
    String model;
    String serialID;

    public int getDevType() {
        return devType;
    }

    public void setDevType(int devType) {
        this.devType = devType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialID() {
        return serialID;
    }

    public void setSerialID(String serialID) {
        this.serialID = serialID;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    @Override
    public String toString() {
        return "DeviceStatusRes{" +
                "result='" + result + '\'' +
                ", pageNo=" + pageNo +
                ", pageCount=" + pageCount +
                ", recordCount=" + recordCount +
                ", nodes=" + nodes +
                ", wirelessNetwork=" + wirelessNetwork +
                ", devType=" + devType +
                ", model='" + model + '\'' +
                ", serialID='" + serialID + '\'' +
                '}';
    }

    public DeviceStatusRes() {
    }

    public DeviceStatusRes(String result, ArrayList<Node> nodes, WirelessNetwork wirelessNetwork) {

        this.result = result;
        this.nodes = nodes;
        this.wirelessNetwork = wirelessNetwork;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    public WirelessNetwork getWirelessNetwork() {
        return wirelessNetwork;
    }

    public void setWirelessNetwork(WirelessNetwork wirelessNetwork) {
        this.wirelessNetwork = wirelessNetwork;
    }

    public static class Node {
        String devID;
        int channelNo;
        String name;
        Boolean onLine;
        Boolean ptzFlag;
        int securityArea;
        Boolean eStoreFlag;
        String upnpIP;
        int upnpPort;
        String devVer;
        int curVideoNum;
        String lastUpdated;
        int smsSubscribedFlag;
        int emailSubscribedFlag;
        int sharingFlag;
        int applePushSubscribedFlag;
        int androidPushSubscribedFlag;
        int infraredFlag;
        int wirelessFlag;
        WirelessNetwork network;

        @Override
        public String toString() {
            return "Node{" +
                    "devID='" + devID + '\'' +
                    ", channelNo=" + channelNo +
                    ", name='" + name + '\'' +
                    ", onLine=" + onLine +
                    ", ptzFlag=" + ptzFlag +
                    ", securityArea=" + securityArea +
                    ", eStoreFlag=" + eStoreFlag +
                    ", upnpIP='" + upnpIP + '\'' +
                    ", upnpPort=" + upnpPort +
                    ", devVer='" + devVer + '\'' +
                    ", curVideoNum=" + curVideoNum +
                    ", lastUpdated='" + lastUpdated + '\'' +
                    ", smsSubscribedFlag=" + smsSubscribedFlag +
                    ", emailSubscribedFlag=" + emailSubscribedFlag +
                    ", sharingFlag=" + sharingFlag +
                    ", applePushSubscribedFlag=" + applePushSubscribedFlag +
                    ", androidPushSubscribedFlag=" + androidPushSubscribedFlag +
                    ", infraredFlag=" + infraredFlag +
                    ", wirelessFlag=" + wirelessFlag +
                    ", network=" + network +
                    '}';
        }

        public Node() {
        }

        public Node(String devID, int channelNo, String name, Boolean onLine, Boolean ptzFlag, int securityArea, Boolean eStoreFlag, String upnpIP, int upnpPort, String devVer, int curVideoNum, String lastUpdated, int smsSubscribedFlag, int emailSubscribedFlag, int sharingFlag, int applePushSubscribedFlag, int androidPushSubscribedFlag, int infraredFlag, int wirelessFlag) {

            this.devID = devID;
            this.channelNo = channelNo;
            this.name = name;
            this.onLine = onLine;
            this.ptzFlag = ptzFlag;
            this.securityArea = securityArea;
            this.eStoreFlag = eStoreFlag;
            this.upnpIP = upnpIP;
            this.upnpPort = upnpPort;
            this.devVer = devVer;
            this.curVideoNum = curVideoNum;
            this.lastUpdated = lastUpdated;
            this.smsSubscribedFlag = smsSubscribedFlag;
            this.emailSubscribedFlag = emailSubscribedFlag;
            this.sharingFlag = sharingFlag;
            this.applePushSubscribedFlag = applePushSubscribedFlag;
            this.androidPushSubscribedFlag = androidPushSubscribedFlag;
            this.infraredFlag = infraredFlag;
            this.wirelessFlag = wirelessFlag;
        }

        public WirelessNetwork getNetwork() {
            return network;
        }

        public void setNetwork(WirelessNetwork network) {
            this.network = network;
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

        public int getSecurityArea() {
            return securityArea;
        }

        public void setSecurityArea(int securityArea) {
            this.securityArea = securityArea;
        }

        public Boolean geteStoreFlag() {
            return eStoreFlag;
        }

        public void seteStoreFlag(Boolean eStoreFlag) {
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
            return smsSubscribedFlag;
        }

        public void setSmsSubscribedFlag(int smsSubscribedFlag) {
            this.smsSubscribedFlag = smsSubscribedFlag;
        }

        public int getEmailSubscribedFlag() {
            return emailSubscribedFlag;
        }

        public void setEmailSubscribedFlag(int emailSubscribedFlag) {
            this.emailSubscribedFlag = emailSubscribedFlag;
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
