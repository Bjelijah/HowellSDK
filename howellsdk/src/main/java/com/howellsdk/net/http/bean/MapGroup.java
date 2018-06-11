package com.howellsdk.net.http.bean;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/11.
 */

public class MapGroup {
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

    public @Nullable String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public @Nullable String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public MapGroup(String id, String name, String comment, String parentId) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.parentId = parentId;
    }

    public MapGroup() {
    }

    @Override
    public String toString() {
        return "MapGroup{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }
}
