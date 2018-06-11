package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/8/11.
 */

public class Codec {
    @SerializedName("Video") VideoCodec videoCodec;
    @SerializedName("Audio") AudioCodec audioCodec;

    @Override
    public String toString() {
        return "Codec{" +
                "videoCodec=" + videoCodec +
                ", audioCodec=" + audioCodec +
                '}';
    }

    public VideoCodec getVideoCodec() {
        return videoCodec;
    }

    public void setVideoCodec(VideoCodec videoCodec) {
        this.videoCodec = videoCodec;
    }

    public AudioCodec getAudioCodec() {
        return audioCodec;
    }

    public void setAudioCodec(AudioCodec audioCodec) {
        this.audioCodec = audioCodec;
    }

    public Codec() {

    }

    public Codec(VideoCodec videoCodec, AudioCodec audioCodec) {

        this.videoCodec = videoCodec;
        this.audioCodec = audioCodec;
    }
}
