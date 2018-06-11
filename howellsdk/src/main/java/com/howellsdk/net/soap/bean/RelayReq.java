package com.howellsdk.net.soap.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/19.
 */

public class RelayReq {
    String account;
    String session;
    String devID;
    ArrayList<Relay> relays;

    @Override
    public String toString() {
        return "RelayReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devID='" + devID + '\'' +
                ", relays=" + relays +
                '}';
    }

    public RelayReq() {
    }

    public RelayReq(String account, String session, String devID, ArrayList<Relay> relays) {

        this.account = account;
        this.session = session;
        this.devID = devID;
        this.relays = relays;
    }

    public String getAccount() {

        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getDevID() {
        return devID;
    }

    public void setDevID(String devID) {
        this.devID = devID;
    }

    public ArrayList<Relay> getRelays() {
        return relays;
    }

    public void setRelays(ArrayList<Relay> relays) {
        this.relays = relays;
    }

    public static class Relay{
        int No;
        String name;
        String state;

        @Override
        public String toString() {
            return "Relay{" +
                    "No=" + No +
                    ", name='" + name + '\'' +
                    ", state='" + state + '\'' +
                    '}';
        }

        public Relay() {
        }

        public Relay(int no, String name, String state) {

            No = no;
            this.name = name;
            this.state = state;
        }

        public int getNo() {

            return No;
        }

        public void setNo(int no) {
            No = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }
}
