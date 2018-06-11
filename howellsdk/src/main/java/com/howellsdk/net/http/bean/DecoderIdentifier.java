package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/11.
 */

public class DecoderIdentifier {
    @SerializedName("DeviceId") String deviceId;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public DecoderIdentifier(String deviceId) {
        this.deviceId = deviceId;
    }

    public DecoderIdentifier() {
    }

    @Override
    public String toString() {
        return "DecoderIdentifier{" +
                "deviceId='" + deviceId + '\'' +
                '}';
    }
}
