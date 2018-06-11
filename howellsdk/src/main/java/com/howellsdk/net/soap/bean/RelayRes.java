package com.howellsdk.net.soap.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/19.
 */

public class RelayRes {
    String result;
    ArrayList<Relay> relays;

    @Override
    public String toString() {
        return "RelayRes{" +
                "result='" + result + '\'' +
                ", relays=" + relays +
                '}';
    }

    public RelayRes() {
    }

    public RelayRes(String result, ArrayList<Relay> relays) {

        this.result = result;
        this.relays = relays;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
