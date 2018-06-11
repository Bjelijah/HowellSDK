package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/14.
 */

public class Result {
    String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Result(String result) {
        this.result = result;
    }
    public Result(){}

    @Override
    public String toString() {
        return "Result{" +
                "result='" + result + '\'' +
                '}';
    }
}
