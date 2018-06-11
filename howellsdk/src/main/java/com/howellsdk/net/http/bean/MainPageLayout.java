package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/3.
 */

public class MainPageLayout {
    @SerializedName("LayoutItem") ArrayList<MainPageLayoutItem> itmes;

    @Override
    public String toString() {
        return "MainPageLayout{" +
                "itmes=" + itmes +
                '}';
    }

    public ArrayList<MainPageLayoutItem> getItmes() {
        return itmes;
    }

    public void setItmes(ArrayList<MainPageLayoutItem> itmes) {
        this.itmes = itmes;
    }

    public MainPageLayout() {

    }

    public MainPageLayout(ArrayList<MainPageLayoutItem> itmes) {

        this.itmes = itmes;
    }
}
