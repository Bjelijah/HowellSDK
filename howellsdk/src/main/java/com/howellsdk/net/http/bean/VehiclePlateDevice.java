package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/26.
 */

public class VehiclePlateDevice {
    @SerializedName("Id") String id;
    @SerializedName("CreationTime") String createTime;
    @SerializedName("Name") String name;
    @SerializedName("Username") String username;
    @SerializedName("Password") String password;
    @SerializedName("Model") String model;
    @SerializedName("Description") String description;
    @SerializedName("AccessId") String accessId;
    @SerializedName("VehiclePlateDeviceStatus") VehiclePlateDeviceStatus status;

    public VehiclePlateDevice(String id, String createTime, String name, String username, String password, String model, String description, String accessId, VehiclePlateDeviceStatus status) {
        this.id = id;
        this.createTime = createTime;
        this.name = name;
        this.username = username;
        this.password = password;
        this.model = model;
        this.description = description;
        this.accessId = accessId;
        this.status = status;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public VehiclePlateDeviceStatus getStatus() {
        return status;
    }

    public void setStatus(VehiclePlateDeviceStatus status) {
        this.status = status;
    }

    public VehiclePlateDevice() {

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "VehiclePlateDevice{" +
                "id='" + id + '\'' +
                ", createTime='" + createTime + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                ", accessId='" + accessId + '\'' +
                ", status=" + status +
                '}';
    }
}
