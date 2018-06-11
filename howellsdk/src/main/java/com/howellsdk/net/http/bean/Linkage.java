package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/10.
 */

public class Linkage {
    @SerializedName("Id") String id;
    @SerializedName("Name") String name;
    @SerializedName("ScriptType") String scriptType;
    @SerializedName("Script") String script;
    @SerializedName("DeviceId") String deviceId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScriptType() {
        return scriptType;
    }

    public void setScriptType(String scriptType) {
        this.scriptType = scriptType;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Linkage(String id, String name, String scriptType, String script, String deviceId) {
        this.id = id;
        this.name = name;
        this.scriptType = scriptType;
        this.script = script;
        this.deviceId = deviceId;
    }

    public Linkage() {
    }

    @Override
    public String toString() {
        return "Linkage{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", scriptType='" + scriptType + '\'' +
                ", script='" + script + '\'' +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }
}
