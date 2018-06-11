package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;
import com.howellsdk.net.http.utils.MD5;
import com.howellsdk.utils.Util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/8/9.
 */

public class ClientCredential {
    @SerializedName("UserName")         String userName;
    @SerializedName("Nonce")            String nonce;
    @SerializedName("Domain")           String domain;
    @SerializedName("ClientNonce")      String clientNonce;
    @SerializedName("VerifySession")    String verifySession;
    @SerializedName("PhysicalAddress")  String physicalAddress;

    @Override
    public String toString() {
        return "ClientCredential{" +
                "userName='" + userName + '\'' +
                ", nonce='" + nonce + '\'' +
                ", domain='" + domain + '\'' +
                ", clientNonce='" + clientNonce + '\'' +
                ", verifySession='" + verifySession + '\'' +
                ", physicalAddress='" + physicalAddress + '\'' +
                '}';
    }

    public ClientCredential(String userName,String userPassword,String domain,String nonce) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        this.userName = userName;
        this.domain = domain;
        this.nonce = nonce;
        this.clientNonce = Util.createClientNonce(32);
        String md5 = MD5.getMD5(userPassword);
        String password2 = userName+"@"+domain+":"+nonce+":"+clientNonce+":"+md5;
        this.verifySession = MD5.getMD5(password2);
    }



    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getClientNonce() {
        return clientNonce;
    }

    public void setClientNonce(String clientNonce) {
        this.clientNonce = clientNonce;
    }

    public String getVerifySession() {
        return verifySession;
    }

    public void setVerifySession(String verifySession) {
        this.verifySession = verifySession;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }
}
