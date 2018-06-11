package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/11.
 */

public class VideoSnapIdentifier {
    @SerializedName("VideoInputChannelId") String videoInputChannelId;
    @SerializedName("StreamNo") int streamNo;
    @SerializedName("PictureFormat") String pictureFormat;

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

    public String getPictureFormat() {
        return pictureFormat;
    }

    public void setPictureFormat(String pictureFormat) {
        this.pictureFormat = pictureFormat;
    }

    public VideoSnapIdentifier(String videoInputChannelId, int streamNo, String pictureFormat) {
        this.videoInputChannelId = videoInputChannelId;
        this.streamNo = streamNo;
        this.pictureFormat = pictureFormat;
    }

    public VideoSnapIdentifier() {
    }

    @Override
    public String toString() {
        return "VideoSnapIdentifier{" +
                "videoInputChannelId='" + videoInputChannelId + '\'' +
                ", streamNo=" + streamNo +
                ", pictureFormat='" + pictureFormat + '\'' +
                '}';
    }
}
