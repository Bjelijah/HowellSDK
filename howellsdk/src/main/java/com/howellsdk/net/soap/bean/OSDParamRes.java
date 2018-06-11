package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/14.
 */

public class OSDParamRes {
    String result;
    Boolean enable;
    Boolean timestampEnabled;
    String dateTimeFormat;
    String displayText;
    int fontSize;
    int fontColor;
    int textPositionX;
    int textPositionY;
    int timestampPositionX;
    int timestampPositionY;

    @Override
    public String toString() {
        return "OSDParamRes{" +
                "result='" + result + '\'' +
                ", enable=" + enable +
                ", timestampEnabled=" + timestampEnabled +
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

    public OSDParamRes(String result, Boolean enable, Boolean timestampEnabled, String dateTimeFormat, String displayText, int fontSize, int fontColor, int textPositionX, int textPositionY, int timestampPositionX, int timestampPositionY) {

        this.result = result;
        this.enable = enable;
        this.timestampEnabled = timestampEnabled;
        this.dateTimeFormat = dateTimeFormat;
        this.displayText = displayText;
        this.fontSize = fontSize;
        this.fontColor = fontColor;
        this.textPositionX = textPositionX;
        this.textPositionY = textPositionY;
        this.timestampPositionX = timestampPositionX;
        this.timestampPositionY = timestampPositionY;
    }

    public OSDParamRes() {

    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getTimestampEnabled() {
        return timestampEnabled;
    }

    public void setTimestampEnabled(Boolean timestampEnabled) {
        this.timestampEnabled = timestampEnabled;
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

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public int getFontColor() {
        return fontColor;
    }

    public void setFontColor(int fontColor) {
        this.fontColor = fontColor;
    }

    public int getTextPositionX() {
        return textPositionX;
    }

    public void setTextPositionX(int textPositionX) {
        this.textPositionX = textPositionX;
    }

    public int getTextPositionY() {
        return textPositionY;
    }

    public void setTextPositionY(int textPositionY) {
        this.textPositionY = textPositionY;
    }

    public int getTimestampPositionX() {
        return timestampPositionX;
    }

    public void setTimestampPositionX(int timestampPositionX) {
        this.timestampPositionX = timestampPositionX;
    }

    public int getTimestampPositionY() {
        return timestampPositionY;
    }

    public void setTimestampPositionY(int timestampPositionY) {
        this.timestampPositionY = timestampPositionY;
    }
}
