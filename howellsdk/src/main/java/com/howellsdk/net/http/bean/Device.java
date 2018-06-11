package com.howellsdk.net.http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/4/10.
 */

public class Device {
    @SerializedName("Id")                               String id;
    @SerializedName("AuthenticationCode")               String authenticationCode;
    @SerializedName("Name")                             String name;
    @SerializedName("Manufacturer")                     String manufacturer;
    @SerializedName("Model")                            String model;
    @SerializedName("Firmware")                         String firmware;
    @SerializedName("SerialNumber")                     String serialNumber;
    @SerializedName("PointOfSale")                      String pointOfSale;
    @SerializedName("Information")                      String information;
    @SerializedName("Username")                         String userName;
    @SerializedName("Password")                         String password;
    @SerializedName("Uri")                              String uri;
    @SerializedName("Classification")                   String classification;
    @SerializedName("ProtocolType")                     String protocolType;
    @SerializedName("ParentDeviceId")                   String parentDeviceId;
    @SerializedName("BusAddress")                       Integer busAddress;
    @SerializedName("HasSubDevice")                     Boolean hasSubDevice;
    @SerializedName("Abilities")                        String abilities;
    @SerializedName("RatedVoltage")                     Double ratedVoltage;
    @SerializedName("MaximumUserConnectionsNumber")     Integer maximumUserConnectionsNumber;
    @SerializedName("MaximumVideoConnectionsNumber")    Integer maximumVideoConnectionsNumber;
    @SerializedName("ExistedInDatabase")                Boolean existedInDatabase;
    @SerializedName("DeviceStatus")                     DeviceStatus deviceStatus;
    @SerializedName("VideoInputChannelCount")           Integer videoInputChannelConunt;
    @SerializedName("VideoOutputChannelCount")          Integer videoOutputChannelCount;
    @SerializedName("IOInputChannelCount")              Integer IOInputChannelCount;
    @SerializedName("IOOutputChannelCount")             Integer IOOutputChannelCount;
    @SerializedName("NetworkInterfaceCount")            Integer NetworkInterfaceCount;
    @SerializedName("StorageMediumCount")               Integer StorageMediumCount;
    @SerializedName("DecodingChannelCount")             Integer decodingChannelCount;
    @SerializedName("RelationUserCount")                Integer relationUserCount;
    @SerializedName("RelationDepartmentCount")          Integer relationDepartmentCount;
    @SerializedName("NetworkInterface")                 NetworkInterface networkInterface;
    @SerializedName("PlatformId")                       String platformId;
    @SerializedName("PlatformAccessId")                 String platformAccessId;

    public NetworkInterface getNetworkInterface() {
        return networkInterface;
    }

    public void setNetworkInterface(NetworkInterface networkInterface) {
        this.networkInterface = networkInterface;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getPlatformAccessId() {
        return platformAccessId;
    }

    public void setPlatformAccessId(String platformAccessId) {
        this.platformAccessId = platformAccessId;
    }

    public Device(String id, String authenticationCode, String name, String manufacturer, String model, String firmware, String serialNumber, String pointOfSale, String information, String userName, String password, String uri, String classification, String protocolType, String parentDeviceId, int busAddress, boolean hasSubDevice, String abilities, double ratedVoltage, int maximumUserConnectionsNumber, int maximumVideoConnectionsNumber, boolean existedInDatabase, DeviceStatus deviceStatus, int videoInputChannelConunt, int videoOutputChannelCount, int IOInputChannelCount, int IOOutputChannelCount, int networkInterfaceCount, int storageMediumCount, int decodingChannelCount, int relationUserCount, int relationDepartmentCount, NetworkInterface networkInterface, String platformId, String platformAccessId) {

        this.id = id;
        this.authenticationCode = authenticationCode;
        this.name = name;
        this.manufacturer = manufacturer;
        this.model = model;
        this.firmware = firmware;
        this.serialNumber = serialNumber;
        this.pointOfSale = pointOfSale;
        this.information = information;
        this.userName = userName;
        this.password = password;
        this.uri = uri;
        this.classification = classification;
        this.protocolType = protocolType;
        this.parentDeviceId = parentDeviceId;
        this.busAddress = busAddress;
        this.hasSubDevice = hasSubDevice;
        this.abilities = abilities;
        this.ratedVoltage = ratedVoltage;
        this.maximumUserConnectionsNumber = maximumUserConnectionsNumber;
        this.maximumVideoConnectionsNumber = maximumVideoConnectionsNumber;
        this.existedInDatabase = existedInDatabase;
        this.deviceStatus = deviceStatus;
        this.videoInputChannelConunt = videoInputChannelConunt;
        this.videoOutputChannelCount = videoOutputChannelCount;
        this.IOInputChannelCount = IOInputChannelCount;
        this.IOOutputChannelCount = IOOutputChannelCount;
        NetworkInterfaceCount = networkInterfaceCount;
        StorageMediumCount = storageMediumCount;
        this.decodingChannelCount = decodingChannelCount;
        this.relationUserCount = relationUserCount;
        this.relationDepartmentCount = relationDepartmentCount;
        this.networkInterface = networkInterface;
        this.platformId = platformId;
        this.platformAccessId = platformAccessId;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id='" + id + '\'' +
                ", authenticationCode='" + authenticationCode + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", firmware='" + firmware + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", pointOfSale='" + pointOfSale + '\'' +
                ", information='" + information + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", uri='" + uri + '\'' +
                ", classification='" + classification + '\'' +
                ", protocolType='" + protocolType + '\'' +
                ", parentDeviceId='" + parentDeviceId + '\'' +
                ", busAddress=" + busAddress +
                ", hasSubDevice=" + hasSubDevice +
                ", abilities='" + abilities + '\'' +
                ", ratedVoltage=" + ratedVoltage +
                ", maximumUserConnectionsNumber=" + maximumUserConnectionsNumber +
                ", maximumVideoConnectionsNumber=" + maximumVideoConnectionsNumber +
                ", existedInDatabase=" + existedInDatabase +
                ", deviceStatus=" + deviceStatus +
                ", videoInputChannelConunt=" + videoInputChannelConunt +
                ", videoOutputChannelCount=" + videoOutputChannelCount +
                ", IOInputChannelCount=" + IOInputChannelCount +
                ", IOOutputChannelCount=" + IOOutputChannelCount +
                ", NetworkInterfaceCount=" + NetworkInterfaceCount +
                ", StorageMediumCount=" + StorageMediumCount +
                ", decodingChannelCount=" + decodingChannelCount +
                ", relationUserCount=" + relationUserCount +
                ", relationDepartmentCount=" + relationDepartmentCount +
                ", networkInterface=" + networkInterface +
                ", platformId='" + platformId + '\'' +
                ", platformAccessId='" + platformAccessId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthenticationCode() {
        return authenticationCode;
    }

    public void setAuthenticationCode(String authenticationCode) {
        this.authenticationCode = authenticationCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFirmware() {
        return firmware;
    }

    public void setFirmware(String firmware) {
        this.firmware = firmware;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPointOfSale() {
        return pointOfSale;
    }

    public void setPointOfSale(String pointOfSale) {
        this.pointOfSale = pointOfSale;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }

    public String getParentDeviceId() {
        return parentDeviceId;
    }

    public void setParentDeviceId(String parentDeviceId) {
        this.parentDeviceId = parentDeviceId;
    }

    public int getBusAddress() {
        return busAddress;
    }

    public void setBusAddress(int busAddress) {
        this.busAddress = busAddress;
    }

    public boolean isHasSubDevice() {
        return hasSubDevice;
    }

    public void setHasSubDevice(boolean hasSubDevice) {
        this.hasSubDevice = hasSubDevice;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public double getRatedVoltage() {
        return ratedVoltage;
    }

    public void setRatedVoltage(double ratedVoltage) {
        this.ratedVoltage = ratedVoltage;
    }

    public int getMaximumUserConnectionsNumber() {
        return maximumUserConnectionsNumber;
    }

    public void setMaximumUserConnectionsNumber(int maximumUserConnectionsNumber) {
        this.maximumUserConnectionsNumber = maximumUserConnectionsNumber;
    }

    public int getMaximumVideoConnectionsNumber() {
        return maximumVideoConnectionsNumber;
    }

    public void setMaximumVideoConnectionsNumber(int maximumVideoConnectionsNumber) {
        this.maximumVideoConnectionsNumber = maximumVideoConnectionsNumber;
    }

    public boolean isExistedInDatabase() {
        return existedInDatabase;
    }

    public void setExistedInDatabase(boolean existedInDatabase) {
        this.existedInDatabase = existedInDatabase;
    }

    public DeviceStatus getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(DeviceStatus deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public int getVideoInputChannelConunt() {
        return videoInputChannelConunt;
    }

    public void setVideoInputChannelConunt(int videoInputChannelConunt) {
        this.videoInputChannelConunt = videoInputChannelConunt;
    }

    public int getVideoOutputChannelCount() {
        return videoOutputChannelCount;
    }

    public void setVideoOutputChannelCount(int videoOutputChannelCount) {
        this.videoOutputChannelCount = videoOutputChannelCount;
    }

    public int getIOInputChannelCount() {
        return IOInputChannelCount;
    }

    public void setIOInputChannelCount(int IOInputChannelCount) {
        this.IOInputChannelCount = IOInputChannelCount;
    }

    public int getIOOutputChannelCount() {
        return IOOutputChannelCount;
    }

    public void setIOOutputChannelCount(int IOOutputChannelCount) {
        this.IOOutputChannelCount = IOOutputChannelCount;
    }

    public int getNetworkInterfaceCount() {
        return NetworkInterfaceCount;
    }

    public void setNetworkInterfaceCount(int networkInterfaceCount) {
        NetworkInterfaceCount = networkInterfaceCount;
    }

    public int getStorageMediumCount() {
        return StorageMediumCount;
    }

    public void setStorageMediumCount(int storageMediumCount) {
        StorageMediumCount = storageMediumCount;
    }

    public int getDecodingChannelCount() {
        return decodingChannelCount;
    }

    public void setDecodingChannelCount(int decodingChannelCount) {
        this.decodingChannelCount = decodingChannelCount;
    }

    public int getRelationUserCount() {
        return relationUserCount;
    }

    public void setRelationUserCount(int relationUserCount) {
        this.relationUserCount = relationUserCount;
    }

    public int getRelationDepartmentCount() {
        return relationDepartmentCount;
    }

    public void setRelationDepartmentCount(int relationDepartmentCount) {
        this.relationDepartmentCount = relationDepartmentCount;
    }

    public Device(String id, String authenticationCode, String name, String manufacturer, String model, String firmware, String serialNumber, String pointOfSale, String information, String userName, String password, String uri, String classification, String protocolType, String parentDeviceId, int busAddress, boolean hasSubDevice, String abilities, double ratedVoltage, int maximumUserConnectionsNumber, int maximumVideoConnectionsNumber, boolean existedInDatabase, DeviceStatus deviceStatus, int videoInputChannelConunt, int videoOutputChannelCount, int IOInputChannelCount, int IOOutputChannelCount, int networkInterfaceCount, int storageMediumCount, int decodingChannelCount, int relationUserCount, int relationDepartmentCount) {

        this.id = id;
        this.authenticationCode = authenticationCode;
        this.name = name;
        this.manufacturer = manufacturer;
        this.model = model;
        this.firmware = firmware;
        this.serialNumber = serialNumber;
        this.pointOfSale = pointOfSale;
        this.information = information;
        this.userName = userName;
        this.password = password;
        this.uri = uri;
        this.classification = classification;
        this.protocolType = protocolType;
        this.parentDeviceId = parentDeviceId;
        this.busAddress = busAddress;
        this.hasSubDevice = hasSubDevice;
        this.abilities = abilities;
        this.ratedVoltage = ratedVoltage;
        this.maximumUserConnectionsNumber = maximumUserConnectionsNumber;
        this.maximumVideoConnectionsNumber = maximumVideoConnectionsNumber;
        this.existedInDatabase = existedInDatabase;
        this.deviceStatus = deviceStatus;
        this.videoInputChannelConunt = videoInputChannelConunt;
        this.videoOutputChannelCount = videoOutputChannelCount;
        this.IOInputChannelCount = IOInputChannelCount;
        this.IOOutputChannelCount = IOOutputChannelCount;
        NetworkInterfaceCount = networkInterfaceCount;
        StorageMediumCount = storageMediumCount;
        this.decodingChannelCount = decodingChannelCount;
        this.relationUserCount = relationUserCount;
        this.relationDepartmentCount = relationDepartmentCount;
    }

    public Device() {
    }

}
