package com.howellsdk.net.http.bean;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/8/11.
 */

public class TextIdentifier {
    @SerializedName("Text") String text;
    @SerializedName("Duration") Integer duration;
    @SerializedName("Font") Font font;

    @Override
    public String toString() {
        return "TextIdentifier{" +
                "text='" + text + '\'' +
                ", duration=" + duration +
                ", font=" + font +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public @Nullable Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public TextIdentifier() {

    }

    public TextIdentifier(String text, Integer duration, Font font) {

        this.text = text;
        this.duration = duration;
        this.font = font;
    }
}
