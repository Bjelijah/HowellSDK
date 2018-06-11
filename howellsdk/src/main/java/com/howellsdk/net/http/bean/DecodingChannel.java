package com.howellsdk.net.http.bean;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/10.
 */

public class DecodingChannel {
    @SerializedName("Id") String id;
    @SerializedName("Enabled") Boolean enable;
    @SerializedName("SupportedCodecFormats") String supportedCodecFormats;
    @SerializedName("PseudoCode") Boolean pseudoCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public @Nullable String getSupportedCodecFormats() {
        return supportedCodecFormats;
    }

    public void setSupportedCodecFormats(String supportedCodecFormats) {
        this.supportedCodecFormats = supportedCodecFormats;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getPseudoCode() {
        return pseudoCode;
    }

    public void setPseudoCode(Boolean pseudoCode) {
        this.pseudoCode = pseudoCode;
    }

    public DecodingChannel(String id, Boolean enable, String supportedCodecFormats, Boolean pseudoCode) {

        this.id = id;
        this.enable = enable;
        this.supportedCodecFormats = supportedCodecFormats;
        this.pseudoCode = pseudoCode;
    }

    public DecodingChannel() {
    }

    @Override
    public String toString() {
        return "DecodingChannel{" +
                "id='" + id + '\'' +
                ", enable=" + enable +
                ", supportedCodecFormats='" + supportedCodecFormats + '\'' +
                ", pseudoCode=" + pseudoCode +
                '}';
    }
}
