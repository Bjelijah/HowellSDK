package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/11/23.
 */

public class TimePeriod {
    @SerializedName("BeginTime")            String begTime;
    @SerializedName("EndTime")              String endTIme;

    @Override
    public String toString() {
        return "TimePeriod{" +
                "begTime='" + begTime + '\'' +
                ", endTIme='" + endTIme + '\'' +
                '}';
    }

    public String getBegTime() {
        return begTime;
    }

    public void setBegTime(String begTime) {
        this.begTime = begTime;
    }

    public String getEndTIme() {
        return endTIme;
    }

    public void setEndTIme(String endTIme) {
        this.endTIme = endTIme;
    }

    public TimePeriod() {

    }

    public TimePeriod(String begTime, String endTIme) {

        this.begTime = begTime;
        this.endTIme = endTIme;
    }
}
