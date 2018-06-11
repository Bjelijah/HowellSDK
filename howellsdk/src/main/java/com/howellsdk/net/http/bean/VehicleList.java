package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/26.
 */

public class VehicleList {
    @SerializedName("Page") Page page;
    @SerializedName("Vehicle") ArrayList<Vehicle> vehicles;

    @Override
    public String toString() {
        return "VehicleList{" +
                "page=" + page +
                ", vehicles=" + vehicles +
                '}';
    }

    public VehicleList() {
    }

    public Page getPage() {

        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public VehicleList(Page page, ArrayList<Vehicle> vehicles) {

        this.page = page;
        this.vehicles = vehicles;
    }
}
