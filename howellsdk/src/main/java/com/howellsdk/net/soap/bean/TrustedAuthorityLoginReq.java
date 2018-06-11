package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/19.
 */

public class TrustedAuthorityLoginReq {
    String trustedAuthority;
    String trustedCode;
    String authorizationCode;
    String version;
    String networkOperator;
    String netType;
    MCUDev mcuDev;
    String applicationID;

    @Override
    public String toString() {
        return "TrustedAuthorityLoginReq{" +
                "trustedAuthority='" + trustedAuthority + '\'' +
                ", trustedCode='" + trustedCode + '\'' +
                ", authorizationCode='" + authorizationCode + '\'' +
                ", version='" + version + '\'' +
                ", networkOperator='" + networkOperator + '\'' +
                ", netType='" + netType + '\'' +
                ", mcuDev=" + mcuDev +
                ", applicationID='" + applicationID + '\'' +
                '}';
    }

    public TrustedAuthorityLoginReq() {
    }

    public TrustedAuthorityLoginReq(String trustedAuthority, String trustedCode, String authorizationCode, String version, String networkOperator, String netType, MCUDev mcuDev, String applicationID) {

        this.trustedAuthority = trustedAuthority;
        this.trustedCode = trustedCode;
        this.authorizationCode = authorizationCode;
        this.version = version;
        this.networkOperator = networkOperator;
        this.netType = netType;
        this.mcuDev = mcuDev;
        this.applicationID = applicationID;
    }

    public String getTrustedAuthority() {

        return trustedAuthority;
    }

    public void setTrustedAuthority(String trustedAuthority) {
        this.trustedAuthority = trustedAuthority;
    }

    public String getTrustedCode() {
        return trustedCode;
    }

    public void setTrustedCode(String trustedCode) {
        this.trustedCode = trustedCode;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNetworkOperator() {
        return networkOperator;
    }

    public void setNetworkOperator(String networkOperator) {
        this.networkOperator = networkOperator;
    }

    public String getNetType() {
        return netType;
    }

    public void setNetType(String netType) {
        this.netType = netType;
    }

    public MCUDev getMcuDev() {
        return mcuDev;
    }

    public void setMcuDev(MCUDev mcuDev) {
        this.mcuDev = mcuDev;
    }

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public static class MCUDev{
        String UUID;
        String model;
        String type;
        String osType;
        String osVersion;
        String manufactory;
        String IEMI;


        @Override
        public String toString() {
            return "MCUDev{" +
                    "UUID='" + UUID + '\'' +
                    ", model='" + model + '\'' +
                    ", type='" + type + '\'' +
                    ", osType='" + osType + '\'' +
                    ", osVersion='" + osVersion + '\'' +
                    ", manufactory='" + manufactory + '\'' +
                    ", IEMI='" + IEMI + '\'' +
                    '}';
        }

        public MCUDev() {
        }

        public MCUDev(String UUID, String model, String type, String osType, String osVersion, String manufactory, String IEMI) {

            this.UUID = UUID;
            this.model = model;
            this.type = type;
            this.osType = osType;
            this.osVersion = osVersion;
            this.manufactory = manufactory;
            this.IEMI = IEMI;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getUUID() {

            return UUID;
        }

        public void setUUID(String UUID) {
            this.UUID = UUID;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getOsType() {
            return osType;
        }

        public void setOsType(String osType) {
            this.osType = osType;
        }

        public String getOsVersion() {
            return osVersion;
        }

        public void setOsVersion(String osVersion) {
            this.osVersion = osVersion;
        }

        public String getManufactory() {
            return manufactory;
        }

        public void setManufactory(String manufactory) {
            this.manufactory = manufactory;
        }

        public String getIEMI() {
            return IEMI;
        }

        public void setIEMI(String IEMI) {
            this.IEMI = IEMI;
        }
    }


}
