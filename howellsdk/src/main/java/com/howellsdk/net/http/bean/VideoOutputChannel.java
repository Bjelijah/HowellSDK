package com.howellsdk.net.http.bean;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/10.
 */

public class VideoOutputChannel {
    @SerializedName("Id") String id;
    @SerializedName("Name") String name;
    @SerializedName("Terminal") Boolean terminal;
    @SerializedName("Networked") Boolean networked;
    @SerializedName("InterfaceEquipped") Boolean interfaceEquipped;
    @SerializedName("Resolution") Resolution resolution;
    @SerializedName("Frequency") Integer frequency;
    @SerializedName("VideoInterfaceType") String videoInterfaceType;
    @SerializedName("PseudoCode") Integer pseudoCode;
    @SerializedName("DecodingChannel") ArrayList<DecodingChannel> decodingChannels;

    @Override
    public String toString() {
        return "VideoOutputChannel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", terminal=" + terminal +
                ", networked=" + networked +
                ", interfaceEquipped=" + interfaceEquipped +
                ", resolution=" + resolution +
                ", frequency=" + frequency +
                ", videoInterfaceType='" + videoInterfaceType + '\'' +
                ", pseudoCode=" + pseudoCode +
                ", decodingChannels=" + decodingChannels +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public @Nullable Boolean getTerminal() {
        return terminal;
    }

    public void setTerminal(Boolean terminal) {
        this.terminal = terminal;
    }

    public @Nullable Boolean getNetworked() {
        return networked;
    }

    public void setNetworked(Boolean networked) {
        this.networked = networked;
    }

    public @Nullable Boolean getInterfaceEquipped() {
        return interfaceEquipped;
    }

    public void setInterfaceEquipped(Boolean interfaceEquipped) {
        this.interfaceEquipped = interfaceEquipped;
    }

    public @Nullable Resolution getResolution() {
        return resolution;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    public @Nullable Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public @Nullable String getVideoInterfaceType() {
        return videoInterfaceType;
    }

    public void setVideoInterfaceType(String videoInterfaceType) {
        this.videoInterfaceType = videoInterfaceType;
    }

    public Integer getPseudoCode() {
        return pseudoCode;
    }

    public void setPseudoCode(Integer pseudoCode) {
        this.pseudoCode = pseudoCode;
    }

    public @Nullable ArrayList<DecodingChannel> getDecodingChannels() {
        return decodingChannels;
    }

    public void setDecodingChannels(ArrayList<DecodingChannel> decodingChannels) {
        this.decodingChannels = decodingChannels;
    }

    public VideoOutputChannel() {

    }

    public VideoOutputChannel(String id, String name, Boolean terminal, Boolean networked, Boolean interfaceEquipped, Resolution resolution, Integer frequency, String videoInterfaceType, Integer pseudoCode, ArrayList<DecodingChannel> decodingChannels) {

        this.id = id;
        this.name = name;
        this.terminal = terminal;
        this.networked = networked;
        this.interfaceEquipped = interfaceEquipped;
        this.resolution = resolution;
        this.frequency = frequency;
        this.videoInterfaceType = videoInterfaceType;
        this.pseudoCode = pseudoCode;
        this.decodingChannels = decodingChannels;
    }
}
