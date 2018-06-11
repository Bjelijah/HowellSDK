package com.howellsdk.net.http.bean;

import android.bluetooth.BluetoothClass;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/10.
 */

public class DevicePermission {
    @SerializedName("Id") String id;
    @SerializedName("Name") String name;
    @SerializedName("Permission") String permission;
    @SerializedName("Device") Device device;
    @SerializedName("IsFromDepartment") Boolean isFromDepartment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public boolean isFromDepartment() {
        return isFromDepartment;
    }

    public void setFromDepartment(boolean fromDepartment) {
        isFromDepartment = fromDepartment;
    }

    public DevicePermission(String id, String name, String permission, Device device, boolean isFromDepartment) {
        this.id = id;
        this.name = name;
        this.permission = permission;
        this.device = device;
        this.isFromDepartment = isFromDepartment;
    }

    public DevicePermission() {
    }

    @Override
    public String toString() {
        return "DevicePermission{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", permission='" + permission + '\'' +
                ", device=" + device +
                ", isFromDepartment=" + isFromDepartment +
                '}';
    }
}
