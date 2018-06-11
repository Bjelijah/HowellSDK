package com.howellsdk.net.http.bean;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/11.
 */

public class EventLinkage {
    @SerializedName("ComponentId") String componentId;
    @SerializedName("EventType") String eventType;
    @SerializedName("EventState") String eventState;
    @SerializedName("VideoPreviewIdentifier") ArrayList<VideoPreviewIdentifier> videoPreviewIdentifiers;
    @SerializedName("VideoPlaybackIdentifier") ArrayList<VideoPlaybackIdentifier> videoPlaybackIdentifiers;
    @SerializedName("TextIdentifier") TextIdentifier textIdentifier;
    @SerializedName("AudioPlayerIdentifier") AudioPlayerIdentifier audioPlayerIdentifier;
    @SerializedName("VideoSnapIdentifier") ArrayList<VideoSnapIdentifier> videoSnapIdentifiers;
    @SerializedName("Executor") ArrayList<String> executors;
    @SerializedName("DecoderIdentifier") ArrayList<DecoderIdentifier> decoderIdentifiers;

    @Override
    public String toString() {
        return "EventLinkage{" +
                "componentId='" + componentId + '\'' +
                ", eventType='" + eventType + '\'' +
                ", eventState='" + eventState + '\'' +
                ", videoPreviewIdentifiers=" + videoPreviewIdentifiers +
                ", videoPlaybackIdentifiers=" + videoPlaybackIdentifiers +
                ", textIdentifier=" + textIdentifier +
                ", audioPlayerIdentifier=" + audioPlayerIdentifier +
                ", videoSnapIdentifiers=" + videoSnapIdentifiers +
                ", executors=" + executors +
                ", decoderIdentifiers=" + decoderIdentifiers +
                '}';
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventState() {
        return eventState;
    }

    public void setEventState(String eventState) {
        this.eventState = eventState;
    }

    public @Nullable ArrayList<VideoPreviewIdentifier> getVideoPreviewIdentifiers() {
        return videoPreviewIdentifiers;
    }

    public void setVideoPreviewIdentifiers(ArrayList<VideoPreviewIdentifier> videoPreviewIdentifiers) {
        this.videoPreviewIdentifiers = videoPreviewIdentifiers;
    }

    public @Nullable ArrayList<VideoPlaybackIdentifier> getVideoPlaybackIdentifiers() {
        return videoPlaybackIdentifiers;
    }

    public void setVideoPlaybackIdentifiers(ArrayList<VideoPlaybackIdentifier> videoPlaybackIdentifiers) {
        this.videoPlaybackIdentifiers = videoPlaybackIdentifiers;
    }

    public @Nullable TextIdentifier getTextIdentifier() {
        return textIdentifier;
    }

    public void setTextIdentifier(TextIdentifier textIdentifier) {
        this.textIdentifier = textIdentifier;
    }

    public @Nullable AudioPlayerIdentifier getAudioPlayerIdentifier() {
        return audioPlayerIdentifier;
    }

    public void setAudioPlayerIdentifier(AudioPlayerIdentifier audioPlayerIdentifier) {
        this.audioPlayerIdentifier = audioPlayerIdentifier;
    }

    public @Nullable ArrayList<VideoSnapIdentifier> getVideoSnapIdentifiers() {
        return videoSnapIdentifiers;
    }

    public void setVideoSnapIdentifiers(ArrayList<VideoSnapIdentifier> videoSnapIdentifiers) {
        this.videoSnapIdentifiers = videoSnapIdentifiers;
    }

    public @Nullable ArrayList<String> getExecutors() {
        return executors;
    }

    public void setExecutors(ArrayList<String> executors) {
        this.executors = executors;
    }

    public @Nullable ArrayList<DecoderIdentifier> getDecoderIdentifiers() {
        return decoderIdentifiers;
    }

    public void setDecoderIdentifiers(ArrayList<DecoderIdentifier> decoderIdentifiers) {
        this.decoderIdentifiers = decoderIdentifiers;
    }

    public EventLinkage() {

    }

    public EventLinkage(String componentId, String eventType, String eventState, ArrayList<VideoPreviewIdentifier> videoPreviewIdentifiers, ArrayList<VideoPlaybackIdentifier> videoPlaybackIdentifiers, TextIdentifier textIdentifier, AudioPlayerIdentifier audioPlayerIdentifier, ArrayList<VideoSnapIdentifier> videoSnapIdentifiers, ArrayList<String> executors, ArrayList<DecoderIdentifier> decoderIdentifiers) {

        this.componentId = componentId;
        this.eventType = eventType;
        this.eventState = eventState;
        this.videoPreviewIdentifiers = videoPreviewIdentifiers;
        this.videoPlaybackIdentifiers = videoPlaybackIdentifiers;
        this.textIdentifier = textIdentifier;
        this.audioPlayerIdentifier = audioPlayerIdentifier;
        this.videoSnapIdentifiers = videoSnapIdentifiers;
        this.executors = executors;
        this.decoderIdentifiers = decoderIdentifiers;
    }
}
