package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/14.
 */

public class VideoParamRes {
    String result;
    String videoStandard;
    int rotationDegree;
    int brightness;
    int contrast;
    int saturation;
    int hue;
    Boolean infrared;

    @Override
    public String toString() {
        return "VideoParamRes{" +
                "result='" + result + '\'' +
                ", videoStandard='" + videoStandard + '\'' +
                ", rotationDegree=" + rotationDegree +
                ", brightness=" + brightness +
                ", contrast=" + contrast +
                ", saturation=" + saturation +
                ", hue=" + hue +
                ", infrared=" + infrared +
                '}';
    }

    public VideoParamRes() {
    }

    public VideoParamRes(String result, String videoStandard, int rotationDegree, int brightness, int contrast, int saturation, int hue, Boolean infrared) {

        this.result = result;
        this.videoStandard = videoStandard;
        this.rotationDegree = rotationDegree;
        this.brightness = brightness;
        this.contrast = contrast;
        this.saturation = saturation;
        this.hue = hue;
        this.infrared = infrared;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getVideoStandard() {
        return videoStandard;
    }

    public void setVideoStandard(String videoStandard) {
        this.videoStandard = videoStandard;
    }

    public int getRotationDegree() {
        return rotationDegree;
    }

    public void setRotationDegree(int rotationDegree) {
        this.rotationDegree = rotationDegree;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public int getContrast() {
        return contrast;
    }

    public void setContrast(int contrast) {
        this.contrast = contrast;
    }

    public int getSaturation() {
        return saturation;
    }

    public void setSaturation(int saturation) {
        this.saturation = saturation;
    }

    public int getHue() {
        return hue;
    }

    public void setHue(int hue) {
        this.hue = hue;
    }

    public Boolean getInfrared() {
        return infrared;
    }

    public void setInfrared(Boolean infrared) {
        this.infrared = infrared;
    }
}
