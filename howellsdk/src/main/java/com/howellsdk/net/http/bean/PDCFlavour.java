package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/11/23.
 */

public class PDCFlavour {
    @SerializedName("Id")           String id;
    @SerializedName("Name")         String name;
    @SerializedName("Layout")       PDCFlavourLayout pdcFlavourLayout;

    @Override
    public String toString() {
        return "PDCFlavour{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pdcFlavourLayout=" + pdcFlavourLayout +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PDCFlavourLayout getPdcFlavourLayout() {
        return pdcFlavourLayout;
    }

    public void setPdcFlavourLayout(PDCFlavourLayout pdcFlavourLayout) {
        this.pdcFlavourLayout = pdcFlavourLayout;
    }

    public PDCFlavour() {

    }

    public PDCFlavour(String id, String name, PDCFlavourLayout pdcFlavourLayout) {

        this.id = id;
        this.name = name;
        this.pdcFlavourLayout = pdcFlavourLayout;
    }
}
