package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/13.
 */

public class ProcessingResult {
    @SerializedName("Description") String description;

    public ProcessingResult(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProcessingResult() {
    }

    @Override
    public String toString() {
        return "ProcessingResult{" +
                "description='" + description + '\'' +
                '}';
    }
}
