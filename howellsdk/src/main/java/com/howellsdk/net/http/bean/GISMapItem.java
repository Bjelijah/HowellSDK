package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/25.
 */

public class GISMapItem {
    @SerializedName("Id") String id;
    @SerializedName("ParentLayerId") String parentLayerId;
    @SerializedName("ComponentId") String itemId;
    @SerializedName("Name") String name;
    @SerializedName("IconType") Integer iconType;
    @SerializedName("Online") Boolean online;
    @SerializedName("Longitude") Double longitude;
    @SerializedName("Latitude") Double latitude;
    @SerializedName("Course") Double course;
    @SerializedName("Status") String status;
    @SerializedName("GPSId") String gpsId;
    @SerializedName("VehiclePlateId") String vehiclePlateId;
    @SerializedName("FaceRecognitionId") String faceRecognitionId;
    @SerializedName("Description") String description;
    @SerializedName("UpdatedTime") String updatadTime;

    @Override
    public String toString() {
        return "GISMapItem{" +
                "id='" + id + '\'' +
                ", parentLayerId='" + parentLayerId + '\'' +
                ", itemId='" + itemId + '\'' +
                ", name='" + name + '\'' +
                ", iconType=" + iconType +
                ", online=" + online +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", course=" + course +
                ", status='" + status + '\'' +
                ", gpsId='" + gpsId + '\'' +
                ", vehiclePlateId='" + vehiclePlateId + '\'' +
                ", faceRecognitionId='" + faceRecognitionId + '\'' +
                ", description='" + description + '\'' +
                ", updatadTime='" + updatadTime + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentLayerId() {
        return parentLayerId;
    }

    public void setParentLayerId(String parentLayerId) {
        this.parentLayerId = parentLayerId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIconType() {
        return iconType;
    }

    public void setIconType(Integer iconType) {
        this.iconType = iconType;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
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

    public Double getCourse() {
        return course;
    }

    public void setCourse(Double course) {
        this.course = course;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGpsId() {
        return gpsId;
    }

    public void setGpsId(String gpsId) {
        this.gpsId = gpsId;
    }

    public String getVehiclePlateId() {
        return vehiclePlateId;
    }

    public void setVehiclePlateId(String vehiclePlateId) {
        this.vehiclePlateId = vehiclePlateId;
    }

    public String getFaceRecognitionId() {
        return faceRecognitionId;
    }

    public void setFaceRecognitionId(String faceRecognitionId) {
        this.faceRecognitionId = faceRecognitionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdatadTime() {
        return updatadTime;
    }

    public void setUpdatadTime(String updatadTime) {
        this.updatadTime = updatadTime;
    }

    public GISMapItem() {

    }

    public GISMapItem(String id, String parentLayerId, String itemId, String name, Integer iconType, Boolean online, Double longitude, Double latitude, Double course, String status, String gpsId, String vehiclePlateId, String faceRecognitionId, String description, String updatadTime) {

        this.id = id;
        this.parentLayerId = parentLayerId;
        this.itemId = itemId;
        this.name = name;
        this.iconType = iconType;
        this.online = online;
        this.longitude = longitude;
        this.latitude = latitude;
        this.course = course;
        this.status = status;
        this.gpsId = gpsId;
        this.vehiclePlateId = vehiclePlateId;
        this.faceRecognitionId = faceRecognitionId;
        this.description = description;
        this.updatadTime = updatadTime;
    }
}
