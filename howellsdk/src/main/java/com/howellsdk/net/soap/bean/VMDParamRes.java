package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/15.
 */

public class VMDParamRes {
    String result;
    Boolean enable;
    int sensitivity;
    int startTriggerTime;
    int endTriggerTime;
    int rowGranularity;
    int columnGranularity;
    VMDGrid vmdGrid;
    WorkSheet workSheet;

    @Override
    public String toString() {
        return "VMDParamRes{" +
                "result='" + result + '\'' +
                ", enable=" + enable +
                ", sensitivity=" + sensitivity +
                ", startTriggerTime=" + startTriggerTime +
                ", endTriggerTime=" + endTriggerTime +
                ", rowGranularity=" + rowGranularity +
                ", columnGranularity=" + columnGranularity +
                ", vmdGrid=" + vmdGrid +
                ", workSheet=" + workSheet +
                '}';
    }

    public VMDParamRes() {
    }

    public VMDParamRes(String result, Boolean enable, int sensitivity, int startTriggerTime, int endTriggerTime, int rowGranularity, int columnGranularity, VMDGrid vmdGrid, WorkSheet workSheet) {

        this.result = result;
        this.enable = enable;
        this.sensitivity = sensitivity;
        this.startTriggerTime = startTriggerTime;
        this.endTriggerTime = endTriggerTime;
        this.rowGranularity = rowGranularity;
        this.columnGranularity = columnGranularity;
        this.vmdGrid = vmdGrid;
        this.workSheet = workSheet;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public int getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(int sensitivity) {
        this.sensitivity = sensitivity;
    }

    public int getStartTriggerTime() {
        return startTriggerTime;
    }

    public void setStartTriggerTime(int startTriggerTime) {
        this.startTriggerTime = startTriggerTime;
    }

    public int getEndTriggerTime() {
        return endTriggerTime;
    }

    public void setEndTriggerTime(int endTriggerTime) {
        this.endTriggerTime = endTriggerTime;
    }

    public int getRowGranularity() {
        return rowGranularity;
    }

    public void setRowGranularity(int rowGranularity) {
        this.rowGranularity = rowGranularity;
    }

    public int getColumnGranularity() {
        return columnGranularity;
    }

    public void setColumnGranularity(int columnGranularity) {
        this.columnGranularity = columnGranularity;
    }

    public VMDGrid getVmdGrid() {
        return vmdGrid;
    }

    public void setVmdGrid(VMDGrid vmdGrid) {
        this.vmdGrid = vmdGrid;
    }

    public WorkSheet getWorkSheet() {
        return workSheet;
    }

    public void setWorkSheet(WorkSheet workSheet) {
        this.workSheet = workSheet;
    }

    public static class VMDGrid{
        String row;

        @Override
        public String toString() {
            return "VMDGrid{" +
                    "row='" + row + '\'' +
                    '}';
        }

        public String getRow() {
            return row;
        }

        public void setRow(String row) {
            this.row = row;
        }

        public VMDGrid() {

        }

        public VMDGrid(String row) {

            this.row = row;
        }
    }

    public static class WorkSheet{
        Boolean enable;
        String bitString;

        @Override
        public String toString() {
            return "WorkSheet{" +
                    "enable=" + enable +
                    ", bitString='" + bitString + '\'' +
                    '}';
        }

        public WorkSheet() {
        }

        public WorkSheet(Boolean enable, String bitString) {

            this.enable = enable;
            this.bitString = bitString;
        }

        public Boolean getEnable() {

            return enable;
        }

        public void setEnable(Boolean enable) {
            this.enable = enable;
        }

        public String getBitString() {
            return bitString;
        }

        public void setBitString(String bitString) {
            this.bitString = bitString;
        }
    }
}
