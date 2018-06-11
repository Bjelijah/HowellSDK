package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/19.
 */

public class DeviceBondedRes {
    String result;
    Boolean hasBonded;

    @Override
    public String toString() {
        return "DeviceBondedRes{" +
                "result='" + result + '\'' +
                ", hasBonded=" + hasBonded +
                '}';
    }

    public DeviceBondedRes() {
    }

    public DeviceBondedRes(String result, Boolean hasBonded) {

        this.result = result;
        this.hasBonded = hasBonded;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Boolean getHasBonded() {
        return hasBonded;
    }

    public void setHasBonded(Boolean hasBonded) {
        this.hasBonded = hasBonded;
    }
}
