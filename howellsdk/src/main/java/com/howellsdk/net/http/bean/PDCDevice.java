package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/11/22.
 */

public class PDCDevice {
    @SerializedName("Id")                   String id;
    @SerializedName("CreationTime")         String creationTime;
    @SerializedName("Name")                 String name;
    @SerializedName("Manufacturer")         String manufacturer;
    @SerializedName("Model")                String model;
    @SerializedName("Firmware")             String firmware;
    @SerializedName("SerialNumber")         String serialNumber;
    @SerializedName("PointOfSale")          String pointOfSale;
    @SerializedName("Information")          String information;
    @SerializedName("Username")             String userName;
    @SerializedName("Password")             String password;
    @SerializedName("Uri")                  String uri;
    @SerializedName("ProtocolType")         String protocolType;
    @SerializedName("ParentDeviceId")       String parentDeviceId;
    @SerializedName("AccessId")             String accessID;
    @SerializedName("TimeSynchronizing")    Boolean timeSynchronizing;
    @SerializedName("ResetTime")            String resetTime;
    @SerializedName("StructuredAbilities")  Integer structuredAbilities;
    @SerializedName("LastNSeconds")         Integer lastNSeconds;
    @SerializedName("ExistedInDatabase")    Boolean existedInDatabase;
    @SerializedName("DeviceStatus")         PDCDeviceStatus deviceStatus;
    @SerializedName("Threshold")            PDCThreshold threshold;

    @Override
    public String toString() {
        return "PDCDevice{" +
                "id='" + id + '\'' +
                ", creationTime='" + creationTime + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", firmware='" + firmware + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", pointOfSale='" + pointOfSale + '\'' +
                ", information='" + information + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", uri='" + uri + '\'' +
                ", protocolType='" + protocolType + '\'' +
                ", parentDeviceId='" + parentDeviceId + '\'' +
                ", accessID='" + accessID + '\'' +
                ", timeSynchronizing=" + timeSynchronizing +
                ", resetTime='" + resetTime + '\'' +
                ", structuredAbilities=" + structuredAbilities +
                ", lastNSeconds=" + lastNSeconds +
                ", existedInDatabase=" + existedInDatabase +
                ", deviceStatus=" + deviceStatus +
                ", threshold=" + threshold +
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFirmware() {
        return firmware;
    }

    public void setFirmware(String firmware) {
        this.firmware = firmware;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPointOfSale() {
        return pointOfSale;
    }

    public void setPointOfSale(String pointOfSale) {
        this.pointOfSale = pointOfSale;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }

    public String getParentDeviceId() {
        return parentDeviceId;
    }

    public void setParentDeviceId(String parentDeviceId) {
        this.parentDeviceId = parentDeviceId;
    }

    public String getAccessID() {
        return accessID;
    }

    public void setAccessID(String accessID) {
        this.accessID = accessID;
    }

    public Boolean getTimeSynchronizing() {
        return timeSynchronizing;
    }

    public void setTimeSynchronizing(Boolean timeSynchronizing) {
        this.timeSynchronizing = timeSynchronizing;
    }

    public String getResetTime() {
        return resetTime;
    }

    public void setResetTime(String resetTime) {
        this.resetTime = resetTime;
    }

    public Integer getStructuredAbilities() {
        return structuredAbilities;
    }

    public void setStructuredAbilities(Integer structuredAbilities) {
        this.structuredAbilities = structuredAbilities;
    }

    public Integer getLastNSeconds() {
        return lastNSeconds;
    }

    public void setLastNSeconds(Integer lastNSeconds) {
        this.lastNSeconds = lastNSeconds;
    }

    public Boolean getExistedInDatabase() {
        return existedInDatabase;
    }

    public void setExistedInDatabase(Boolean existedInDatabase) {
        this.existedInDatabase = existedInDatabase;
    }

    public PDCDeviceStatus getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(PDCDeviceStatus deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public PDCThreshold getThreshold() {
        return threshold;
    }

    public void setThreshold(PDCThreshold threshold) {
        this.threshold = threshold;
    }

    public PDCDevice() {

    }

    public PDCDevice(String id, String creationTime, String name, String manufacturer, String model, String firmware, String serialNumber, String pointOfSale, String information, String userName, String password, String uri, String protocolType, String parentDeviceId, String accessID, Boolean timeSynchronizing, String resetTime, Integer structuredAbilities, Integer lastNSeconds, Boolean existedInDatabase, PDCDeviceStatus deviceStatus, PDCThreshold threshold) {

        this.id = id;
        this.creationTime = creationTime;
        this.name = name;
        this.manufacturer = manufacturer;
        this.model = model;
        this.firmware = firmware;
        this.serialNumber = serialNumber;
        this.pointOfSale = pointOfSale;
        this.information = information;
        this.userName = userName;
        this.password = password;
        this.uri = uri;
        this.protocolType = protocolType;
        this.parentDeviceId = parentDeviceId;
        this.accessID = accessID;
        this.timeSynchronizing = timeSynchronizing;
        this.resetTime = resetTime;
        this.structuredAbilities = structuredAbilities;
        this.lastNSeconds = lastNSeconds;
        this.existedInDatabase = existedInDatabase;
        this.deviceStatus = deviceStatus;
        this.threshold = threshold;
    }
}
