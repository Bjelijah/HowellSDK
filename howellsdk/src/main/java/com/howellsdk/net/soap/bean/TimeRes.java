package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/15.
 */

public class TimeRes {
    String result;
    String time;
    String timeZone;
    String POSIXTimeZone;

    @Override
    public String toString() {
        return "TimeRes{" +
                "result='" + result + '\'' +
                ", time='" + time + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", POSIXTimeZone='" + POSIXTimeZone + '\'' +
                '}';
    }

    public TimeRes() {
    }

    public TimeRes(String result, String time, String timeZone, String POSIXTimeZone) {

        this.result = result;
        this.time = time;
        this.timeZone = timeZone;
        this.POSIXTimeZone = POSIXTimeZone;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getPOSIXTimeZone() {
        return POSIXTimeZone;
    }

    public void setPOSIXTimeZone(String POSIXTimeZone) {
        this.POSIXTimeZone = POSIXTimeZone;
    }
}
