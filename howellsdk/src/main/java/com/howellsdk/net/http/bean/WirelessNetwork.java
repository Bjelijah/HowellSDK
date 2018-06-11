package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/8/10.
 */

public class WirelessNetwork {
    @SerializedName("SSID")         String ssid;
    @SerializedName("Connected")    boolean connected;
    @SerializedName("Intensity")    double intensity;
    @SerializedName("Frequency")    double frequency;
    @SerializedName("Channel")      int channel;

    @Override
    public String toString() {
        return "WirelessNetwork{" +
                "ssid='" + ssid + '\'' +
                ", connected=" + connected +
                ", intensity=" + intensity +
                ", frequency=" + frequency +
                ", channel=" + channel +
                '}';
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public double getIntensity() {
        return intensity;
    }

    public void setIntensity(double intensity) {
        this.intensity = intensity;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public WirelessNetwork() {

    }

    public WirelessNetwork(String ssid, boolean connected, double intensity, double frequency, int channel) {

        this.ssid = ssid;
        this.connected = connected;
        this.intensity = intensity;
        this.frequency = frequency;
        this.channel = channel;
    }
}
