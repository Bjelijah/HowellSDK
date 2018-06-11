package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/23.
 */

public class WeeklySchedule {
    @SerializedName("Enabled")          Boolean enable;
    @SerializedName("DailySchedule")    ArrayList<DailySchedule> dailySchedules;

    @Override
    public String toString() {
        return "WeeklySchedule{" +
                "enable=" + enable +
                ", dailySchedules=" + dailySchedules +
                '}';
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public ArrayList<DailySchedule> getDailySchedules() {
        return dailySchedules;
    }

    public void setDailySchedules(ArrayList<DailySchedule> dailySchedules) {
        this.dailySchedules = dailySchedules;
    }

    public WeeklySchedule() {

    }

    public WeeklySchedule(Boolean enable, ArrayList<DailySchedule> dailySchedules) {

        this.enable = enable;
        this.dailySchedules = dailySchedules;
    }
}
