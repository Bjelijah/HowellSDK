package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/25.
 */

public class GISMapLayerList {
    @SerializedName("Page") Page page;
    @SerializedName("GISMapLayer") ArrayList<GISMapLayer> gisMapLayers;

    @Override
    public String toString() {
        return "GISMapLayerList{" +
                "page=" + page +
                ", gisMapLayers=" + gisMapLayers +
                '}';
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public ArrayList<GISMapLayer> getGisMapLayers() {
        return gisMapLayers;
    }

    public void setGisMapLayers(ArrayList<GISMapLayer> gisMapLayers) {
        this.gisMapLayers = gisMapLayers;
    }

    public GISMapLayerList() {
    }

    public GISMapLayerList(Page page, ArrayList<GISMapLayer> gisMapLayers) {

        this.page = page;
        this.gisMapLayers = gisMapLayers;
    }
}
