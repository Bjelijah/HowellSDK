package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/12.
 */

public class IOOutputChannelStatusList {
    @SerializedName("Page") Page page;
    @SerializedName("IOOutputChannelStatus") ArrayList<IOOutputChannelStatus> statuses;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public ArrayList<IOOutputChannelStatus> getStatuses() {
        return statuses;
    }

    public void setStatuses(ArrayList<IOOutputChannelStatus> statuses) {
        this.statuses = statuses;
    }

    public IOOutputChannelStatusList(Page page, ArrayList<IOOutputChannelStatus> statuses) {
        this.page = page;
        this.statuses = statuses;
    }

    public IOOutputChannelStatusList() {
    }

    @Override
    public String toString() {
        return "IOOutputChannelStatusList{" +
                "page=" + page +
                ", statuses=" + statuses +
                '}';
    }
}
