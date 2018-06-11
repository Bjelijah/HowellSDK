package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/23.
 */

public class PDCSampleList {
    @SerializedName("Page")         Page page;
    @SerializedName("PDCSample")    ArrayList<PDCSample> pdcSamples;

    @Override
    public String toString() {
        return "PDCSampleList{" +
                "page=" + page +
                ", pdcSamples=" + pdcSamples +
                '}';
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public ArrayList<PDCSample> getPdcSamples() {
        return pdcSamples;
    }

    public void setPdcSamples(ArrayList<PDCSample> pdcSamples) {
        this.pdcSamples = pdcSamples;
    }

    public PDCSampleList() {

    }

    public PDCSampleList(Page page, ArrayList<PDCSample> pdcSamples) {

        this.page = page;
        this.pdcSamples = pdcSamples;
    }
}
