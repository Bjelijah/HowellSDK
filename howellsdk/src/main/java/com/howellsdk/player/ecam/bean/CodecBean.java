package com.howellsdk.player.ecam.bean;

/**
 * Created by Administrator on 2017/2/24.
 */

public class CodecBean {
    int audioChannels;
    int audioSamples;
    int audioBitwidth;
    int audioCodec;
    int videoCodec;


    public int getAudioChannels() {
        return audioChannels;
    }

    public CodecBean setAudioChannels(int audioChannels) {
        this.audioChannels = audioChannels;
        return this;
    }

    public int getAudioSamples() {
        return audioSamples;
    }

    public CodecBean setAudioSamples(int audioSamples) {
        this.audioSamples = audioSamples;
        return this;
    }

    public int getAudioBitwidth() {
        return audioBitwidth;
    }

    public CodecBean setAudioBitwidth(int audioBitwidth) {
        this.audioBitwidth = audioBitwidth;
        return this;
    }

    public int getAudioCodec() {
        return audioCodec;
    }

    public CodecBean setAudioCodec(int audioCodec) {
        this.audioCodec = audioCodec;
        return this;
    }

    public int getVideoCodec() {
        return videoCodec;
    }

    public CodecBean setVideoCodec(int videoCodec) {
        this.videoCodec = videoCodec;
        return this;
    }

    @Override
    public String toString() {
        return "CodecBean{" +
                "audioChannels=" + audioChannels +
                ", audioSamples=" + audioSamples +
                ", audioBitwidth=" + audioBitwidth +
                ", audioCodec=" + audioCodec +
                ", videoCodec=" + videoCodec +
                '}';
    }
}
