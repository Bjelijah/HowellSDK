package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/10.
 */

public class VideoInputChannelPermission {
    @SerializedName("Id") String id;
    @SerializedName("Name") String name;
    @SerializedName("Permission") String permission;
    @SerializedName("VideoInputChannel") VideoInputChannel videoInputChannel;
    @SerializedName("IsFromDepartment") Boolean isFromDepartment;

    @Override
    public String toString() {
        return "VideoInputChannelPermission{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", permission='" + permission + '\'' +
                ", videoInputChannel=" + videoInputChannel +
                ", isFromDepartment=" + isFromDepartment +
                '}';
    }

    public Boolean getFromDepartment() {
        return isFromDepartment;
    }

    public void setFromDepartment(Boolean fromDepartment) {
        isFromDepartment = fromDepartment;
    }

    public VideoInputChannelPermission(String id, String name, String permission, VideoInputChannel videoInputChannel, Boolean isFromDepartment) {

        this.id = id;
        this.name = name;
        this.permission = permission;
        this.videoInputChannel = videoInputChannel;
        this.isFromDepartment = isFromDepartment;
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

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public VideoInputChannel getVideoInputChannel() {
        return videoInputChannel;
    }

    public void setVideoInputChannel(VideoInputChannel videoInputChannel) {
        this.videoInputChannel = videoInputChannel;
    }

    public boolean isFromDepartment() {
        return isFromDepartment;
    }

    public void setFromDepartment(boolean fromDepartment) {
        isFromDepartment = fromDepartment;
    }

    public VideoInputChannelPermission(String id, String name, String permission, VideoInputChannel videoInputChannel, boolean isFromDepartment) {
        this.id = id;
        this.name = name;
        this.permission = permission;
        this.videoInputChannel = videoInputChannel;
        this.isFromDepartment = isFromDepartment;
    }

    public VideoInputChannelPermission() {
    }

}
