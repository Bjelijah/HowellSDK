package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/15.
 */

public class PrivacyMaskParamReq {
    String account;
    String session;
    String devID;
    int channelNo;
    Boolean enable;
    PrivacyMaskRegion privacyMaskRegion;

    @Override
    public String toString() {
        return "PrivacyMaskParamReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devID='" + devID + '\'' +
                ", channelNo=" + channelNo +
                ", enable=" + enable +
                ", privacyMaskRegion=" + privacyMaskRegion.toString() +
                '}';
    }

    public PrivacyMaskParamReq() {
    }

    public PrivacyMaskParamReq(String account, String session, String devID, int channelNo, Boolean enable, PrivacyMaskRegion privacyMaskRegion) {

        this.account = account;
        this.session = session;
        this.devID = devID;
        this.channelNo = channelNo;
        this.enable = enable;
        this.privacyMaskRegion = privacyMaskRegion;
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

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public PrivacyMaskRegion getPrivacyMaskRegion() {
        return privacyMaskRegion;
    }

    public void setPrivacyMaskRegion(PrivacyMaskRegion privacyMaskRegion) {
        this.privacyMaskRegion = privacyMaskRegion;
    }

    public static class PrivacyMaskRegion{
        int left;
        int top;
        int right;
        int bottom;

        @Override
        public String toString() {
            return "PrivacyMaskRegion{" +
                    "left=" + left +
                    ", top=" + top +
                    ", right=" + right +
                    ", bottom=" + bottom +
                    '}';
        }

        public PrivacyMaskRegion() {
        }

        public PrivacyMaskRegion(int left, int top, int right, int bottom) {

            this.left = left;
            this.top = top;
            this.right = right;
            this.bottom = bottom;
        }

        public int getLeft() {

            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }

        public int getBottom() {
            return bottom;
        }

        public void setBottom(int bottom) {
            this.bottom = bottom;
        }
    }


}
