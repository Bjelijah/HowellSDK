package com.howellsdk.net.http.bean;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/11.
 */

public class AudioPlayerIdentifier {
    @SerializedName("AudioUrl") String audioUrl;
    @SerializedName("RepeatTimes") Integer repeatTimes;
    @SerializedName("Duration") Integer duration;

    @Override
    public String toString() {
        return "AudioPlayerIdentifier{" +
                "audioUrl='" + audioUrl + '\'' +
                ", repeatTimes=" + repeatTimes +
                ", duration=" + duration +
                '}';
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public @Nullable Integer getRepeatTimes() {
        return repeatTimes;
    }

    public void setRepeatTimes(Integer repeatTimes) {
        this.repeatTimes = repeatTimes;
    }

    public @Nullable Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public AudioPlayerIdentifier() {

    }

    public AudioPlayerIdentifier(String audioUrl, Integer repeatTimes, Integer duration) {

        this.audioUrl = audioUrl;
        this.repeatTimes = repeatTimes;
        this.duration = duration;
    }
}
