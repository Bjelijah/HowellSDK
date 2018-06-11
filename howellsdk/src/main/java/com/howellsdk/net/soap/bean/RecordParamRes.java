package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/19.
 */

public class RecordParamRes {
    String result;
    Boolean enabled;
    WorkSheet workSheet;

    @Override
    public String toString() {
        return "RecordParamRes{" +
                "result='" + result + '\'' +
                ", enabled=" + enabled +
                ", workSheet=" + workSheet +
                '}';
    }

    public RecordParamRes() {
    }

    public RecordParamRes(String result, Boolean enabled, WorkSheet workSheet) {

        this.result = result;
        this.enabled = enabled;
        this.workSheet = workSheet;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
            return "workSheet{" +
                    "enabled=" + enabled +
                    ", bitString='" + bitString + '\'' +
                    '}';
        }

        public  WorkSheet() {
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
