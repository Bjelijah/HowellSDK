package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/14.
 */

public class VideoParamReq {
    String account;
    String session;
    String devId;
    Integer channelNo;
    String videoStandard;
    Integer rotationDegree;
    Integer brightness;
    Integer contrast;
    Integer saturation;
    Integer hue;
    Boolean infrared;

    @Override
    public String toString() {
        return "VideoParamReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devId='" + devId + '\'' +
                ", channelNo=" + channelNo +
                ", videoStandard='" + videoStandard + '\'' +
                ", rotationDegree=" + rotationDegree +
                ", brightness=" + brightness +
                ", contrast=" + contrast +
                ", saturation=" + saturation +
                ", hue=" + hue +
                ", infrared=" + infrared +
                '}';
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public Integer getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(Integer channelNo) {
        this.channelNo = channelNo;
    }

    public String getVideoStandard() {
        return videoStandard;
    }

    public void setVideoStandard(String videoStandard) {
        this.videoStandard = videoStandard;
    }

    public Integer getRotationDegree() {
        return rotationDegree;
    }

    public void setRotationDegree(Integer rotationDegree) {
        this.rotationDegree = rotationDegree;
    }

    public Integer getBrightness() {
        return brightness;
    }

    public void setBrightness(Integer brightness) {
        this.brightness = brightness;
    }

    public Integer getContrast() {
        return contrast;
    }

    public void setContrast(Integer contrast) {
        this.contrast = contrast;
    }

    public Integer getSaturation() {
        return saturation;
    }

    public void setSaturation(Integer saturation) {
        this.saturation = saturation;
    }

    public Integer getHue() {
        return hue;
    }

    public void setHue(Integer hue) {
        this.hue = hue;
    }

    public Boolean getInfrared() {
        return infrared;
    }

    public void setInfrared(Boolean infrared) {
        this.infrared = infrared;
    }

    public VideoParamReq() {

    }

    public VideoParamReq(String account, String session, String devId, Integer channelNo, String videoStandard, Integer rotationDegree, Integer brightness, Integer contrast, Integer saturation, Integer hue, Boolean infrared) {

        this.account = account;
        this.session = session;
        this.devId = devId;
        this.channelNo = channelNo;
        this.videoStandard = videoStandard;
        this.rotationDegree = rotationDegree;
        this.brightness = brightness;
        this.contrast = contrast;
        this.saturation = saturation;
        this.hue = hue;
        this.infrared = infrared;
    }
}
