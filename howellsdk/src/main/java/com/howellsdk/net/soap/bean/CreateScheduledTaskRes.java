package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/19.
 */

public class CreateScheduledTaskRes {
    String result;
    String taskID;

    @Override
    public String toString() {
        return "CreateScheduledTaskRes{" +
                "result='" + result + '\'' +
                ", taskID='" + taskID + '\'' +
                '}';
    }

    public CreateScheduledTaskRes() {
    }

    public CreateScheduledTaskRes(String result, String taskID) {

        this.result = result;
        this.taskID = taskID;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }
}
