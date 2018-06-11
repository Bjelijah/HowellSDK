package com.howellsdk.net.soap.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/16.
 */

public class GetNATRes {
    String result;
    ArrayList<STUNServer> stunServers;
    ArrayList<TURNServer> turnServers;

    @Override
    public String toString() {
        return "GetNATRes{" +
                "result='" + result + '\'' +
                ", stunServers=" + stunServers +
                ", turnServers=" + turnServers +
                '}';
    }

    public GetNATRes() {
    }

    public GetNATRes(String result, ArrayList<STUNServer> stunServers, ArrayList<TURNServer> turnServers) {

        this.result = result;
        this.stunServers = stunServers;
        this.turnServers = turnServers;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ArrayList<STUNServer> getStunServers() {
        return stunServers;
    }

    public void setStunServers(ArrayList<STUNServer> stunServers) {
        this.stunServers = stunServers;
    }

    public ArrayList<TURNServer> getTurnServers() {
        return turnServers;
    }

    public void setTurnServers(ArrayList<TURNServer> turnServers) {
        this.turnServers = turnServers;
    }

    public static class STUNServer{
        String IPv4Address;
        String IPv6Address;
        int port;

        @Override
        public String toString() {
            return "STUNServer{" +
                    "IPv4Address='" + IPv4Address + '\'' +
                    ", IPv6Address='" + IPv6Address + '\'' +
                    ", port=" + port +
                    '}';
        }

        public STUNServer() {
        }

        public STUNServer(String IPv4Address, String IPv6Address, int port) {

            this.IPv4Address = IPv4Address;
            this.IPv6Address = IPv6Address;
            this.port = port;
        }

        public String getIPv4Address() {

            return IPv4Address;
        }

        public void setIPv4Address(String IPv4Address) {
            this.IPv4Address = IPv4Address;
        }

        public String getIPv6Address() {
            return IPv6Address;
        }

        public void setIPv6Address(String IPv6Address) {
            this.IPv6Address = IPv6Address;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }
    }

    public static class TURNServer{
        String IPv4Address;
        String IPv6Address;
        int port;
        String username;
        String password;

        @Override
        public String toString() {
            return "TURNServer{" +
                    "IPv4Address='" + IPv4Address + '\'' +
                    ", IPv6Address='" + IPv6Address + '\'' +
                    ", port=" + port +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }

        public TURNServer() {
        }

        public TURNServer(String IPv4Address, String IPv6Address, int port, String username, String password) {

            this.IPv4Address = IPv4Address;
            this.IPv6Address = IPv6Address;
            this.port = port;
            this.username = username;
            this.password = password;
        }

        public String getIPv4Address() {

            return IPv4Address;
        }

        public void setIPv4Address(String IPv4Address) {
            this.IPv4Address = IPv4Address;
        }

        public String getIPv6Address() {
            return IPv6Address;
        }

        public void setIPv6Address(String IPv6Address) {
            this.IPv6Address = IPv6Address;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
