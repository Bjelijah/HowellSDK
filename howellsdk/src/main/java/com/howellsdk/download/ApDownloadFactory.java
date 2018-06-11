package com.howellsdk.download;

import android.util.Log;

import com.howell.jni.JniUtil;
import com.howellsdk.api.HWDownloadApi;
import com.howellsdk.utils.FileUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ApDownloadFactory {
    int mType = 0;
    private ApDownloadFactory(int type){
        mType = type;
    }

    public HWDownloadApi create(){
        return new DownloadPudect();
    }

    public static final class Builder{
        int type = 0;

        public Builder setType(int type) {
            this.type = type;
            return this;
        }

        public ApDownloadFactory build(){
            return new ApDownloadFactory(type);
        }
    }

    public final class DownloadPudect extends HwBaseDownload{
        RandomAccessFile mFile;



        @Override
        public HWDownloadApi open(String path) {
            try {
                mFile = FileUtil.createVideoFile(path);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //jni init
            JniUtil.downloadInit();
            JniUtil.downloadType(mType);
            JniUtil.downloadSetCallbackObj(this,0);
            JniUtil.downloadSetAudioCodeVideoCode(-1,-1);
            JniUtil.downloadSetCallbackMethod("saveData",0);
            return this;
        }

        @Override
        public HWDownloadApi start() {
            JniUtil.downloadEnable(true);
            return this;
        }

        @Override
        public HWDownloadApi stop() {
            JniUtil.downloadEnable(false);
            return this;
        }


        private void saveData(byte[] data) {
//            Log.i("123","save data dataLen="+data.length);
            try {
                FileUtil.write2VideoFile(mFile,data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public HWDownloadApi close() {
            try {
                FileUtil.closeVideoFile(mFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //jni deinit we not deinit
//            JniUtil.downloadDeinit();
            return this;
        }
    }
}
