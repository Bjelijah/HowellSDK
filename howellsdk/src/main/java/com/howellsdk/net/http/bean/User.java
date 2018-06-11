package com.howellsdk.net.http.bean;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/7.
 */

public class User {
    @SerializedName("Id")                              String id;
    @SerializedName("Name")                            String userName;
    @SerializedName("NickName")                        String nickName;
    @SerializedName("Password")                        String password;
    @SerializedName("Mobile")                          String mobile;
    @SerializedName("Phone")                           String phone;
    @SerializedName("UniformedId")                     String uniformedId;
    @SerializedName("Duty")                            String duty;
    @SerializedName("Information")                     String information;
    @SerializedName("Sex")                             String sex;
    @SerializedName("Permission")                      String permission;
    @SerializedName("DetailPermission")                String detailPermission;
    @SerializedName("DeviceCount")                     Integer deviceCount;
    @SerializedName("VideoInputChannelCount")          Integer videoInputChannelCount;
    @SerializedName("VideoOutputChannelCount")         Integer videoOutputChannelCount;
    @SerializedName("IOInputChannelCount")             Integer IOInputChannelCount;
    @SerializedName("IOOutputChannelCount")            Integer IOOutputChannelCount;
    @SerializedName("DepartmentCount")                 Integer departmentCount;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", phone='" + phone + '\'' +
                ", uniformedId='" + uniformedId + '\'' +
                ", duty='" + duty + '\'' +
                ", information='" + information + '\'' +
                ", sex='" + sex + '\'' +
                ", permission='" + permission + '\'' +
                ", detailPermission='" + detailPermission + '\'' +
                ", deviceCount=" + deviceCount +
                ", videoInputChannelCount=" + videoInputChannelCount +
                ", videoOutputChannelCount=" + videoOutputChannelCount +
                ", IOInputChannelCount=" + IOInputChannelCount +
                ", IOOutputChannelCount=" + IOOutputChannelCount +
                ", departmentCount=" + departmentCount +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public @Nullable String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public @Nullable String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public @Nullable String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public @Nullable String getUniformedId() {
        return uniformedId;
    }

    public void setUniformedId(String uniformedId) {
        this.uniformedId = uniformedId;
    }

    public @Nullable String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public @Nullable String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public @Nullable String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public @Nullable String getDetailPermission() {
        return detailPermission;
    }

    public void setDetailPermission(String detailPermission) {
        this.detailPermission = detailPermission;
    }

    public @Nullable Integer getDeviceCount() {
        return deviceCount;
    }

    public void setDeviceCount(Integer deviceCount) {
        this.deviceCount = deviceCount;
    }

    public @Nullable Integer getVideoInputChannelCount() {
        return videoInputChannelCount;
    }

    public void setVideoInputChannelCount(Integer videoInputChannelCount) {
        this.videoInputChannelCount = videoInputChannelCount;
    }

    public @Nullable Integer getVideoOutputChannelCount() {
        return videoOutputChannelCount;
    }

    public void setVideoOutputChannelCount(Integer videoOutputChannelCount) {
        this.videoOutputChannelCount = videoOutputChannelCount;
    }

    public @Nullable Integer getIOInputChannelCount() {
        return IOInputChannelCount;
    }

    public void setIOInputChannelCount(Integer IOInputChannelCount) {
        this.IOInputChannelCount = IOInputChannelCount;
    }

    public @Nullable Integer getIOOutputChannelCount() {
        return IOOutputChannelCount;
    }

    public void setIOOutputChannelCount(Integer IOOutputChannelCount) {
        this.IOOutputChannelCount = IOOutputChannelCount;
    }

    public @Nullable Integer getDepartmentCount() {
        return departmentCount;
    }

    public void setDepartmentCount(Integer departmentCount) {
        this.departmentCount = departmentCount;
    }

    public User() {

    }

    public User(String id, String userName, String nickName, String password, String mobile, String phone, String uniformedId, String duty, String information, String sex, String permission, String detailPermission, Integer deviceCount, Integer videoInputChannelCount, Integer videoOutputChannelCount, Integer IOInputChannelCount, Integer IOOutputChannelCount, Integer departmentCount) {

        this.id = id;
        this.userName = userName;
        this.nickName = nickName;
        this.password = password;
        this.mobile = mobile;
        this.phone = phone;
        this.uniformedId = uniformedId;
        this.duty = duty;
        this.information = information;
        this.sex = sex;
        this.permission = permission;
        this.detailPermission = detailPermission;
        this.deviceCount = deviceCount;
        this.videoInputChannelCount = videoInputChannelCount;
        this.videoOutputChannelCount = videoOutputChannelCount;
        this.IOInputChannelCount = IOInputChannelCount;
        this.IOOutputChannelCount = IOOutputChannelCount;
        this.departmentCount = departmentCount;
    }
}
