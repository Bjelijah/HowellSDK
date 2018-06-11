package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/11.
 */

public class MapGroupList {
    @SerializedName("Page") Page page;
    @SerializedName("MapGroup") ArrayList<MapGroup> mapGroups;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public ArrayList<MapGroup> getMapGroups() {
        return mapGroups;
    }

    public void setMapGroups(ArrayList<MapGroup> mapGroups) {
        this.mapGroups = mapGroups;
    }

    public MapGroupList(Page page, ArrayList<MapGroup> mapGroups) {
        this.page = page;
        this.mapGroups = mapGroups;
    }

    public MapGroupList() {
    }

    @Override
    public String toString() {
        return "MapGroupList{" +
                "page=" + page +
                ", mapGroups=" + mapGroups +
                '}';
    }
}
