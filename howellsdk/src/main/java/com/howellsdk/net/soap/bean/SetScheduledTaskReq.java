package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/19.
 */

public class SetScheduledTaskReq {
    String account;
    String session;
    String devID;
    Task task;
    Auxiliary auxiliary;

    @Override
    public String toString() {
        return "SetScheduledTaskReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devID='" + devID + '\'' +
                ", task=" + task +
                ", auxiliary=" + auxiliary +
                '}';
    }

    public SetScheduledTaskReq() {
    }

    public SetScheduledTaskReq(String account, String session, String devID, Task task, Auxiliary auxiliary) {

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
        String auxiliType;
        String auxiliState;

        @Override
        public String toString() {
            return "Auxiliary{" +
                    "auxiliType='" + auxiliType + '\'' +
                    ", auxiliState='" + auxiliState + '\'' +
                    '}';
        }

        public Auxiliary() {
        }

        public Auxiliary(String auxiliType, String auxiliState) {

            this.auxiliType = auxiliType;
            this.auxiliState = auxiliState;
        }

        public String getAuxiliType() {

            return auxiliType;
        }

        public void setAuxiliType(String auxiliType) {
            this.auxiliType = auxiliType;
        }

        public String getAuxiliState() {
            return auxiliState;
        }

        public void setAuxiliState(String auxiliState) {
            this.auxiliState = auxiliState;
        }
    }

}
