package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/11/23.
 */

public class PDCFlavourLayoutItem {
    @SerializedName("Id")               String id;
    @SerializedName("Row")              Integer row;
    @SerializedName("Column")           Integer column;
    @SerializedName("RowSpan")          Integer rowSpan;
    @SerializedName("ColumnSpan")       Integer columnSpan;
    @SerializedName("Classification")   Integer classification;
    @SerializedName("Size")             Integer size;

    @Override
    public String toString() {
        return "PDCFlavourLayoutItem{" +
                "id='" + id + '\'' +
                ", row=" + row +
                ", column=" + column +
                ", rowSpan=" + rowSpan +
                ", columnSpan=" + columnSpan +
                ", classification=" + classification +
                ", size=" + size +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public Integer getRowSpan() {
        return rowSpan;
    }

    public void setRowSpan(Integer rowSpan) {
        this.rowSpan = rowSpan;
    }

    public Integer getColumnSpan() {
        return columnSpan;
    }

    public void setColumnSpan(Integer columnSpan) {
        this.columnSpan = columnSpan;
    }

    public Integer getClassification() {
        return classification;
    }

    public void setClassification(Integer classification) {
        this.classification = classification;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public PDCFlavourLayoutItem() {

    }

    public PDCFlavourLayoutItem(String id, Integer row, Integer column, Integer rowSpan, Integer columnSpan, Integer classification, Integer size) {

        this.id = id;
        this.row = row;
        this.column = column;
        this.rowSpan = rowSpan;
        this.columnSpan = columnSpan;
        this.classification = classification;
        this.size = size;
    }
}
