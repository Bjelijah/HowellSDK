package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/23.
 */

public class PDCFlavourList {
    @SerializedName("Page")             Page page;
    @SerializedName("PDCFlavour")       ArrayList<PDCFlavour> pdcFlavours;

    @Override
    public String toString() {
        return "PDCFlavourList{" +
                "page=" + page +
                ", pdcFlavours=" + pdcFlavours +
                '}';
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public ArrayList<PDCFlavour> getPdcFlavours() {
        return pdcFlavours;
    }

    public void setPdcFlavours(ArrayList<PDCFlavour> pdcFlavours) {
        this.pdcFlavours = pdcFlavours;
    }

    public PDCFlavourList() {

    }

    public PDCFlavourList(Page page, ArrayList<PDCFlavour> pdcFlavours) {

        this.page = page;
        this.pdcFlavours = pdcFlavours;
    }
}
