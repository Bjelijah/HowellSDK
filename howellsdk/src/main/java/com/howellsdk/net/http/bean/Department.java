package com.howellsdk.net.http.bean;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/10.
 */

public class Department {
    @SerializedName("Id") String id;
    @SerializedName("Name") String name;
    @SerializedName("Information") String information;
    @SerializedName("Permission") String permission;
    @SerializedName("DetailPermission") String detailPermission;
    @SerializedName("DeviceCount") Integer deviceCount;
    @SerializedName("VideoInputChannelCount") Integer videoInputChannelCount;
    @SerializedName("VideoOutputChannelCount") Integer videoOutputChannelCount;
    @SerializedName("IOInputChannelCount") Integer IOInputChannelCount;
    @SerializedName("IOOutputChannelCount") Integer IOOutputChannelCount;
    @SerializedName("UserCount") Integer userCount;

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", information='" + information + '\'' +
                ", permission='" + permission + '\'' +
                ", detailPermission='" + detailPermission + '\'' +
                ", deviceCount=" + deviceCount +
                ", videoInputChannelCount=" + videoInputChannelCount +
                ", videoOutputChannelCount=" + videoOutputChannelCount +
                ", IOInputChannelCount=" + IOInputChannelCount +
                ", IOOutputChannelCount=" + IOOutputChannelCount +
                ", userCount=" + userCount +
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

    public @Nullable String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public @Nullable String getDetailPermission() {
        return detailPermission;
    }

    public void setDetailPermission(String detailPermission) {
        this.detailPermission = detailPermission;
    }

    public @Nullable Integer getDeviceCount() {
        return deviceCount;
    }

    public void setDeviceCount(Integer deviceCount) {
        this.deviceCount = deviceCount;
    }

    public @Nullable Integer getVideoInputChannelCount() {
        return videoInputChannelCount;
    }

    public void setVideoInputChannelCount(Integer videoInputChannelCount) {
        this.videoInputChannelCount = videoInputChannelCount;
    }

    public @Nullable Integer getVideoOutputChannelCount() {
        return videoOutputChannelCount;
    }

    public void setVideoOutputChannelCount(Integer videoOutputChannelCount) {
        this.videoOutputChannelCount = videoOutputChannelCount;
    }

    public @Nullable Integer getIOInputChannelCount() {
        return IOInputChannelCount;
    }

    public void setIOInputChannelCount(Integer IOInputChannelCount) {
        this.IOInputChannelCount = IOInputChannelCount;
    }

    public @Nullable Integer getIOOutputChannelCount() {
        return IOOutputChannelCount;
    }

    public void setIOOutputChannelCount(Integer IOOutputChannelCount) {
        this.IOOutputChannelCount = IOOutputChannelCount;
    }

    public @Nullable Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public Department() {

    }

    public Department(String id, String name, String information, String permission, String detailPermission, Integer deviceCount, Integer videoInputChannelCount, Integer videoOutputChannelCount, Integer IOInputChannelCount, Integer IOOutputChannelCount, Integer userCount) {

        this.id = id;
        this.name = name;
        this.information = information;
        this.permission = permission;
        this.detailPermission = detailPermission;
        this.deviceCount = deviceCount;
        this.videoInputChannelCount = videoInputChannelCount;
        this.videoOutputChannelCount = videoOutputChannelCount;
        this.IOInputChannelCount = IOInputChannelCount;
        this.IOOutputChannelCount = IOOutputChannelCount;
        this.userCount = userCount;
    }
}
