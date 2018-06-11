package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/11.
 */

public class IOInputChannelStatus {
    @SerializedName("Id") String id;
    @SerializedName("State") String state;
    @SerializedName("ArmType") String armType;

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

    public String getArmType() {
        return armType;
    }

    public void setArmType(String armType) {
        this.armType = armType;
    }

    public IOInputChannelStatus(String id, String state, String armType) {
        this.id = id;
        this.state = state;
        this.armType = armType;
    }

    public IOInputChannelStatus() {
    }

    @Override
    public String toString() {
        return "IOInputChannelStatus{" +
                "id='" + id + '\'' +
                ", state='" + state + '\'' +
                ", armType='" + armType + '\'' +
                '}';
    }
}
