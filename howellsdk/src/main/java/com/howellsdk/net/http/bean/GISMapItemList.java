package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/25.
 */

public class GISMapItemList {
    @SerializedName("Page") Page page;
    @SerializedName("GISMapItem") ArrayList<GISMapItem> items;

    @Override
    public String toString() {
        return "GISMapItemList{" +
                "page=" + page +
                ", items=" + items +
                '}';
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public ArrayList<GISMapItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<GISMapItem> items) {
        this.items = items;
    }

    public GISMapItemList() {

    }

    public GISMapItemList(Page page, ArrayList<GISMapItem> items) {

        this.page = page;
        this.items = items;
    }
}
