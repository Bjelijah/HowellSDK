package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/12.
 */

public class EventRecordedList {
    @SerializedName("Page") Page page;
    @SerializedName("EventRecord") ArrayList<EventRecord> records;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public ArrayList<EventRecord> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<EventRecord> records) {
        this.records = records;
    }

    public EventRecordedList(Page page, ArrayList<EventRecord> records) {
        this.page = page;
        this.records = records;
    }

    public EventRecordedList() {
    }

    @Override
    public String toString() {
        return "EventRecordedList{" +
                "page=" + page +
                ", records=" + records +
                '}';
    }
}
