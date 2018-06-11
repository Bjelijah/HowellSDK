package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/10.
 */

public class VideoInputChannelPermissionList {
    @SerializedName("Page") Page page;
    @SerializedName("VideoInputChannelPermission") ArrayList<VideoInputChannelPermission> VideoInputChannelPermissiones;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public ArrayList<VideoInputChannelPermission> getVideoInputChannelPermissiones() {
        return VideoInputChannelPermissiones;
    }

    public void setVideoInputChannelPermissiones(ArrayList<VideoInputChannelPermission> videoInputChannelPermissiones) {
        VideoInputChannelPermissiones = videoInputChannelPermissiones;
    }

    public VideoInputChannelPermissionList(Page page, ArrayList<VideoInputChannelPermission> videoInputChannelPermissiones) {
        this.page = page;
        VideoInputChannelPermissiones = videoInputChannelPermissiones;
    }

    public VideoInputChannelPermissionList() {
    }

    @Override
    public String toString() {
        return "VideoInputChannelPermissionList{" +
                "page=" + page +
                ", VideoInputChannelPermissiones=" + VideoInputChannelPermissiones +
                '}';
    }
}
