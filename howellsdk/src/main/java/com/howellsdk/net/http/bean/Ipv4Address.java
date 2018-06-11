package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/8/10.
 */

public class Ipv4Address {
    @SerializedName("Address")          String address;
    @SerializedName("Subnetmask")       String subnetmask;
    @SerializedName("DefaultGateway")   String defaultGateway;
    @SerializedName("PrimaryDNS")       String primaryDNS;
    @SerializedName("SecondaryDNS")     String secondaryDNS;

    @Override
    public String toString() {
        return "Ipv4Address{" +
                "address='" + address + '\'' +
                ", subnetmask='" + subnetmask + '\'' +
                ", defaultGateway='" + defaultGateway + '\'' +
                ", primaryDNS='" + primaryDNS + '\'' +
                ", secondaryDNS='" + secondaryDNS + '\'' +
                '}';
    }

    public Ipv4Address() {
    }

    public Ipv4Address(String address, String subnetmask, String defaultGateway, String primaryDNS, String secondaryDNS) {

        this.address = address;
        this.subnetmask = subnetmask;
        this.defaultGateway = defaultGateway;
        this.primaryDNS = primaryDNS;
        this.secondaryDNS = secondaryDNS;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubnetmask() {
        return subnetmask;
    }

    public void setSubnetmask(String subnetmask) {
        this.subnetmask = subnetmask;
    }

    public String getDefaultGateway() {
        return defaultGateway;
    }

    public void setDefaultGateway(String defaultGateway) {
        this.defaultGateway = defaultGateway;
    }

    public String getPrimaryDNS() {
        return primaryDNS;
    }

    public void setPrimaryDNS(String primaryDNS) {
        this.primaryDNS = primaryDNS;
    }

    public String getSecondaryDNS() {
        return secondaryDNS;
    }

    public void setSecondaryDNS(String secondaryDNS) {
        this.secondaryDNS = secondaryDNS;
    }
}
