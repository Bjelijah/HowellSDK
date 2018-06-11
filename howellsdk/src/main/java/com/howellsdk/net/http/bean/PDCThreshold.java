package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/11/22.
 */

public class PDCThreshold {
    @SerializedName("Max")      Integer max;
    @SerializedName("Min")      Integer min;

    @Override
    public String toString() {
        return "PDCThreshold{" +
                "max=" + max +
                ", min=" + min +
                '}';
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

    public PDCThreshold() {

    }

    public PDCThreshold(Integer max, Integer min) {

        this.max = max;
        this.min = min;
    }
}
