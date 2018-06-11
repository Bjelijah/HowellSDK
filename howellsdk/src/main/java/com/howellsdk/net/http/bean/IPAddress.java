package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/8/10.
 */

public class IPAddress {
    @SerializedName("Ipv4Address")   Ipv4Address ipv4Address;
    @SerializedName("Ipv6Address")   Ipv6Address ipv6Address;

    @Override
    public String toString() {
        return "IPAddress{" +
                "ipv4Address=" + ipv4Address +
                ", ipv6Address=" + ipv6Address +
                '}';
    }

    public IPAddress() {
    }

    public IPAddress(Ipv4Address ipv4Address, Ipv6Address ipv6Address) {

        this.ipv4Address = ipv4Address;
        this.ipv6Address = ipv6Address;
    }

    public Ipv4Address getIpv4Address() {

        return ipv4Address;
    }

    public void setIpv4Address(Ipv4Address ipv4Address) {
        this.ipv4Address = ipv4Address;
    }

    public Ipv6Address getIpv6Address() {
        return ipv6Address;
    }

    public void setIpv6Address(Ipv6Address ipv6Address) {
        this.ipv6Address = ipv6Address;
    }
}
