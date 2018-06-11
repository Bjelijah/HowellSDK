package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/19.
 */

public class RecordParamReq {
    String account;
    String session;
    String devID;
    int channelNo;
    Boolean enabled;
    WorkSheet workSheet;

    @Override
    public String toString() {
        return "RecordParamReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devID='" + devID + '\'' +
                ", channelNo=" + channelNo +
                ", enabled=" + enabled +
                ", workSheet=" + workSheet +
                '}';
    }

    public RecordParamReq() {
    }

    public RecordParamReq(String account, String session, String devID, int channelNo, Boolean enabled, WorkSheet workSheet) {

        this.account = account;
        this.session = session;
        this.devID = devID;
        this.channelNo = channelNo;
        this.enabled = enabled;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public WorkSheet getWorkSheet() {
        return workSheet;
    }

    public void setWorkSheet(WorkSheet workSheet) {
        this.workSheet = workSheet;
    }

    public static class WorkSheet{
        Boolean enabled;
        String bitString;

        @Override
        public String toString() {
            return "WorkSheet{" +
                    "enabled=" + enabled +
                    ", bitString='" + bitString + '\'' +
                    '}';
        }

        public WorkSheet() {
        }

        public WorkSheet(Boolean enabled, String bitString) {

            this.enabled = enabled;
            this.bitString = bitString;
        }

        public Boolean getEnabled() {

            return enabled;
        }

        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }

        public String getBitString() {
            return bitString;
        }

        public void setBitString(String bitString) {
            this.bitString = bitString;
        }
    }
}
