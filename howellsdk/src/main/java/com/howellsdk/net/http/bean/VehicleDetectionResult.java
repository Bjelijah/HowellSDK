package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/26.
 */

public class VehicleDetectionResult {
    @SerializedName("Result") Integer result;
    @SerializedName("ExistedInDataBase") Boolean existedInDataBase;
    @SerializedName("ExistedInBlackList") Boolean existedInBlackList;
    @SerializedName("Plate") String plate;
    @SerializedName("Id") String Id;
    @SerializedName("PlateColor") String plateColor;
    @SerializedName("VehicleColor") String vehicleColor;
    @SerializedName("Brand") String brand;
    @SerializedName("ChildBrand") String childBrand;
    @SerializedName("Description") String description;

    @Override
    public String toString() {
        return "VehicleDetectionResult{" +
                "result=" + result +
                ", existedInDataBase=" + existedInDataBase +
                ", existedInBlackList=" + existedInBlackList +
                ", plate='" + plate + '\'' +
                ", Id='" + Id + '\'' +
                ", plateColor='" + plateColor + '\'' +
                ", vehicleColor='" + vehicleColor + '\'' +
                ", brand='" + brand + '\'' +
                ", childBrand='" + childBrand + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Boolean getExistedInDataBase() {
        return existedInDataBase;
    }

    public void setExistedInDataBase(Boolean existedInDataBase) {
        this.existedInDataBase = existedInDataBase;
    }

    public Boolean getExistedInBlackList() {
        return existedInBlackList;
    }

    public void setExistedInBlackList(Boolean existedInBlackList) {
        this.existedInBlackList = existedInBlackList;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VehicleDetectionResult() {

    }

    public VehicleDetectionResult(Integer result, Boolean existedInDataBase, Boolean existedInBlackList, String plate, String id, String plateColor, String vehicleColor, String brand, String childBrand, String description) {

        this.result = result;
        this.existedInDataBase = existedInDataBase;
        this.existedInBlackList = existedInBlackList;
        this.plate = plate;
        Id = id;
        this.plateColor = plateColor;
        this.vehicleColor = vehicleColor;
        this.brand = brand;
        this.childBrand = childBrand;
        this.description = description;
    }
}
