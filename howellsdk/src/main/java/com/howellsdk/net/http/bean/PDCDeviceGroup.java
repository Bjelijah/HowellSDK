package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/23.
 */

public class PDCDeviceGroup {
    @SerializedName("Id")               String id;
    @SerializedName("CreationTime")     String creationTime;
    @SerializedName("Name")             String name;
    @SerializedName("ResetTime")        String resetTime;
    @SerializedName("IconType")         Integer iconType;
    @SerializedName("Information")      String information;
    @SerializedName("LastNSeconds")     Integer lastNSeconds;
    @SerializedName("PDCDevice")        ArrayList<PDCDevice> pdcDevices;
    @SerializedName("GroupStatus")      PDCDeviceGroupStatus groupStatus;
    @SerializedName("Threshold")        PDCThreshold pdcThreshold;

    @Override
    public String toString() {
        return "PDCDeviceGroup{" +
                "id='" + id + '\'' +
                ", creationTime='" + creationTime + '\'' +
                ", name='" + name + '\'' +
                ", resetTime='" + resetTime + '\'' +
                ", iconType=" + iconType +
                ", information='" + information + '\'' +
                ", lastNSeconds=" + lastNSeconds +
                ", pdcDevices=" + pdcDevices +
                ", groupStatus=" + groupStatus +
                ", pdcThreshold=" + pdcThreshold +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResetTime() {
        return resetTime;
    }

    public void setResetTime(String resetTime) {
        this.resetTime = resetTime;
    }

    public Integer getIconType() {
        return iconType;
    }

    public void setIconType(Integer iconType) {
        this.iconType = iconType;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Integer getLastNSeconds() {
        return lastNSeconds;
    }

    public void setLastNSeconds(Integer lastNSeconds) {
        this.lastNSeconds = lastNSeconds;
    }

    public ArrayList<PDCDevice> getPdcDevices() {
        return pdcDevices;
    }

    public void setPdcDevices(ArrayList<PDCDevice> pdcDevices) {
        this.pdcDevices = pdcDevices;
    }

    public PDCDeviceGroupStatus getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(PDCDeviceGroupStatus groupStatus) {
        this.groupStatus = groupStatus;
    }

    public PDCThreshold getPdcThreshold() {
        return pdcThreshold;
    }

    public void setPdcThreshold(PDCThreshold pdcThreshold) {
        this.pdcThreshold = pdcThreshold;
    }

    public PDCDeviceGroup() {

    }

    public PDCDeviceGroup(String id, String creationTime, String name, String resetTime, Integer iconType, String information, Integer lastNSeconds, ArrayList<PDCDevice> pdcDevices, PDCDeviceGroupStatus groupStatus, PDCThreshold pdcThreshold) {

        this.id = id;
        this.creationTime = creationTime;
        this.name = name;
        this.resetTime = resetTime;
        this.iconType = iconType;
        this.information = information;
        this.lastNSeconds = lastNSeconds;
        this.pdcDevices = pdcDevices;
        this.groupStatus = groupStatus;
        this.pdcThreshold = pdcThreshold;
    }
}
