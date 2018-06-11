package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/25.
 */

public class VehiclePlateDeviceStatus {
    @SerializedName("Time") String time;
    @SerializedName("IsOnline") Boolean isOnline;
    @SerializedName("Status") Integer status;
    @SerializedName("Latitude") Double latitude;
    @SerializedName("Longitude") Double longitude;
    @SerializedName("SystemUpTime") Long systemUpTime;
    @SerializedName("Battery") Integer battery;
    @SerializedName("SignalIntensity") Integer signalIntensity;

    @Override
    public String toString() {
        return "VehiclePlateDeviceStatus{" +
                "time='" + time + '\'' +
                ", isOnline=" + isOnline +
                ", status=" + status +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", systemUpTime=" + systemUpTime +
                ", battery=" + battery +
                ", signalIntensity=" + signalIntensity +
                '}';
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public void setOnline(Boolean online) {
        isOnline = online;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Long getSystemUpTime() {
        return systemUpTime;
    }

    public void setSystemUpTime(Long systemUpTime) {
        this.systemUpTime = systemUpTime;
    }

    public Integer getBattery() {
        return battery;
    }

    public void setBattery(Integer battery) {
        this.battery = battery;
    }

    public Integer getSignalIntensity() {
        return signalIntensity;
    }

    public void setSignalIntensity(Integer signalIntensity) {
        this.signalIntensity = signalIntensity;
    }

    public VehiclePlateDeviceStatus() {

    }

    public VehiclePlateDeviceStatus(String time, Boolean isOnline, Integer status, Double latitude, Double longitude, Long systemUpTime, Integer battery, Integer signalIntensity) {

        this.time = time;
        this.isOnline = isOnline;
        this.status = status;
        this.latitude = latitude;
        this.longitude = longitude;
        this.systemUpTime = systemUpTime;
        this.battery = battery;
        this.signalIntensity = signalIntensity;
    }
}
