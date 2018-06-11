package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/23.
 */

public class PDCDeviceGroupList {
    @SerializedName("Page")                 Page page;
    @SerializedName("PDCDeviceGroup")       ArrayList<PDCDeviceGroup> pdcDeviceGroups;

    @Override
    public String toString() {
        return "PDCDeviceGroupList{" +
                "page=" + page +
                ", pdcDeviceGroups=" + pdcDeviceGroups +
                '}';
    }

    public ArrayList<PDCDeviceGroup> getPdcDeviceGroups() {
        return pdcDeviceGroups;
    }

    public void setPdcDeviceGroups(ArrayList<PDCDeviceGroup> pdcDeviceGroups) {
        this.pdcDeviceGroups = pdcDeviceGroups;
    }

    public Page getPage() {

        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public PDCDeviceGroupList() {

    }

    public PDCDeviceGroupList(Page page, ArrayList<PDCDeviceGroup> pdcDeviceGroups) {

        this.page = page;
        this.pdcDeviceGroups = pdcDeviceGroups;
    }
}
