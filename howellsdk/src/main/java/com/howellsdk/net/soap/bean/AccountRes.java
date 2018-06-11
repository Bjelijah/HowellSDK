package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/16.
 */

public class AccountRes {
    String result;
    String userName;
    String email;
    String mobileTel;
    String country;
    String countryTelCode;
    String IDCard;

    @Override
    public String toString() {
        return "AccountRes{" +
                "result='" + result + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", mobileTel='" + mobileTel + '\'' +
                ", country='" + country + '\'' +
                ", countryTelCode='" + countryTelCode + '\'' +
                ", IDCard='" + IDCard + '\'' +
                '}';
    }

    public AccountRes() {
    }

    public AccountRes(String result, String userName, String email, String mobileTel, String country, String countryTelCode, String IDCard) {

        this.result = result;
        this.userName = userName;
        this.email = email;
        this.mobileTel = mobileTel;
        this.country = country;
        this.countryTelCode = countryTelCode;
        this.IDCard = IDCard;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileTel() {
        return mobileTel;
    }

    public void setMobileTel(String mobileTel) {
        this.mobileTel = mobileTel;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryTelCode() {
        return countryTelCode;
    }

    public void setCountryTelCode(String countryTelCode) {
        this.countryTelCode = countryTelCode;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }
}
