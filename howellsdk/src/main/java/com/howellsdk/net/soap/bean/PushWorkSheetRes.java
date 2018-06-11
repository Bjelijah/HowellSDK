package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/19.
 */

public class PushWorkSheetRes {
    String result;
    WorkSheet workSheet;

    @Override
    public String toString() {
        return "PushWorkSheetRes{" +
                "result='" + result + '\'' +
                ", workSheet=" + workSheet.toString() +
                '}';
    }

    public PushWorkSheetRes() {
    }

    public PushWorkSheetRes(String result, WorkSheet workSheet) {

        this.result = result;
        this.workSheet = workSheet;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
