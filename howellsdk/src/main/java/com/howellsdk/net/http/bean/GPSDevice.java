package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/25.
 */

public class GPSDevice {
    @SerializedName("Id") String id;
    @SerializedName("CreationTime") String createTime;
    @SerializedName("Name") String name;
    @SerializedName("Username") String userName;
    @SerializedName("Password") String password;
    @SerializedName("Model") String model;
    @SerializedName("Description") String description;
    @SerializedName("AccessId") String accessId;
    @SerializedName("GPSStatus") GPSStatus gpsStatus;

    @Override
    public String toString() {
        return "GPSDevice{" +
                "id='" + id + '\'' +
                ", createTime='" + createTime + '\'' +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                ", accessId='" + accessId + '\'' +
                ", gpsStatus=" + gpsStatus +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccessId() {
        return accessId;
    }

    public void setAccessId(String accessId) {
        this.accessId = accessId;
    }

    public GPSStatus getGpsStatus() {
        return gpsStatus;
    }

    public void setGpsStatus(GPSStatus gpsStatus) {
        this.gpsStatus = gpsStatus;
    }

    public GPSDevice() {

    }

    public GPSDevice(String id, String createTime, String name, String userName, String password, String model, String description, String accessId, GPSStatus gpsStatus) {

        this.id = id;
        this.createTime = createTime;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.model = model;
        this.description = description;
        this.accessId = accessId;
        this.gpsStatus = gpsStatus;
    }
}
