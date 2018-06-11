package com.howellsdk.net.soap.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/16.
 */

public class PUOnOffLogRes {
    String result;
    Integer pageNo;
    Integer pageCount;
    Integer recordCount;
    ArrayList<Log> logs;

    @Override
    public String toString() {
        return "PUOnOffLogRes{" +
                "result='" + result + '\'' +
                ", pageNo=" + pageNo +
                ", pageCount=" + pageCount +
                ", recordCount=" + recordCount +
                ", logs=" + logs +
                '}';
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public ArrayList<Log> getLogs() {
        return logs;
    }

    public void setLogs(ArrayList<Log> logs) {
        this.logs = logs;
    }

    public PUOnOffLogRes() {

    }

    public PUOnOffLogRes(String result, Integer pageNo, Integer pageCount, Integer recordCount, ArrayList<Log> logs) {

        this.result = result;
        this.pageNo = pageNo;
        this.pageCount = pageCount;
        this.recordCount = recordCount;
        this.logs = logs;
    }

    public static class Log{
        String devID;
        String time;
        String offTime;
        String offReason;

        @Override
        public String toString() {
            return "Log{" +
                    "devID='" + devID + '\'' +
                    ", time='" + time + '\'' +
                    ", offTime='" + offTime + '\'' +
                    ", offReason='" + offReason + '\'' +
                    '}';
        }

        public Log() {
        }

        public Log(String devID, String time, String offTime, String offReason) {

            this.devID = devID;
            this.time = time;
            this.offTime = offTime;
            this.offReason = offReason;
        }

        public String getDevID() {

            return devID;
        }

        public void setDevID(String devID) {
            this.devID = devID;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getOffTime() {
            return offTime;
        }

        public void setOffTime(String offTime) {
            this.offTime = offTime;
        }

        public String getOffReason() {
            return offReason;
        }

        public void setOffReason(String offReason) {
            this.offReason = offReason;
        }
    }
}
