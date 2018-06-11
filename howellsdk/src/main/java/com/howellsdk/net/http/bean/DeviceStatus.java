package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/13.
 */

public class DeviceStatus {
    @SerializedName("Id") String id;
    @SerializedName("CpuUsage") Double cpuUsage;
    @SerializedName("MemoryUsage") Double memoryUsage;
    @SerializedName("WorkingSeconds") Long workingSeconds;
    @SerializedName("Temperature") Double temperature;
    @SerializedName("Pressure") Double pressure;
    @SerializedName("Voltage") Double voltage;
    @SerializedName("NetworkSpeedRate") Double networkSpeedRate;
    @SerializedName("NetworkUsage") Double networkUsage;
    @SerializedName("VideoConnectionNumber") Integer videoConnectionNumber;
    @SerializedName("StorageMediumAbnormalNumber") Integer storageMediumAbnormalNumber;
    @SerializedName("Online") Boolean online;
    @SerializedName("LastOnlineTime") String lastOnlineTime;
    @SerializedName("WiFiIntensity") Integer wifiIntensity;
    @SerializedName("BatteryRemaining") Integer batteryRemaining;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(double cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public double getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(double memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public long getWorkingSeconds() {
        return workingSeconds;
    }

    public void setWorkingSeconds(long workingSeconds) {
        this.workingSeconds = workingSeconds;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getNetworkSpeedRate() {
        return networkSpeedRate;
    }

    public void setNetworkSpeedRate(double networkSpeedRate) {
        this.networkSpeedRate = networkSpeedRate;
    }

    public double getNetworkUsage() {
        return networkUsage;
    }

    public void setNetworkUsage(double networkUsage) {
        this.networkUsage = networkUsage;
    }

    public int getVideoConnectionNumber() {
        return videoConnectionNumber;
    }

    public void setVideoConnectionNumber(int videoConnectionNumber) {
        this.videoConnectionNumber = videoConnectionNumber;
    }

    public int getStorageMediumAbnormalNumber() {
        return storageMediumAbnormalNumber;
    }

    public void setStorageMediumAbnormalNumber(int storageMediumAbnormalNumber) {
        this.storageMediumAbnormalNumber = storageMediumAbnormalNumber;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getLastOnlineTime() {
        return lastOnlineTime;
    }

    public void setLastOnlineTime(String lastOnlineTime) {
        this.lastOnlineTime = lastOnlineTime;
    }

    public int getWifiIntensity() {
        return wifiIntensity;
    }

    public void setWifiIntensity(int wifiIntensity) {
        this.wifiIntensity = wifiIntensity;
    }

    public int getBatteryRemaining() {
        return batteryRemaining;
    }

    public void setBatteryRemaining(int batteryRemaining) {
        this.batteryRemaining = batteryRemaining;
    }

    public DeviceStatus(String id, double cpuUsage, double memoryUsage, long workingSeconds, double temperature, double pressure, double voltage, double networkSpeedRate, double networkUsage, int videoConnectionNumber, int storageMediumAbnormalNumber, boolean online, String lastOnlineTime, int wifiIntensity, int batteryRemaining) {
        this.id = id;
        this.cpuUsage = cpuUsage;
        this.memoryUsage = memoryUsage;
        this.workingSeconds = workingSeconds;
        this.temperature = temperature;
        this.pressure = pressure;
        this.voltage = voltage;
        this.networkSpeedRate = networkSpeedRate;
        this.networkUsage = networkUsage;
        this.videoConnectionNumber = videoConnectionNumber;
        this.storageMediumAbnormalNumber = storageMediumAbnormalNumber;
        this.online = online;
        this.lastOnlineTime = lastOnlineTime;
        this.wifiIntensity = wifiIntensity;
        this.batteryRemaining = batteryRemaining;
    }

    public DeviceStatus() {
    }

    @Override
    public String toString() {
        return "DeviceStatus{" +
                "id='" + id + '\'' +
                ", cpuUsage=" + cpuUsage +
                ", memoryUsage=" + memoryUsage +
                ", workingSeconds=" + workingSeconds +
                ", temperature=" + temperature +
                ", pressure=" + pressure +
                ", voltage=" + voltage +
                ", networkSpeedRate=" + networkSpeedRate +
                ", networkUsage=" + networkUsage +
                ", videoConnectionNumber=" + videoConnectionNumber +
                ", storageMediumAbnormalNumber=" + storageMediumAbnormalNumber +
                ", online=" + online +
                ", lastOnlineTime='" + lastOnlineTime + '\'' +
                ", wifiIntensity=" + wifiIntensity +
                ", batteryRemaining=" + batteryRemaining +
                '}';
    }
}
