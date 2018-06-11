package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/19.
 */

public class VideoBasicRes {
    String result;
    String DNMode;
    DNSensitivity dnSensitivity;
    String AGCMode;
    AGC agc;
    String eShutterMode;
    EShutter eShutter;
    String infraredMode;

    @Override
    public String toString() {
        return "VideoBasicRes{" +
                "result='" + result + '\'' +
                ", DNMode='" + DNMode + '\'' +
                ", dnSensitivity=" + dnSensitivity +
                ", AGCMode='" + AGCMode + '\'' +
                ", agc=" + agc +
                ", eShutterMode='" + eShutterMode + '\'' +
                ", eShutter=" + eShutter +
                ", infraredMode='" + infraredMode + '\'' +
                '}';
    }

    public VideoBasicRes() {
    }

    public VideoBasicRes(String result, String DNMode, DNSensitivity dnSensitivity, String AGCMode, AGC agc, String eShutterMode, EShutter eShutter, String infraredMode) {

        this.result = result;
        this.DNMode = DNMode;
        this.dnSensitivity = dnSensitivity;
        this.AGCMode = AGCMode;
        this.agc = agc;
        this.eShutterMode = eShutterMode;
        this.eShutter = eShutter;
        this.infraredMode = infraredMode;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDNMode() {
        return DNMode;
    }

    public void setDNMode(String DNMode) {
        this.DNMode = DNMode;
    }

    public DNSensitivity getDnSensitivity() {
        return dnSensitivity;
    }

    public void setDnSensitivity(DNSensitivity dnSensitivity) {
        this.dnSensitivity = dnSensitivity;
    }

    public String getAGCMode() {
        return AGCMode;
    }

    public void setAGCMode(String AGCMode) {
        this.AGCMode = AGCMode;
    }

    public AGC getAgc() {
        return agc;
    }

    public void setAgc(AGC agc) {
        this.agc = agc;
    }

    public String geteShutterMode() {
        return eShutterMode;
    }

    public void seteShutterMode(String eShutterMode) {
        this.eShutterMode = eShutterMode;
    }

    public EShutter geteShutter() {
        return eShutter;
    }

    public void seteShutter(EShutter eShutter) {
        this.eShutter = eShutter;
    }

    public String getInfraredMode() {
        return infraredMode;
    }

    public void setInfraredMode(String infraredMode) {
        this.infraredMode = infraredMode;
    }

    public static class DNSensitivity{
        int min;
        int max;
        int value;

        @Override
        public String toString() {
            return "DNSensitivity{" +
                    "min=" + min +
                    ", max=" + max +
                    ", value=" + value +
                    '}';
        }

        public DNSensitivity() {
        }

        public DNSensitivity(int min, int max, int value) {

            this.min = min;
            this.max = max;
            this.value = value;
        }

        public int getMin() {

            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static class AGC{
        int min;
        int max;
        int value;

        @Override
        public String toString() {
            return "AGC{" +
                    "min=" + min +
                    ", max=" + max +
                    ", value=" + value +
                    '}';
        }

        public AGC() {
        }

        public AGC(int min, int max, int value) {

            this.min = min;
            this.max = max;
            this.value = value;
        }

        public int getMin() {

            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static class EShutter{
        String value;
        String options;

        @Override
        public String toString() {
            return "EShutter{" +
                    "value='" + value + '\'' +
                    ", options='" + options + '\'' +
                    '}';
        }

        public EShutter() {
        }

        public EShutter(String value, String options) {

            this.value = value;
            this.options = options;
        }

        public String getValue() {

            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getOptions() {
            return options;
        }

        public void setOptions(String options) {
            this.options = options;
        }
    }

}
