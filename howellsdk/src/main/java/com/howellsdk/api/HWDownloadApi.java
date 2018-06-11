package com.howellsdk.api;

public interface HWDownloadApi {
    HWDownloadApi open(String path);
    HWDownloadApi start();
    HWDownloadApi stop();
    HWDownloadApi close();
}
