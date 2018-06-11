package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/25.
 */

public class GISMapList {
    @SerializedName("Page") Page page;
    @SerializedName("GISMap") ArrayList<GISMap> gisMaps;

    @Override
    public String toString() {
        return "GISMapList{" +
                "page=" + page +
                ", gisMaps=" + gisMaps +
                '}';
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public ArrayList<GISMap> getGisMaps() {
        return gisMaps;
    }

    public void setGisMaps(ArrayList<GISMap> gisMaps) {
        this.gisMaps = gisMaps;
    }

    public GISMapList() {

    }

    public GISMapList(Page page, ArrayList<GISMap> gisMaps) {

        this.page = page;
        this.gisMaps = gisMaps;
    }
}
