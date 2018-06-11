package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/8/9.
 */

public class Fault {
    @SerializedName("FaultCode")   String faultCode;
    @SerializedName("FaultReason") String faultReason;
    @SerializedName("Exception")   String exception;
    @SerializedName("Id")          String id;

    public Fault() {
    }

    @Override
    public String toString() {
        return "Fault{" +
                "faultCode='" + faultCode + '\'' +
                ", faultReason='" + faultReason + '\'' +
                ", exception='" + exception + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public Fault(String faultCode, String faultReason, String exception, String id) {
        this.faultCode = faultCode;
        this.faultReason = faultReason;
        this.exception = exception;
        this.id = id;
    }

    public String getFaultCode() {

        return faultCode;
    }

    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode;
    }

    public String getFaultReason() {
        return faultReason;
    }

    public void setFaultReason(String faultReason) {
        this.faultReason = faultReason;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
