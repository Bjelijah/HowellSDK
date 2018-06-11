package com.howellsdk.net.soap.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/15.
 */

public class VodSearchRes {
    String result;
    int pageNo;
    int pageCount;
    int recordCount;
    ArrayList<Record> records;

    @Override
    public String toString() {
        return "VodSearchRes{" +
                "result='" + result + '\'' +
                ", pageNo=" + pageNo +
                ", pageCount=" + pageCount +
                ", recordCount=" + recordCount +
                ", record=" + records +
                '}';
    }

    public VodSearchRes() {
    }

    public VodSearchRes(String result, int pageNo, int pageCount, int recordCount, ArrayList<Record> records) {

        this.result = result;
        this.pageNo = pageNo;
        this.pageCount = pageCount;
        this.recordCount = recordCount;
        this.records = records;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public ArrayList<Record> getRecord() {
        return records;
    }

    public void setRecord(ArrayList<Record> record) {
        this.records = record;
    }

    public static class Record{
        String startTime;
        String endTime;
        long fileSize;
        String contentType;
        String desc;

        @Override
        public String toString() {
            return "Record{" +
                    "startTime='" + startTime + '\'' +
                    ", endTime='" + endTime + '\'' +
                    ", fileSize=" + fileSize +
                    ", contentType='" + contentType + '\'' +
                    ", desc='" + desc + '\'' +
                    '}';
        }

        public Record() {
        }

        public Record(String startTime, String endTime, long fileSize, String contentType, String desc) {

            this.startTime = startTime;
            this.endTime = endTime;
            this.fileSize = fileSize;
            this.contentType = contentType;
            this.desc = desc;
        }

        public String getStartTime() {

            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public long getFileSize() {
            return fileSize;
        }

        public void setFileSize(long fileSize) {
            this.fileSize = fileSize;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
