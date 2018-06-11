package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/11.
 */

public class IOInputChannelList {
    @SerializedName("Page") Page page;
    @SerializedName("IOInputChannel") ArrayList<IOInputChannel> inputChannels;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public ArrayList<IOInputChannel> getInputChannels() {
        return inputChannels;
    }

    public void setInputChannels(ArrayList<IOInputChannel> inputChannels) {
        this.inputChannels = inputChannels;
    }

    public IOInputChannelList(Page page, ArrayList<IOInputChannel> inputChannels) {
        this.page = page;
        this.inputChannels = inputChannels;
    }

    public IOInputChannelList() {
    }

    @Override
    public String toString() {
        return "IOInputChannelList{" +
                "page=" + page +
                ", inputChannels=" + inputChannels +
                '}';
    }
}
