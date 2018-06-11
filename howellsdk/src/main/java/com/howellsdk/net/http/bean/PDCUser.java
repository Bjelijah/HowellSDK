package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/11/23.
 */

public class PDCUser {
    @SerializedName("Id")           String id;
    @SerializedName("Username")     String username;
    @SerializedName("Priorities")   Integer priorities;

    @Override
    public String toString() {
        return "PDCUser{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", priorities=" + priorities +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPriorities() {
        return priorities;
    }

    public void setPriorities(Integer priorities) {
        this.priorities = priorities;
    }

    public PDCUser() {

    }

    public PDCUser(String id, String username, Integer priorities) {

        this.id = id;
        this.username = username;
        this.priorities = priorities;
    }
}
