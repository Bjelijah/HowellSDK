package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/8/11.
 */

public class VideoCodec {
    @SerializedName("Codec") String codec;
    @SerializedName("Resolution") Resolution resolution;
    @SerializedName("VideoQualityControlType") String videoQualityControlType;
    @SerializedName("VideoBitrateUpperCap") Double videoBitrateUpperCap;
    @SerializedName("FrameRate") Double frameRate;
    @SerializedName("GOP") Integer gop;

    public VideoCodec() {
    }

    @Override
    public String toString() {
        return "VideoCodec{" +
                "codec='" + codec + '\'' +
                ", resolution=" + resolution +
                ", videoQualityControlType='" + videoQualityControlType + '\'' +
                ", videoBitrateUpperCap=" + videoBitrateUpperCap +
                ", frameRate=" + frameRate +
                ", gop=" + gop +
                '}';
    }

    public String getCodec() {
        return codec;
    }

    public void setCodec(String codec) {
        this.codec = codec;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    public String getVideoQualityControlType() {
        return videoQualityControlType;
    }

    public void setVideoQualityControlType(String videoQualityControlType) {
        this.videoQualityControlType = videoQualityControlType;
    }

    public Double getVideoBitrateUpperCap() {
        return videoBitrateUpperCap;
    }

    public void setVideoBitrateUpperCap(Double videoBitrateUpperCap) {
        this.videoBitrateUpperCap = videoBitrateUpperCap;
    }

    public Double getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(Double frameRate) {
        this.frameRate = frameRate;
    }

    public Integer getGop() {
        return gop;
    }

    public void setGop(Integer gop) {
        this.gop = gop;
    }

    public VideoCodec(String codec, Resolution resolution, String videoQualityControlType, Double videoBitrateUpperCap, Double frameRate, Integer gop) {

        this.codec = codec;
        this.resolution = resolution;
        this.videoQualityControlType = videoQualityControlType;
        this.videoBitrateUpperCap = videoBitrateUpperCap;
        this.frameRate = frameRate;
        this.gop = gop;
    }
}
