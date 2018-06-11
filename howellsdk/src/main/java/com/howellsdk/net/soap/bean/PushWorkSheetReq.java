package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/19.
 */

public class PushWorkSheetReq {
    String account;
    String session;
    String devID;
    int channelNo;
    WorkSheet workSheet;

    @Override
    public String toString() {
        return "PushWorkSheetReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devID='" + devID + '\'' +
                ", channelNo=" + channelNo +
                ", workSheet=" + workSheet +
                '}';
    }

    public PushWorkSheetReq() {
    }

    public PushWorkSheetReq(String account, String session, String devID, int channelNo, WorkSheet workSheet) {

        this.account = account;
        this.session = session;
        this.devID = devID;
        this.channelNo = channelNo;
        this.workSheet = workSheet;
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

    public int getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(int channelNo) {
        this.channelNo = channelNo;
    }

    public WorkSheet getWorkSheet() {
        return workSheet;
    }

    public void setWorkSheet(WorkSheet workSheet) {
        this.workSheet = workSheet;
    }

    public static class WorkSheet{
        String bitString;

        @Override
        public String toString() {
            return "WorkSheet{" +
                    "bitString='" + bitString + '\'' +
                    '}';
        }

        public WorkSheet() {
        }

        public WorkSheet(String bitString) {

            this.bitString = bitString;
        }

        public String getBitString() {

            return bitString;
        }

        public void setBitString(String bitString) {
            this.bitString = bitString;
        }
    }
}
