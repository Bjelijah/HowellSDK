package com.howellsdk.net.soap.bean;

import com.howellsdk.net.http.bean.DeviceStatus;

/**
 * Created by Administrator on 2017/6/19.
 */

public class DeviceStatusReq {
    String account;
    String session;
    Integer pageNo;
    String searchID;
    Integer pageSize;

    @Override
    public String toString() {
        return "DeviceStatusReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", pageNo=" + pageNo +
                ", searchID='" + searchID + '\'' +
                ", pageSize=" + pageSize +
                '}';
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

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public String getSearchID() {
        return searchID;
    }

    public void setSearchID(String searchID) {
        this.searchID = searchID;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public DeviceStatusReq() {

    }

    public DeviceStatusReq(String account, String session, Integer pageNo, String searchID, Integer pageSize) {

        this.account = account;
        this.session = session;
        this.pageNo = pageNo;
        this.searchID = searchID;
        this.pageSize = pageSize;
    }

    public DeviceStatusReq(String account,String session){
        this.account = account;
        this.session = session;
        pageNo=null;
        searchID = null;
        pageSize=null;
    }

    public DeviceStatusReq(String account,String session,String searchId){
        this.account = account;
        this.session = session;
        pageNo = null;
        pageSize = null;
        this.searchID = searchId;
    }


}
