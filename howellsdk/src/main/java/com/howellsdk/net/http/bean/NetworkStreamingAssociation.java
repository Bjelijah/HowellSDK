package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/10.
 */

public class NetworkStreamingAssociation {
    @SerializedName("No") Integer No;
    @SerializedName("Url") String url;
    @SerializedName("Username") String userName;
    @SerializedName("Password") String password;
    @SerializedName("TCPTransport") Boolean TCPTransport;

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isTCPTransport() {
        return TCPTransport;
    }

    public void setTCPTransport(boolean TCPTransport) {
        this.TCPTransport = TCPTransport;
    }

    public NetworkStreamingAssociation(int no, String url, String userName, String password, boolean TCPTransport) {
        No = no;
        this.url = url;
        this.userName = userName;
        this.password = password;
        this.TCPTransport = TCPTransport;
    }

    public NetworkStreamingAssociation() {
    }

    @Override
    public String toString() {
        return "NetworkStreamingAssociation{" +
                "No=" + No +
                ", url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", TCPTransport=" + TCPTransport +
                '}';
    }
}
