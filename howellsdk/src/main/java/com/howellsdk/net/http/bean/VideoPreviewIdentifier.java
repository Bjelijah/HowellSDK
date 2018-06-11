package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/11.
 */

public class VideoPreviewIdentifier {
    @SerializedName("VideoInputChannelId") String videoInputChannelId;
    @SerializedName("StreamNo") int streamNo;
    @SerializedName("Protocol") String protocol;

    public String getVideoInputChannelId() {
        return videoInputChannelId;
    }

    public void setVideoInputChannelId(String videoInputChannelId) {
        this.videoInputChannelId = videoInputChannelId;
    }

    public int getStreamNo() {
        return streamNo;
    }

    public void setStreamNo(int streamNo) {
        this.streamNo = streamNo;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public VideoPreviewIdentifier(String videoInputChannelId, int streamNo, String protocol) {
        this.videoInputChannelId = videoInputChannelId;
        this.streamNo = streamNo;
        this.protocol = protocol;
    }

    public VideoPreviewIdentifier() {
    }

    @Override
    public String toString() {
        return "VideoPreviewIdentifier{" +
                "videoInputChannelId='" + videoInputChannelId + '\'' +
                ", streamNo=" + streamNo +
                ", protocol='" + protocol + '\'' +
                '}';
    }
}
