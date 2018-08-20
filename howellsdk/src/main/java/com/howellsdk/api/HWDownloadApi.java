package com.howellsdk.api;

/**
 * 下载
 */
public interface HWDownloadApi {
    HWDownloadApi open(String path);
    HWDownloadApi start();
    HWDownloadApi stop();
    HWDownloadApi close();
}
