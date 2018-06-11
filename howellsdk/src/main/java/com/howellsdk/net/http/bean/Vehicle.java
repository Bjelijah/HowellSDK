package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/26.
 */

public class Vehicle {
    @SerializedName("Id") String id;
    @SerializedName("CreationTime") String createTime;
    @SerializedName("Name") String name;
    @SerializedName("Plate") String plate;
    @SerializedName("PlateColor") String plateColor;
    @SerializedName("VehicleColor") String vehicleColor;
    @SerializedName("Brand") String brand;
    @SerializedName("ChildBrand") String childBrand;
    @SerializedName("ExistedInBlackList") Boolean existedInBlackList;
    @SerializedName("MatchingPercentage") Integer matchingPercentage;
    @SerializedName("Description") String description;

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", createTime='" + createTime + '\'' +
                ", name='" + name + '\'' +
                ", plate='" + plate + '\'' +
                ", plateColor='" + plateColor + '\'' +
                ", vehicleColor='" + vehicleColor + '\'' +
                ", brand='" + brand + '\'' +
                ", childBrand='" + childBrand + '\'' +
                ", existedInBlackList=" + existedInBlackList +
                ", matchingPercentage=" + matchingPercentage +
                ", description='" + description + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(String plateColor) {
        this.plateColor = plateColor;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getChildBrand() {
        return childBrand;
    }

    public void setChildBrand(String childBrand) {
        this.childBrand = childBrand;
    }

    public Boolean getExistedInBlackList() {
        return existedInBlackList;
    }

    public void setExistedInBlackList(Boolean existedInBlackList) {
        this.existedInBlackList = existedInBlackList;
    }

    public Integer getMatchingPercentage() {
        return matchingPercentage;
    }

    public void setMatchingPercentage(Integer matchingPercentage) {
        this.matchingPercentage = matchingPercentage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Vehicle() {

    }

    public Vehicle(String id, String createTime, String name, String plate, String plateColor, String vehicleColor, String brand, String childBrand, Boolean existedInBlackList, Integer matchingPercentage, String description) {

        this.id = id;
        this.createTime = createTime;
        this.name = name;
        this.plate = plate;
        this.plateColor = plateColor;
        this.vehicleColor = vehicleColor;
        this.brand = brand;
        this.childBrand = childBrand;
        this.existedInBlackList = existedInBlackList;
        this.matchingPercentage = matchingPercentage;
        this.description = description;
    }
}
