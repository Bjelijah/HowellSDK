package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/8/10.
 */

public class TeardownCredential {
    @SerializedName("UserName")        String userName;
    @SerializedName("SessionId")       String sessionId;
    @SerializedName("TeardownReason")  String teardownReason;

    @Override
    public String toString() {
        return "TeardownCredential{" +
                "userName='" + userName + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", teardownReason='" + teardownReason + '\'' +
                '}';
    }

    public TeardownCredential() {
    }

    public TeardownCredential(String userName, String sessionId, String teardownReason) {

        this.userName = userName;
        this.sessionId = sessionId;
        this.teardownReason = teardownReason;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getTeardownReason() {
        return teardownReason;
    }

    public void setTeardownReason(String teardownReason) {
        this.teardownReason = teardownReason;
    }
}
