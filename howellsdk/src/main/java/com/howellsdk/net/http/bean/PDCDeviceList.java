package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/23.
 */

public class PDCDeviceList {
    @SerializedName("Page")         Page page;
    @SerializedName("PDCDevice")    ArrayList<PDCDevice> pdcDevices;

    @Override
    public String toString() {
        return "PDCDeviceList{" +
                "page=" + page +
                ", pdcDevices=" + pdcDevices +
                '}';
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public ArrayList<PDCDevice> getPdcDevices() {
        return pdcDevices;
    }

    public void setPdcDevices(ArrayList<PDCDevice> pdcDevices) {
        this.pdcDevices = pdcDevices;
    }

    public PDCDeviceList() {

    }

    public PDCDeviceList(Page page, ArrayList<PDCDevice> pdcDevices) {

        this.page = page;
        this.pdcDevices = pdcDevices;
    }
}
