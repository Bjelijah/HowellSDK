package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/12.
 */

public class Coordinate {
    @SerializedName("X") Double x;
    @SerializedName("Y") Double y;

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Coordinate() {

    }

    public Coordinate(Double x, Double y) {

        this.x = x;
        this.y = y;
    }
}
