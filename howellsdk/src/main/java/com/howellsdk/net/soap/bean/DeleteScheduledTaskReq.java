package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/19.
 */

public class DeleteScheduledTaskReq {
    String account;
    String session;
    String devID;
    String taskID;

    @Override
    public String toString() {
        return "DeleteScheduledTaskReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devID='" + devID + '\'' +
                ", taskID='" + taskID + '\'' +
                '}';
    }

    public DeleteScheduledTaskReq() {
    }

    public DeleteScheduledTaskReq(String account, String session, String devID, String taskID) {

        this.account = account;
        this.session = session;
        this.devID = devID;
        this.taskID = taskID;
    }

    public String getAccount() {

        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getDevID() {
        return devID;
    }

    public void setDevID(String devID) {
        this.devID = devID;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }
}
