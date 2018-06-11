package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/16.
 */

public class AuxiliaryRes {
    String result;
    String auxiliaryState;

    @Override
    public String toString() {
        return "AuxiliaryRes{" +
                "result='" + result + '\'' +
                ", auxiliaryState='" + auxiliaryState + '\'' +
                '}';
    }

    public AuxiliaryRes() {
    }

    public AuxiliaryRes(String result, String auxiliaryState) {

        this.result = result;
        this.auxiliaryState = auxiliaryState;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAuxiliaryState() {
        return auxiliaryState;
    }

    public void setAuxiliaryState(String auxiliaryState) {
        this.auxiliaryState = auxiliaryState;
    }
}
