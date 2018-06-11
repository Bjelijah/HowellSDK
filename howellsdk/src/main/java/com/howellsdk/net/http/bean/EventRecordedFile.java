package com.howellsdk.net.http.bean;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/12.
 */

public class EventRecordedFile {
    @SerializedName("RecordedFileId") String recordedFileId;
    @SerializedName("RecordedFileTimestamp") Long recordedFileTimestamp;

    @Override
    public String toString() {
        return "EventRecordedFile{" +
                "recordedFileId='" + recordedFileId + '\'' +
                ", recordedFileTimestamp=" + recordedFileTimestamp +
                '}';
    }

    public String getRecordedFileId() {
        return recordedFileId;
    }

    public void setRecordedFileId(String recordedFileId) {
        this.recordedFileId = recordedFileId;
    }

    public @Nullable Long getRecordedFileTimestamp() {
        return recordedFileTimestamp;
    }

    public void setRecordedFileTimestamp(Long recordedFileTimestamp) {
        this.recordedFileTimestamp = recordedFileTimestamp;
    }

    public EventRecordedFile() {

    }

    public EventRecordedFile(String recordedFileId, Long recordedFileTimestamp) {

        this.recordedFileId = recordedFileId;
        this.recordedFileTimestamp = recordedFileTimestamp;
    }
}
