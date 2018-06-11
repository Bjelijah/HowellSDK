package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/11/22.
 */

public class PeriodThreshold {
    @SerializedName("Period")         Integer period;
    @SerializedName("Max")            Integer max;
    @SerializedName("Min")            Integer min;

    @Override
    public String toString() {
        return "PeriodThreshold{" +
                "period=" + period +
                ", max=" + max +
                ", min=" + min +
                '}';
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public PeriodThreshold() {

    }

    public PeriodThreshold(Integer period, Integer max, Integer min) {

        this.period = period;
        this.max = max;
        this.min = min;
    }
}
