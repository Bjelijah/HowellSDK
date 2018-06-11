package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/14.
 */

public class UpgradeDevVerReq {
    String account;
    String session;
    String devID;
    String newDevVer;
    String ftpAddress;
    Integer ftpPort;
    String ftpAccount;
    String ftpPassword;
    String ftpFileName;

    @Override
    public String toString() {
        return "UpgradeDevVerReq{" +
                "account='" + account + '\'' +
                ", session='" + session + '\'' +
                ", devID='" + devID + '\'' +
                ", newDevVer='" + newDevVer + '\'' +
                ", ftpAddress='" + ftpAddress + '\'' +
                ", ftpPort=" + ftpPort +
                ", ftpAccount='" + ftpAccount + '\'' +
                ", ftpPassword='" + ftpPassword + '\'' +
                ", ftpFileName='" + ftpFileName + '\'' +
                '}';
    }

    public UpgradeDevVerReq() {
    }

    public UpgradeDevVerReq(String account, String session, String devID) {

        this.account = account;
        this.session = session;
        this.devID = devID;
    }

    public UpgradeDevVerReq(String account, String session, String devID, String newDevVer, String ftpAddress, Integer ftpPort, String ftpAccount, String ftpPassword, String ftpFileName) {

        this.account = account;
        this.session = session;
        this.devID = devID;
        this.newDevVer = newDevVer;
        this.ftpAddress = ftpAddress;
        this.ftpPort = ftpPort;
        this.ftpAccount = ftpAccount;
        this.ftpPassword = ftpPassword;
        this.ftpFileName = ftpFileName;
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

    public String getDevID() {
        return devID;
    }

    public void setDevID(String devID) {
        this.devID = devID;
    }

    public String getNewDevVer() {
        return newDevVer;
    }

    public void setNewDevVer(String newDevVer) {
        this.newDevVer = newDevVer;
    }

    public String getFtpAddress() {
        return ftpAddress;
    }

    public void setFtpAddress(String ftpAddress) {
        this.ftpAddress = ftpAddress;
    }

    public Integer getFtpPort() {
        return ftpPort;
    }

    public void setFtpPort(Integer ftpPort) {
        this.ftpPort = ftpPort;
    }

    public String getFtpAccount() {
        return ftpAccount;
    }

    public void setFtpAccount(String ftpAccount) {
        this.ftpAccount = ftpAccount;
    }

    public String getFtpPassword() {
        return ftpPassword;
    }

    public void setFtpPassword(String ftpPassword) {
        this.ftpPassword = ftpPassword;
    }

    public String getFtpFileName() {
        return ftpFileName;
    }

    public void setFtpFileName(String ftpFileName) {
        this.ftpFileName = ftpFileName;
    }
}
