package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/12.
 */

public class MapItemList {
    @SerializedName("Page") Page page;
    @SerializedName("MapItem") ArrayList<MapItem> mapItems;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public ArrayList<MapItem> getMapItems() {
        return mapItems;
    }

    public void setMapItems(ArrayList<MapItem> mapItems) {
        this.mapItems = mapItems;
    }

    public MapItemList(Page page, ArrayList<MapItem> mapItems) {
        this.page = page;
        this.mapItems = mapItems;
    }

    public MapItemList() {
    }

    @Override
    public String toString() {
        return "MapItemList{" +
                "page=" + page +
                ", mapItems=" + mapItems +
                '}';
    }
}
