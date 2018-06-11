package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/16.
 */

public class PUOnOffLogReq {
    String account;
    String session;
    String devID;
    String startTime;
    String endTime;
    Integer pageNo;
    String searchID;
    Integer pageSize;

    @Override
    public String toString() {
        return "PUOnOffLogReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devID='" + devID + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", pageNo=" + pageNo +
                ", searchID='" + searchID + '\'' +
                ", pageSize=" + pageSize +
                '}';
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public String getSearchID() {
        return searchID;
    }

    public void setSearchID(String searchID) {
        this.searchID = searchID;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public PUOnOffLogReq() {

    }

    public PUOnOffLogReq(String account, String session, String devID, String startTime, String endTime, Integer pageNo, String searchID, Integer pageSize) {

        this.account = account;
        this.session = session;
        this.devID = devID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.pageNo = pageNo;
        this.searchID = searchID;
        this.pageSize = pageSize;
    }
}
