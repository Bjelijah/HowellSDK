package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/19.
 */

public class CreateScheduledTaskReq {
    String account;
    String session;
    String devID;
    Task task;
    Auxiliary auxiliary;

    @Override
    public String toString() {
        return "CreateScheduledTaskReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devID='" + devID + '\'' +
                ", task=" + task +
                ", auxiliary=" + auxiliary +
                '}';
    }

    public CreateScheduledTaskReq() {
    }

    public CreateScheduledTaskReq(String account, String session, String devID, Task task, Auxiliary auxiliary) {

        this.account = account;
        this.session = session;
        this.devID = devID;
        this.task = task;
        this.auxiliary = auxiliary;
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

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Auxiliary getAuxiliary() {
        return auxiliary;
    }

    public void setAuxiliary(Auxiliary auxiliary) {
        this.auxiliary = auxiliary;
    }

    public static class Task{
        String taskID;
        String name;
        Boolean enabled;
        String timeType;
        String time;
        String actionType;

        @Override
        public String toString() {
            return "Task{" +
                    "taskID='" + taskID + '\'' +
                    ", name='" + name + '\'' +
                    ", enabled=" + enabled +
                    ", timeType='" + timeType + '\'' +
                    ", time='" + time + '\'' +
                    ", actionType='" + actionType + '\'' +
                    '}';
        }

        public Task() {
        }

        public Task(String taskID, String name, Boolean enabled, String timeType, String time, String actionType) {

            this.taskID = taskID;
            this.name = name;
            this.enabled = enabled;
            this.timeType = timeType;
            this.time = time;
            this.actionType = actionType;
        }

        public String getTaskID() {

            return taskID;
        }

        public void setTaskID(String taskID) {
            this.taskID = taskID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Boolean getEnabled() {
            return enabled;
        }

        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }

        public String getTimeType() {
            return timeType;
        }

        public void setTimeType(String timeType) {
            this.timeType = timeType;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getActionType() {
            return actionType;
        }

        public void setActionType(String actionType) {
            this.actionType = actionType;
        }
    }

    public static class Auxiliary{
        String auxiliaryType;
        String auxiliaryState;

        @Override
        public String toString() {
            return "Auxiliary{" +
                    "auxiliaryType='" + auxiliaryType + '\'' +
                    ", auxiliaryState='" + auxiliaryState + '\'' +
                    '}';
        }

        public Auxiliary() {
        }

        public Auxiliary(String auxiliaryType, String auxiliaryState) {

            this.auxiliaryType = auxiliaryType;
            this.auxiliaryState = auxiliaryState;
        }

        public String getAuxiliaryType() {

            return auxiliaryType;
        }

        public void setAuxiliaryType(String auxiliaryType) {
            this.auxiliaryType = auxiliaryType;
        }

        public String getAuxiliaryState() {
            return auxiliaryState;
        }

        public void setAuxiliaryState(String auxiliaryState) {
            this.auxiliaryState = auxiliaryState;
        }
    }

}
