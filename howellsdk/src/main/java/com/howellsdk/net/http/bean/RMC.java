package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/25.
 */

public class RMC {
    @SerializedName("DeviceId") String deviceId;
    @SerializedName("Time") String time;
    @SerializedName("Status") Integer status;
    @SerializedName("Latitude") Double latitude;
    @SerializedName("Longitude") Double longitude;
    @SerializedName("Speed") Double speed;
    @SerializedName("Course") Double course;
    @SerializedName("MagneticVariation") Double magneticVariation;
    @SerializedName("Altitude") Double altitude;
    @SerializedName("Description") String description;
    @SerializedName("AccessId") String accessId;

    @Override
    public String toString() {
        return "RMC{" +
                "deviceId='" + deviceId + '\'' +
                ", time='" + time + '\'' +
                ", status=" + status +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", speed=" + speed +
                ", course=" + course +
                ", magneticVariation=" + magneticVariation +
                ", altitude=" + altitude +
                ", description='" + description + '\'' +
                ", accessId='" + accessId + '\'' +
                '}';
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getCourse() {
        return course;
    }

    public void setCourse(Double course) {
        this.course = course;
    }

    public Double getMagneticVariation() {
        return magneticVariation;
    }

    public void setMagneticVariation(Double magneticVariation) {
        this.magneticVariation = magneticVariation;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccessId() {
        return accessId;
    }

    public void setAccessId(String accessId) {
        this.accessId = accessId;
    }

    public RMC() {

    }

    public RMC(String deviceId, String time, Integer status, Double latitude, Double longitude, Double speed, Double course, Double magneticVariation, Double altitude, String description, String accessId) {

        this.deviceId = deviceId;
        this.time = time;
        this.status = status;
        this.latitude = latitude;
        this.longitude = longitude;
        this.speed = speed;
        this.course = course;
        this.magneticVariation = magneticVariation;
        this.altitude = altitude;
        this.description = description;
        this.accessId = accessId;
    }
}
