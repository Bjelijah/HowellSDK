package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/15.
 */

public class OSDParamReq {
    String account;
    String session;
    String devId;
    Integer channelNo;
    Boolean enable;
    Boolean timestanpEnable;
    String dateTimeFormat;
    String displayText;
    Integer fontSize;
    Integer fontColor;
    Integer textPositionX;
    Integer textPositionY;
    Integer timestampPositionX;
    Integer timestampPositionY;

    @Override
    public String toString() {
        return "OSDParamReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devId='" + devId + '\'' +
                ", channelNo=" + channelNo +
                ", enable=" + enable +
                ", timestanpEnable=" + timestanpEnable +
                ", dateTimeFormat='" + dateTimeFormat + '\'' +
                ", displayText='" + displayText + '\'' +
                ", fontSize=" + fontSize +
                ", fontColor=" + fontColor +
                ", textPositionX=" + textPositionX +
                ", textPositionY=" + textPositionY +
                ", timestampPositionX=" + timestampPositionX +
                ", timestampPositionY=" + timestampPositionY +
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

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getTimestanpEnable() {
        return timestanpEnable;
    }

    public void setTimestanpEnable(Boolean timestanpEnable) {
        this.timestanpEnable = timestanpEnable;
    }

    public String getDateTimeFormat() {
        return dateTimeFormat;
    }

    public void setDateTimeFormat(String dateTimeFormat) {
        this.dateTimeFormat = dateTimeFormat;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public Integer getFontColor() {
        return fontColor;
    }

    public void setFontColor(Integer fontColor) {
        this.fontColor = fontColor;
    }

    public Integer getTextPositionX() {
        return textPositionX;
    }

    public void setTextPositionX(Integer textPositionX) {
        this.textPositionX = textPositionX;
    }

    public Integer getTextPositionY() {
        return textPositionY;
    }

    public void setTextPositionY(Integer textPositionY) {
        this.textPositionY = textPositionY;
    }

    public Integer getTimestampPositionX() {
        return timestampPositionX;
    }

    public void setTimestampPositionX(Integer timestampPositionX) {
        this.timestampPositionX = timestampPositionX;
    }

    public Integer getTimestampPositionY() {
        return timestampPositionY;
    }

    public void setTimestampPositionY(Integer timestampPositionY) {
        this.timestampPositionY = timestampPositionY;
    }

    public OSDParamReq() {

    }

    public OSDParamReq(String account, String session, String devId, Integer channelNo, Boolean enable, Boolean timestanpEnable, String dateTimeFormat, String displayText, Integer fontSize, Integer fontColor, Integer textPositionX, Integer textPositionY, Integer timestampPositionX, Integer timestampPositionY) {

        this.account = account;
        this.session = session;
        this.devId = devId;
        this.channelNo = channelNo;
        this.enable = enable;
        this.timestanpEnable = timestanpEnable;
        this.dateTimeFormat = dateTimeFormat;
        this.displayText = displayText;
        this.fontSize = fontSize;
        this.fontColor = fontColor;
        this.textPositionX = textPositionX;
        this.textPositionY = textPositionY;
        this.timestampPositionX = timestampPositionX;
        this.timestampPositionY = timestampPositionY;
    }
}
