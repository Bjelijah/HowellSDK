package com.howellsdk.net.http.bean;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/10.
 */

public class VideoOutputChannelPermission {
    @SerializedName("Id") String id;
    @SerializedName("Name") String name;
    @SerializedName("Permission") String permission;
    @SerializedName("VideoOutputChannel") VideoOutputChannel videoOutputChannel;
    @SerializedName("IsFromDepartment") Boolean isFromDepartment;

    @Override
    public String toString() {
        return "VideoOutputChannelPermission{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", permission='" + permission + '\'' +
                ", videoOutputChannel=" + videoOutputChannel +
                ", isFromDepartment=" + isFromDepartment +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public @Nullable String getName() {
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

    public VideoOutputChannel getVideoOutputChannel() {
        return videoOutputChannel;
    }

    public void setVideoOutputChannel(VideoOutputChannel videoOutputChannel) {
        this.videoOutputChannel = videoOutputChannel;
    }

    public @Nullable Boolean getFromDepartment() {
        return isFromDepartment;
    }

    public void setFromDepartment(Boolean fromDepartment) {
        isFromDepartment = fromDepartment;
    }

    public VideoOutputChannelPermission() {

    }

    public VideoOutputChannelPermission(String id, String name, String permission, VideoOutputChannel videoOutputChannel, Boolean isFromDepartment) {

        this.id = id;
        this.name = name;
        this.permission = permission;
        this.videoOutputChannel = videoOutputChannel;
        this.isFromDepartment = isFromDepartment;
    }
}
