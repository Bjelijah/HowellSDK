package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/14.
 */

public class SetCodingParamReq {
    String account;
    String session;
    String devId;
    Integer channelNo;
    String streamType;
    String frameSize;
    Integer frameRate;
    String rateType;
    Integer bitRate;
    Integer imageQuality;
    Boolean audioInput;

    @Override
    public String toString() {
        return "SetCodingParamReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devId='" + devId + '\'' +
                ", channelNo=" + channelNo +
                ", streamType='" + streamType + '\'' +
                ", frameSize='" + frameSize + '\'' +
                ", frameRate=" + frameRate +
                ", rateType='" + rateType + '\'' +
                ", bitRate=" + bitRate +
                ", imageQuality=" + imageQuality +
                ", audioInput=" + audioInput +
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

    public String getStreamType() {
        return streamType;
    }

    public void setStreamType(String streamType) {
        this.streamType = streamType;
    }

    public String getFrameSize() {
        return frameSize;
    }

    public void setFrameSize(String frameSize) {
        this.frameSize = frameSize;
    }

    public Integer getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(Integer frameRate) {
        this.frameRate = frameRate;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public Integer getBitRate() {
        return bitRate;
    }

    public void setBitRate(Integer bitRate) {
        this.bitRate = bitRate;
    }

    public Integer getImageQuality() {
        return imageQuality;
    }

    public void setImageQuality(Integer imageQuality) {
        this.imageQuality = imageQuality;
    }

    public Boolean getAudioInput() {
        return audioInput;
    }

    public void setAudioInput(Boolean audioInput) {
        this.audioInput = audioInput;
    }

    public SetCodingParamReq() {

    }

    public SetCodingParamReq(String account, String session, String devId, Integer channelNo, String streamType, String frameSize, Integer frameRate, String rateType, Integer bitRate, Integer imageQuality, Boolean audioInput) {

        this.account = account;
        this.session = session;
        this.devId = devId;
        this.channelNo = channelNo;
        this.streamType = streamType;
        this.frameSize = frameSize;
        this.frameRate = frameRate;
        this.rateType = rateType;
        this.bitRate = bitRate;
        this.imageQuality = imageQuality;
        this.audioInput = audioInput;
    }
}
