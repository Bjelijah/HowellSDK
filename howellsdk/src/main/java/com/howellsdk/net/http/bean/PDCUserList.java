package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/23.
 */

public class PDCUserList {
    @SerializedName("Page")         Page page;
    @SerializedName("PDCUser")      ArrayList<PDCUser> pdcUsers;

    @Override
    public String toString() {
        return "PDCUserList{" +
                "page=" + page +
                ", pdcUsers=" + pdcUsers +
                '}';
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public ArrayList<PDCUser> getPdcUsers() {
        return pdcUsers;
    }

    public void setPdcUsers(ArrayList<PDCUser> pdcUsers) {
        this.pdcUsers = pdcUsers;
    }

    public PDCUserList() {

    }

    public PDCUserList(Page page, ArrayList<PDCUser> pdcUsers) {

        this.page = page;
        this.pdcUsers = pdcUsers;
    }
}
