package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/11/3.
 */

public class PDCServiceVersion {
    @SerializedName("Version") String version;
    @SerializedName("BuildDate") String buildDate;
    @SerializedName("Company") String company;

    @Override
    public String toString() {
        return "PDCServiceVersion{" +
                "version='" + version + '\'' +
                ", buildDate='" + buildDate + '\'' +
                ", company='" + company + '\'' +
                '}';
    }

    public PDCServiceVersion() {
    }

    public PDCServiceVersion(String version, String buildDate, String company) {

        this.version = version;
        this.buildDate = buildDate;
        this.company = company;
    }

    public String getVersion() {

        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(String buildDate) {
        this.buildDate = buildDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
