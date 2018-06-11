package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/10.
 */

public class DepartmentList {
    @SerializedName("Page") Page page;
    @SerializedName("Department") ArrayList<Department> list;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public ArrayList<Department> getList() {
        return list;
    }

    public void setList(ArrayList<Department> list) {
        this.list = list;
    }

    public DepartmentList(Page page, ArrayList<Department> list) {
        this.page = page;
        this.list = list;
    }

    public DepartmentList() {
    }

    @Override
    public String toString() {
        return "DepartmentList{" +
                "page=" + page +
                ", list=" + list +
                '}';
    }
}
