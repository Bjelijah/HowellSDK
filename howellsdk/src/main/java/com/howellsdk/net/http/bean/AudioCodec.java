package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/8/11.
 */

public class AudioCodec {
    @SerializedName("Codec") String codec;
    @SerializedName("Sample") Integer sample;
    @SerializedName("Channels") Integer channels;
    @SerializedName("BitWidth") Integer bitwidth;

    @Override
    public String toString() {
        return "AudioCodec{" +
                "codec='" + codec + '\'' +
                ", sample=" + sample +
                ", channels=" + channels +
                ", bitwidth=" + bitwidth +
                '}';
    }

    public String getCodec() {
        return codec;
    }

    public void setCodec(String codec) {
        this.codec = codec;
    }

    public Integer getSample() {
        return sample;
    }

    public void setSample(Integer sample) {
        this.sample = sample;
    }

    public Integer getChannels() {
        return channels;
    }

    public void setChannels(Integer channels) {
        this.channels = channels;
    }

    public Integer getBitwidth() {
        return bitwidth;
    }

    public void setBitwidth(Integer bitwidth) {
        this.bitwidth = bitwidth;
    }

    public AudioCodec() {

    }

    public AudioCodec(String codec, Integer sample, Integer channels, Integer bitwidth) {

        this.codec = codec;
        this.sample = sample;
        this.channels = channels;
        this.bitwidth = bitwidth;
    }
}
