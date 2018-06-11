package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/10.
 */

public class DevicePermissionList {
    @SerializedName("Page") Page page;
    @SerializedName("DevicePermission") ArrayList<DevicePermission> devicePermissionses;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public ArrayList<DevicePermission> getDevicePermissionses() {
        return devicePermissionses;
    }

    public void setDevicePermissionses(ArrayList<DevicePermission> devicePermissionses) {
        this.devicePermissionses = devicePermissionses;
    }

    public DevicePermissionList(Page page, ArrayList<DevicePermission> devicePermissionses) {
        this.page = page;
        this.devicePermissionses = devicePermissionses;
    }

    public DevicePermissionList() {
    }

    @Override
    public String toString() {
        return "DevicePermissionList{" +
                "page=" + page +
                ", devicePermissionses=" + devicePermissionses +
                '}';
    }
}
