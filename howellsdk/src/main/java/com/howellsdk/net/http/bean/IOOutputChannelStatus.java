package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/11.
 */

public class IOOutputChannelStatus {
    @SerializedName("Id") String id;
    @SerializedName("State") String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public IOOutputChannelStatus(String id, String state) {
        this.id = id;
        this.state = state;
    }

    public IOOutputChannelStatus() {
    }

    @Override
    public String toString() {
        return "IOOutputChannelStatus{" +
                "id='" + id + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
