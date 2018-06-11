package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/11/3.
 */

public class MainPageLayoutItem {
    @SerializedName("Id")               String id;
    @SerializedName("ItemType")         String itemType;
    @SerializedName("DataType")         String dataType;
    @SerializedName("SourceType")       String sourceType;
    @SerializedName("SourceId")         String sourceId;
    @SerializedName("Unit")             String unit;
    @SerializedName("X")                Integer x;
    @SerializedName("Y")                Integer y;
    @SerializedName("Width")            Integer width;
    @SerializedName("Height")           Integer height;

    @Override
    public String toString() {
        return "MainPageLayoutItem{" +
                "id='" + id + '\'' +
                ", itemType='" + itemType + '\'' +
                ", dataType='" + dataType + '\'' +
                ", sourceType='" + sourceType + '\'' +
                ", sourceId='" + sourceId + '\'' +
                ", unit='" + unit + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    public MainPageLayoutItem() {
    }

    public MainPageLayoutItem(String id, String itemType, String dataType, String sourceType, String sourceId, String unit, Integer x, Integer y, Integer width, Integer height) {

        this.id = id;
        this.itemType = itemType;
        this.dataType = dataType;
        this.sourceType = sourceType;
        this.sourceId = sourceId;
        this.unit = unit;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
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
}
