package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/23.
 */

public class PDCFlavourLayout {
    @SerializedName("RowCount")         Integer rowCount;
    @SerializedName("ColumnCount")      Integer columnCount;
    @SerializedName("Item")             ArrayList<PDCFlavourLayoutItem> pdcFlavourLayoutItems;

    @Override
    public String toString() {
        return "PDCFlavourLayout{" +
                "rowCount=" + rowCount +
                ", columnCount=" + columnCount +
                ", pdcFlavourLayoutItems=" + pdcFlavourLayoutItems +
                '}';
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(Integer columnCount) {
        this.columnCount = columnCount;
    }

    public ArrayList<PDCFlavourLayoutItem> getPdcFlavourLayoutItems() {
        return pdcFlavourLayoutItems;
    }

    public void setPdcFlavourLayoutItems(ArrayList<PDCFlavourLayoutItem> pdcFlavourLayoutItems) {
        this.pdcFlavourLayoutItems = pdcFlavourLayoutItems;
    }

    public PDCFlavourLayout() {

    }

    public PDCFlavourLayout(Integer rowCount, Integer columnCount, ArrayList<PDCFlavourLayoutItem> pdcFlavourLayoutItems) {

        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.pdcFlavourLayoutItems = pdcFlavourLayoutItems;
    }
}
