package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/11.
 */

public class VideoInputChannelGroup {
    @SerializedName("Id") String id;
    @SerializedName("Name") String name;
    @SerializedName("Comment") String comment;
    @SerializedName("ParentId") String parentId;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public VideoInputChannelGroup(String id, String name, String comment, String parentId) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.parentId = parentId;
    }

    public VideoInputChannelGroup() {
    }

    @Override
    public String toString() {
        return "VideoInputChannelGroup{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }
}
