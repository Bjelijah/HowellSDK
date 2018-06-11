package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/8/9.
 */

public class UserNonce {
    @SerializedName("Nonce")  String nonce;
    @SerializedName("Domain") String domain;
    @SerializedName("UserId") String userID;

    @Override
    public String toString() {
        return "UserNonce{" +
                "nonce='" + nonce + '\'' +
                ", domain='" + domain + '\'' +
                ", userID='" + userID + '\'' +
                '}';
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
