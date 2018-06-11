package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/8/10.
 */

public class Resolution {
    @SerializedName("Width")        Integer width;
    @SerializedName("Height")       Integer height;
    @SerializedName("Description")  String description;

    @Override
    public String toString() {
        return "Resolution{" +
                "width=" + width +
                ", height=" + height +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Resolution() {

    }

    public Resolution(Integer width, Integer height, String description) {

        this.width = width;
        this.height = height;
        this.description = description;
    }
}
