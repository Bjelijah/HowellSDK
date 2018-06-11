package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/11/3.
 */

public class PDCDeviceStatus {
    @SerializedName("Id")               String id;
    @SerializedName("IsOnline")         Boolean isOnline;
    @SerializedName("LastUpdateTime")   String lastUpdateTime;
    @SerializedName("LeaveNumber")      Integer leaveNumber;
    @SerializedName("EnterNumber")      Integer enterNumber;
    @SerializedName("DeviationNumber")  Integer deviationNumber;
    @SerializedName("PassingNumber")    Integer passingNumber;
    @SerializedName("lastResetTime")    String lastResetTime;
    @SerializedName("LastNLeaveNumber") Integer lastNLeaverNumber;
    @SerializedName("LastNEnterNumber") Integer lastNEnterNumber;

    @Override
    public String toString() {
        return "PDCDeviceStatus{" +
                "id='" + id + '\'' +
                ", isOnline=" + isOnline +
                ", lastUpdateTime='" + lastUpdateTime + '\'' +
                ", leaveNumber=" + leaveNumber +
                ", enterNumber=" + enterNumber +
                ", deviationNumber=" + deviationNumber +
                ", passingNumber=" + passingNumber +
                ", lastResetTime='" + lastResetTime + '\'' +
                ", lastNLeaverNumber=" + lastNLeaverNumber +
                ", lastNEnterNumber=" + lastNEnterNumber +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public void setOnline(Boolean online) {
        isOnline = online;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getLeaveNumber() {
        return leaveNumber;
    }

    public void setLeaveNumber(Integer leaveNumber) {
        this.leaveNumber = leaveNumber;
    }

    public Integer getEnterNumber() {
        return enterNumber;
    }

    public void setEnterNumber(Integer enterNumber) {
        this.enterNumber = enterNumber;
    }

    public Integer getDeviationNumber() {
        return deviationNumber;
    }

    public void setDeviationNumber(Integer deviationNumber) {
        this.deviationNumber = deviationNumber;
    }

    public Integer getPassingNumber() {
        return passingNumber;
    }

    public void setPassingNumber(Integer passingNumber) {
        this.passingNumber = passingNumber;
    }

    public String getLastResetTime() {
        return lastResetTime;
    }

    public void setLastResetTime(String lastResetTime) {
        this.lastResetTime = lastResetTime;
    }

    public Integer getLastNLeaverNumber() {
        return lastNLeaverNumber;
    }

    public void setLastNLeaverNumber(Integer lastNLeaverNumber) {
        this.lastNLeaverNumber = lastNLeaverNumber;
    }

    public Integer getLastNEnterNumber() {
        return lastNEnterNumber;
    }

    public void setLastNEnterNumber(Integer lastNEnterNumber) {
        this.lastNEnterNumber = lastNEnterNumber;
    }

    public PDCDeviceStatus() {

    }

    public PDCDeviceStatus(String id, Boolean isOnline, String lastUpdateTime, Integer leaveNumber, Integer enterNumber, Integer deviationNumber, Integer passingNumber, String lastResetTime, Integer lastNLeaverNumber, Integer lastNEnterNumber) {

        this.id = id;
        this.isOnline = isOnline;
        this.lastUpdateTime = lastUpdateTime;
        this.leaveNumber = leaveNumber;
        this.enterNumber = enterNumber;
        this.deviationNumber = deviationNumber;
        this.passingNumber = passingNumber;
        this.lastResetTime = lastResetTime;
        this.lastNLeaverNumber = lastNLeaverNumber;
        this.lastNEnterNumber = lastNEnterNumber;
    }
}
