package com.howellsdk.net.soap.bean;

import com.howellsdk.net.http.utils.DecodeUtils;

import java.io.Serializable;

/**
 * login request
 * attention: param password should be encoded<br/>
 * {@see "移动终端通讯协议.doc"}
 */
@SuppressWarnings("serial")
public class LoginRequest implements Serializable {
    private String mAccount;
    private String mPwdType;
    private String mPassword;
    private String mVersion;
    private String mIMEI;

    private String phoneModel;
    private String networkOperator;
    private String osVersion;
    private String manuFactory;

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public String getNetworkOperator() {
        return networkOperator;
    }

    public void setNetworkOperator(String networkOperator) {
        this.networkOperator = networkOperator;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getManuFactory() {
        return manuFactory;
    }

    public void setManuFactory(String manuFactory) {
        this.manuFactory = manuFactory;
    }


    public LoginRequest(String account,String password){
        mAccount = account;
        mPwdType = "Common";
        mPassword = DecodeUtils.getEncodedPassword(password);
        mVersion = "1.0.0.1";
    }

    public LoginRequest(String account ,String password,String imei){
        mAccount = account;
        mPwdType = "Common";
        mPassword = DecodeUtils.getEncodedPassword(password);
        mVersion = "1.0.0.1";
        mIMEI = imei;
    }


    @Deprecated
    public LoginRequest(String account, String pwdType, String password,
                        String version, String IEMI) {
        mAccount = account;
        mPwdType = pwdType;
        mPassword = DecodeUtils.getEncodedPassword(password);
        mVersion = version;
        this.mIMEI = IEMI;
    }

    public LoginRequest(String account, String pwdType, String password, String version, String phoneModel,
                        String networkOperator, String osVersion, String manuFactory, String IEMI){
        mAccount = account;
        mPwdType = pwdType;
        mPassword = DecodeUtils.getEncodedPassword(password);
        mVersion = version;
        this.phoneModel = phoneModel;
        this.networkOperator = networkOperator;
        this.osVersion = osVersion;
        this.manuFactory = manuFactory;
        mIMEI = IEMI;
    }




    public String getIEMI() {
		return mIMEI;
	}

	public void setIEMI(String mIEMI) {
		this.mIMEI = mIEMI;
	}

	public String getAccount() {
        return mAccount;
    }

    public void setAccount(String account) {
        mAccount = account;
    }

    public String getPwdType() {
        return mPwdType;
    }

    public void setPwdType(String pwdType) {
        mPwdType = pwdType;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getVersion() {
        return mVersion;
    }

    public void setVersion(String version) {
        mVersion = version;
    }

    @Override
    public String toString() {
        return "LoginRequest [account=" + mAccount + ", pwdType=" + mPwdType
                + ", password=" + mPassword + ", version=" + mVersion + "]";
    }

}
