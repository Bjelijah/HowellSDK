package com.howellsdk.net.http.bean;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/11.
 */

public class VideoPlaybackIdentifier {
    @SerializedName("VideoInputChannelId") String videoInputChannelId;
    @SerializedName("StreamNo") Integer streamNo;
    @SerializedName("Protocol") String protocol;
    @SerializedName("BeginTime") Integer beginTime;
    @SerializedName("EndTime") Integer endTime;

    @Override
    public String toString() {
        return "VideoPlaybackIdentifier{" +
                "videoInputChannelId='" + videoInputChannelId + '\'' +
                ", streamNo=" + streamNo +
                ", protocol='" + protocol + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                '}';
    }

    public String getVideoInputChannelId() {
        return videoInputChannelId;
    }

    public void setVideoInputChannelId(String videoInputChannelId) {
        this.videoInputChannelId = videoInputChannelId;
    }

    public Integer getStreamNo() {
        return streamNo;
    }

    public void setStreamNo(Integer streamNo) {
        this.streamNo = streamNo;
    }

    public @Nullable String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public @Nullable Integer getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Integer beginTime) {
        this.beginTime = beginTime;
    }

    public @Nullable Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public VideoPlaybackIdentifier() {

    }

    public VideoPlaybackIdentifier(String videoInputChannelId, Integer streamNo, String protocol, Integer beginTime, Integer endTime) {

        this.videoInputChannelId = videoInputChannelId;
        this.streamNo = streamNo;
        this.protocol = protocol;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }
}
