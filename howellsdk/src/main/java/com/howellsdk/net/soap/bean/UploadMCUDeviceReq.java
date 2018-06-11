package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/19.
 */

public class UploadMCUDeviceReq {
    String UUID;
    String model;
    String type;
    String osType;
    String osVersion;
    String manufactory;
    String IEMI;

    @Override
    public String toString() {
        return "UploadMCUDeviceReq{" +
                "UUID='" + UUID + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", osType='" + osType + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", manufactory='" + manufactory + '\'' +
                ", IEMI='" + IEMI + '\'' +
                '}';
    }

    public UploadMCUDeviceReq() {
    }

    public UploadMCUDeviceReq(String UUID, String model, String type, String osType, String osVersion, String manufactory, String IEMI) {

        this.UUID = UUID;
        this.model = model;
        this.type = type;
        this.osType = osType;
        this.osVersion = osVersion;
        this.manufactory = manufactory;
        this.IEMI = IEMI;
    }

    public String getUUID() {

        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getManufactory() {
        return manufactory;
    }

    public void setManufactory(String manufactory) {
        this.manufactory = manufactory;
    }

    public String getIEMI() {
        return IEMI;
    }

    public void setIEMI(String IEMI) {
        this.IEMI = IEMI;
    }
}
