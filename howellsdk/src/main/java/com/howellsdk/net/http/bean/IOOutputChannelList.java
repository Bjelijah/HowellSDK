package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/11.
 */

public class IOOutputChannelList {
    @SerializedName("Page") Page page;
    @SerializedName("IOOutputChannel") ArrayList<IOOutputChannel> channels;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public ArrayList<IOOutputChannel> getChannels() {
        return channels;
    }

    public void setChannels(ArrayList<IOOutputChannel> channels) {
        this.channels = channels;
    }

    public IOOutputChannelList(Page page, ArrayList<IOOutputChannel> channels) {
        this.page = page;
        this.channels = channels;
    }

    public IOOutputChannelList() {
    }

    @Override
    public String toString() {
        return "IOOutputChannelList{" +
                "page=" + page +
                ", channels=" + channels +
                '}';
    }
}
