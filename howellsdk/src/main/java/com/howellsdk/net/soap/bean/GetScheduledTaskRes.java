package com.howellsdk.net.soap.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/19.
 */

public class GetScheduledTaskRes {
    String result;
    ArrayList<Task> tasks;
    Auxiliary auxiliary;

    @Override
    public String toString() {
        return "GetScheduledTaskRes{" +
                "result='" + result + '\'' +
                ", tasks=" + tasks +
                ", auxiliary=" + auxiliary +
                '}';
    }

    public GetScheduledTaskRes() {
    }

    public GetScheduledTaskRes(String result, ArrayList<Task> tasks, Auxiliary auxiliary) {

        this.result = result;
        this.tasks = tasks;
        this.auxiliary = auxiliary;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
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
