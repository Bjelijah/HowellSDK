package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/11.
 */

public class VideoInputChannelGroupList {
    @SerializedName("Page") Page page;
    @SerializedName("VideoInputChannelGroup") ArrayList<VideoInputChannelGroup> groups ;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public ArrayList<VideoInputChannelGroup> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<VideoInputChannelGroup> groups) {
        this.groups = groups;
    }

    public VideoInputChannelGroupList(Page page, ArrayList<VideoInputChannelGroup> groups) {
        this.page = page;
        this.groups = groups;
    }

    public VideoInputChannelGroupList() {
    }

    @Override
    public String toString() {
        return "VideoInputChannelGroupList{" +
                "page=" + page +
                ", groups=" + groups +
                '}';
    }
}
