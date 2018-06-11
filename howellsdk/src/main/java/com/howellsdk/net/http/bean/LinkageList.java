package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/10.
 */

public class LinkageList {
    @SerializedName("Page") Page page;
    @SerializedName("Linkage") ArrayList<Linkage> linkages;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public ArrayList<Linkage> getLinkages() {
        return linkages;
    }

    public void setLinkages(ArrayList<Linkage> linkages) {
        this.linkages = linkages;
    }

    public LinkageList(Page page, ArrayList<Linkage> linkages) {
        this.page = page;
        this.linkages = linkages;
    }

    public LinkageList() {
    }

    @Override
    public String toString() {
        return "LinkageList{" +
                "page=" + page +
                ", linkages=" + linkages +
                '}';
    }
}
