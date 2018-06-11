package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/23.
 */

public class DailySchedule {
    @SerializedName("DayOfWeek")   String dayOfWeek;
    @SerializedName("TimePeriod")  ArrayList<TimePeriod> timePeriods;

    @Override
    public String toString() {
        return "DailySchedule{" +
                "dayOfWeek='" + dayOfWeek + '\'' +
                ", timePeriods=" + timePeriods +
                '}';
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public ArrayList<TimePeriod> getTimePeriods() {
        return timePeriods;
    }

    public void setTimePeriods(ArrayList<TimePeriod> timePeriods) {
        this.timePeriods = timePeriods;
    }

    public DailySchedule() {

    }

    public DailySchedule(String dayOfWeek, ArrayList<TimePeriod> timePeriods) {

        this.dayOfWeek = dayOfWeek;
        this.timePeriods = timePeriods;
    }
}
