package com.howellsdk.net.soap.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/19.
 */

public class DeviceSharerRes {
    String result;
    ArrayList<Sharer> sharers;

    @Override
    public String toString() {
        return "DeviceSharerRes{" +
                "result='" + result + '\'' +
                ", sharers=" + sharers +
                '}';
    }

    public DeviceSharerRes() {
    }

    public DeviceSharerRes(String result, ArrayList<Sharer> sharers) {

        this.result = result;
        this.sharers = sharers;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ArrayList<Sharer> getSharers() {
        return sharers;
    }

    public void setSharers(ArrayList<Sharer> sharers) {
        this.sharers = sharers;
    }

    public static class Sharer{
        String sharerAccount;
        int sharingPriority;

        @Override
        public String toString() {
            return "Sharer{" +
                    "sharerAccount='" + sharerAccount + '\'' +
                    ", sharingPriority=" + sharingPriority +
                    '}';
        }

        public Sharer() {
        }

        public Sharer(String sharerAccount, int sharingPriority) {

            this.sharerAccount = sharerAccount;
            this.sharingPriority = sharingPriority;
        }

        public String getSharerAccount() {

            return sharerAccount;
        }

        public void setSharerAccount(String sharerAccount) {
            this.sharerAccount = sharerAccount;
        }

        public int getSharingPriority() {
            return sharingPriority;
        }

        public void setSharingPriority(int sharingPriority) {
            this.sharingPriority = sharingPriority;
        }
    }

}
