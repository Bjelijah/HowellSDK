package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/12.
 */

public class MapItem {
    @SerializedName("Id") String id;
    @SerializedName("ItemType") String itemType;
    @SerializedName("ComponentId") String componentId;
    @SerializedName("Coordinate") Coordinate coordinate;
    @SerializedName("Angle") Double angle;

    public MapItem(String id, String itemType, String componentId, Coordinate coordinate, Double angle) {
        this.id = id;
        this.itemType = itemType;
        this.componentId = componentId;
        this.coordinate = coordinate;
        this.angle = angle;
    }

    @Override
    public String toString() {
        return "MapItem{" +
                "id='" + id + '\'' +
                ", itemType='" + itemType + '\'' +
                ", componentId='" + componentId + '\'' +
                ", coordinate=" + coordinate +
                ", angle=" + angle +
                '}';
    }

    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
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

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }


    public MapItem() {
    }

}
