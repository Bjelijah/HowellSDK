package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/19.
 */

public class ClientVersionReq {
    String clientType;
    String ApplicationID;

    @Override
    public String toString() {
        return "ClientVersionReq{" +
                "clientType='" + clientType + '\'' +
                ", ApplicationID='" + ApplicationID + '\'' +
                '}';
    }

    public ClientVersionReq() {
        this.clientType = "Android";
    }

    public ClientVersionReq(String clientType, String applicationID) {

        this.clientType = clientType;
        ApplicationID = applicationID;
    }

    public String getClientType() {

        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getApplicationID() {
        return ApplicationID;
    }

    public void setApplicationID(String applicationID) {
        ApplicationID = applicationID;
    }
}
