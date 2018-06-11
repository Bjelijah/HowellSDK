package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/11/23.
 */

public class PDCSample {
    @SerializedName("LeaveNumber")        Integer leaveNumber;
    @SerializedName("EnterNumber")        Integer enterNumber;
    @SerializedName("DeviationNumber")    Integer deviationNumber;
    @SerializedName("PassingNumber")      Integer passingNumber;
    @SerializedName("BeginTime")          String begTime;
    @SerializedName("EndTime")            String endTime;

    @Override
    public String toString() {
        return "PDCSample{" +
                "leaveNumber=" + leaveNumber +
                ", enterNumber=" + enterNumber +
                ", deviationNumber=" + deviationNumber +
                ", passingNumber=" + passingNumber +
                ", begTime='" + begTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
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

    public String getBegTime() {
        return begTime;
    }

    public void setBegTime(String begTime) {
        this.begTime = begTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public PDCSample() {

    }

    public PDCSample(Integer leaveNumber, Integer enterNumber, Integer deviationNumber, Integer passingNumber, String begTime, String endTime) {

        this.leaveNumber = leaveNumber;
        this.enterNumber = enterNumber;
        this.deviationNumber = deviationNumber;
        this.passingNumber = passingNumber;
        this.begTime = begTime;
        this.endTime = endTime;
    }
}
