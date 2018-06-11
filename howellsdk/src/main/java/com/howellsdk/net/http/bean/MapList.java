package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/11.
 */

public class MapList {
    @SerializedName("Page") Page page;
    @SerializedName("Map") ArrayList<Map> maps;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public ArrayList<Map> getMaps() {
        return maps;
    }

    public void setMaps(ArrayList<Map> maps) {
        this.maps = maps;
    }

    public MapList(Page page, ArrayList<Map> maps) {
        this.page = page;
        this.maps = maps;
    }

    public MapList() {
    }

    @Override
    public String toString() {
        return "MapList{" +
                "page=" + page +
                ", maps=" + maps +
                '}';
    }
}
