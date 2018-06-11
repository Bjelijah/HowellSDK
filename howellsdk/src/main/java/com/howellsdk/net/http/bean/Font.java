package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/8/11.
 */

public class Font {
    @SerializedName("FontSize") Double fontSize;
    @SerializedName("FontColor") Integer fontColor;
    @SerializedName("FontFamily") String fontFamily;
    @SerializedName("Bold") Boolean bold;

    @Override
    public String toString() {
        return "Font{" +
                "fontSize=" + fontSize +
                ", fontColor=" + fontColor +
                ", fontFamily='" + fontFamily + '\'' +
                ", bold=" + bold +
                '}';
    }

    public Double getFontSize() {
        return fontSize;
    }

    public void setFontSize(Double fontSize) {
        this.fontSize = fontSize;
    }

    public Integer getFontColor() {
        return fontColor;
    }

    public void setFontColor(Integer fontColor) {
        this.fontColor = fontColor;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public Boolean getBold() {
        return bold;
    }

    public void setBold(Boolean bold) {
        this.bold = bold;
    }

    public Font() {

    }

    public Font(Double fontSize, Integer fontColor, String fontFamily, Boolean bold) {

        this.fontSize = fontSize;
        this.fontColor = fontColor;
        this.fontFamily = fontFamily;
        this.bold = bold;
    }
}
