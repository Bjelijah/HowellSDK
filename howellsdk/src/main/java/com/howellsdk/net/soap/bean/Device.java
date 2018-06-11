package com.howellsdk.net.soap.bean;

import java.io.Serializable;


/**
 * Device
 */
public class Device implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -7054945138110360538L;
    private String deviceID;
    private int channelNo;
    private String name;
    private boolean onLine;
    private boolean ptzFlag;
    private int sharingFlag;
    private int wirelessFlag;
    private boolean hasUpdate;
    private int methodType;
    private int indensity;
    
    public Device() {
		super();
	}

    @Override
    public String toString() {
        return "Device{" +
                "deviceID='" + deviceID + '\'' +
                ", channelNo=" + channelNo +
                ", name='" + name + '\'' +
                ", onLine=" + onLine +
                ", ptzFlag=" + ptzFlag +
                ", sharingFlag=" + sharingFlag +
                ", wirelessFlag=" + wirelessFlag +
                ", hasUpdate=" + hasUpdate +
                ", methodType=" + methodType +
                ", indensity=" + indensity +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
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

    public boolean isOnLine() {
        return onLine;
    }

    public void setOnLine(boolean onLine) {
        this.onLine = onLine;
    }

    public boolean isPtzFlag() {
        return ptzFlag;
    }

    public void setPtzFlag(boolean ptzFlag) {
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

    public boolean isHasUpdate() {
        return hasUpdate;
    }

    public void setHasUpdate(boolean hasUpdate) {
        this.hasUpdate = hasUpdate;
    }

    public int getMethodType() {
        return methodType;
    }

    public void setMethodType(int methodType) {
        this.methodType = methodType;
    }

    public int getIndensity() {
        return indensity;
    }

    public void setIndensity(int indensity) {
        this.indensity = indensity;
    }

    public Device(String deviceID, int channelNo, String name, boolean onLine, boolean ptzFlag, int sharingFlag, int wirelessFlag) {

        this.deviceID = deviceID;
        this.channelNo = channelNo;
        this.name = name;
        this.onLine = onLine;
        this.ptzFlag = ptzFlag;
        this.sharingFlag = sharingFlag;
        this.wirelessFlag = wirelessFlag;
    }

    public Device(String deviceID, int channelNo, String name, boolean onLine, boolean ptzFlag, int sharingFlag, int wirelessFlag, boolean hasUpdate, int methodType, int indensity) {

        this.deviceID = deviceID;
        this.channelNo = channelNo;
        this.name = name;
        this.onLine = onLine;
        this.ptzFlag = ptzFlag;
        this.sharingFlag = sharingFlag;
        this.wirelessFlag = wirelessFlag;
        this.hasUpdate = hasUpdate;
        this.methodType = methodType;
        this.indensity = indensity;
    }
}
