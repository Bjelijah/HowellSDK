package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/25.
 */

public class GISMap {
    @SerializedName("Id") String id;
    @SerializedName("Name") String name;
    @SerializedName("Longitude") Double longitude;
    @SerializedName("Latitude") Double latitude;
    @SerializedName("Description") String description;

    @Override
    public String toString() {
        return "GISMap{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", description='" + description + '\'' +
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

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GISMap() {

    }

    public GISMap(String id, String name, Double longitude, Double latitude, String description) {

        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.description = description;
    }
}
