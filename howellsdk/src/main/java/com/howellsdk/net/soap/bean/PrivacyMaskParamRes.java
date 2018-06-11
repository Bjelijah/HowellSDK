package com.howellsdk.net.soap.bean;

/**
 * Created by Administrator on 2017/6/15.
 */

public class PrivacyMaskParamRes {
    String result;
    Boolean enable;
    int horizontalResolution;
    int verticalResolution;
    PrivacyMaskRegion privacyMaskRegion;

    @Override
    public String toString() {
        return "PrivacyMaskParamRes{" +
                "result='" + result + '\'' +
                ", enable=" + enable +
                ", horizontalResolution=" + horizontalResolution +
                ", verticalResolution=" + verticalResolution +
                ", privacyMaskRegion=" + privacyMaskRegion +
                '}';
    }

    public PrivacyMaskParamRes() {
    }

    public PrivacyMaskParamRes(String result, Boolean enable, int horizontalResolution, int verticalResolution, PrivacyMaskRegion privacyMaskRegion) {

        this.result = result;
        this.enable = enable;
        this.horizontalResolution = horizontalResolution;
        this.verticalResolution = verticalResolution;
        this.privacyMaskRegion = privacyMaskRegion;
    }

    public String getResult() {

        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public int getHorizontalResolution() {
        return horizontalResolution;
    }

    public void setHorizontalResolution(int horizontalResolution) {
        this.horizontalResolution = horizontalResolution;
    }

    public int getVerticalResolution() {
        return verticalResolution;
    }

    public void setVerticalResolution(int verticalResolution) {
        this.verticalResolution = verticalResolution;
    }

    public PrivacyMaskRegion getPrivacyMaskRegion() {
        return privacyMaskRegion;
    }

    public void setPrivacyMaskRegion(PrivacyMaskRegion privacyMaskRegion) {
        this.privacyMaskRegion = privacyMaskRegion;
    }

    public static class PrivacyMaskRegion{
        int left;
        int top;
        int right;
        int bottom;

        @Override
        public String toString() {
            return "PrivacyMaskRegion{" +
                    "left=" + left +
                    ", top=" + top +
                    ", right=" + right +
                    ", bottom=" + bottom +
                    '}';
        }

        public PrivacyMaskRegion() {
        }

        public PrivacyMaskRegion(int left, int top, int right, int bottom) {

            this.left = left;
            this.top = top;
            this.right = right;
            this.bottom = bottom;
        }

        public int getLeft() {

            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }

        public int getBottom() {
            return bottom;
        }

        public void setBottom(int bottom) {
            this.bottom = bottom;
        }
    }
}
