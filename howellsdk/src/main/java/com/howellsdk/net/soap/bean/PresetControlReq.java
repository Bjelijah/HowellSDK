package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/14.
 */

public class PresetControlReq {
    String account;
    String session;
    String devId;
    int channelNo;
    String ptzPreset;
    int presetNo;

    @Override
    public String toString() {
        return "PresetControlReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devId='" + devId + '\'' +
                ", channelNo=" + channelNo +
                ", ptzPreset='" + ptzPreset + '\'' +
                ", presetNo=" + presetNo +
                '}';
    }

    public PresetControlReq() {
    }

    public PresetControlReq(String account, String session, String devId, int channelNo, String ptzPreset, int presetNo) {

        this.account = account;
        this.session = session;
        this.devId = devId;
        this.channelNo = channelNo;
        this.ptzPreset = ptzPreset;
        this.presetNo = presetNo;
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

    public int getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(int channelNo) {
        this.channelNo = channelNo;
    }

    public String getPtzPreset() {
        return ptzPreset;
    }

    public void setPtzPreset(String ptzPreset) {
        this.ptzPreset = ptzPreset;
    }

    public int getPresetNo() {
        return presetNo;
    }

    public void setPresetNo(int presetNo) {
        this.presetNo = presetNo;
    }
}
