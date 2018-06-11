package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/25.
 */

public class GPSDeviceList {
    @SerializedName("Page") Page page;
    @SerializedName("GPSDevice") ArrayList<GPSDevice> devices;

    @Override
    public String toString() {
        return "GPSDeviceList{" +
                "page=" + page +
                ", devices=" + devices +
                '}';
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public ArrayList<GPSDevice> getDevices() {
        return devices;
    }

    public void setDevices(ArrayList<GPSDevice> devices) {
        this.devices = devices;
    }

    public GPSDeviceList() {

    }

    public GPSDeviceList(Page page, ArrayList<GPSDevice> devices) {

        this.page = page;
        this.devices = devices;
    }
}
