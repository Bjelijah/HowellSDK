package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/11/23.
 */

public class PDCDeviceGroupStatus {
    @SerializedName("Id")                   String id;
    @SerializedName("LastUpdateTime")       String lastUpdateTime;
    @SerializedName("LeaveNumber")          Integer leaveNumber;
    @SerializedName("EnterNumber")          Integer enterNumber;
    @SerializedName("DeviationNumber")      Integer deviationNumber;
    @SerializedName("PassingNumber")        Integer passingNumber;
    @SerializedName("LastResetTime")        String lastResetTime;
    @SerializedName("LastNLeaveNumber")     Integer lastNLeaveNumber;
    @SerializedName("LastNEnterNumber")     Integer lastNEnterNumber;

    @Override
    public String toString() {
        return "PDCDeviceGroupStatus{" +
                "id='" + id + '\'' +
                ", lastUpdateTime='" + lastUpdateTime + '\'' +
                ", leaveNumber=" + leaveNumber +
                ", enterNumber=" + enterNumber +
                ", deviationNumber=" + deviationNumber +
                ", passingNumber=" + passingNumber +
                ", lastResetTime='" + lastResetTime + '\'' +
                ", lastNLeaveNumber=" + lastNLeaveNumber +
                ", lastNEnterNumber=" + lastNEnterNumber +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getLastNLeaveNumber() {
        return lastNLeaveNumber;
    }

    public void setLastNLeaveNumber(Integer lastNLeaveNumber) {
        this.lastNLeaveNumber = lastNLeaveNumber;
    }

    public Integer getLastNEnterNumber() {
        return lastNEnterNumber;
    }

    public void setLastNEnterNumber(Integer lastNEnterNumber) {
        this.lastNEnterNumber = lastNEnterNumber;
    }

    public PDCDeviceGroupStatus() {

    }

    public PDCDeviceGroupStatus(String id, String lastUpdateTime, Integer leaveNumber, Integer enterNumber, Integer deviationNumber, Integer passingNumber, String lastResetTime, Integer lastNLeaveNumber, Integer lastNEnterNumber) {

        this.id = id;
        this.lastUpdateTime = lastUpdateTime;
        this.leaveNumber = leaveNumber;
        this.enterNumber = enterNumber;
        this.deviationNumber = deviationNumber;
        this.passingNumber = passingNumber;
        this.lastResetTime = lastResetTime;
        this.lastNLeaveNumber = lastNLeaveNumber;
        this.lastNEnterNumber = lastNEnterNumber;
    }
}
