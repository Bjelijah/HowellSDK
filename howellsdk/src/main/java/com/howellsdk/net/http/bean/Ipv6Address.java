package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/8/10.
 */

public class Ipv6Address {
    @SerializedName("Address")          String address;
    @SerializedName("BitMask")          String bitMask;
    @SerializedName("DefaultGateway")   String defaultGateway;
    @SerializedName("PrimaryDNS")       String primaryDNS;
    @SerializedName("SecondaryDNS")     String secondaryDNS;

    @Override
    public String toString() {
        return "Ipv6Address{" +
                "address='" + address + '\'' +
                ", bitMask='" + bitMask + '\'' +
                ", defaultGateway='" + defaultGateway + '\'' +
                ", primaryDNS='" + primaryDNS + '\'' +
                ", secondaryDNS='" + secondaryDNS + '\'' +
                '}';
    }

    public Ipv6Address() {
    }

    public Ipv6Address(String address, String bitMask, String defaultGateway, String primaryDNS, String secondaryDNS) {

        this.address = address;
        this.bitMask = bitMask;
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

    public String getBitMask() {
        return bitMask;
    }

    public void setBitMask(String bitMask) {
        this.bitMask = bitMask;
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
