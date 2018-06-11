package com.howellsdk.player.local;

import android.util.Log;

import com.howell.jni.JniUtil;
import com.howellsdk.api.HWPlayApi;
import com.howellsdk.player.HwBasePlay;

public class LocalFactory {
    String mPath;
    int mCrypto;
    private LocalFactory(String p,int c){
        mPath = p;
        mCrypto = c;
    }

    public LocalProduct create(){
        return new LocalProduct();
    }

    public static final class Builder{
        String path;
        int crypto;

        public Builder setPath(String path) {
            this.path = path;
            return this;
        }

        public Builder setCrypto(int crypto) {
            this.crypto = crypto;
            return this;
        }

        public LocalFactory build(){
            return new LocalFactory(path,crypto);
        }
    }

    public final class LocalProduct extends HwBasePlay {
        @Override
        public boolean connect() {
            return true;
        }

        @Override
        public boolean disconnect() {
            return true;
        }

        @Override
        public void setUri(String uri) {
            mPath = uri;
        }

        @Override
        public void play(boolean isSub) {
            if (JniUtil.isNetReady()){
                JniUtil.netStopPlay();
                JniUtil.stopView();
            }
            JniUtil.localReadyPlay(mCrypto,mPath);
            Log.i("123","local factory start play");
            super.play(isSub);
        }

        @Override
        public void stop() {
            super.stop();
            JniUtil.releasePlay();
        }

        @Override
        public int getStreamLen() {
            return JniUtil.netGetStreamLenSomeTime();
        }

        @Override
        public long getFirstTimestamp() {
            return JniUtil.getFirstTimeStamp();
        }

        @Override
        public long getTimestamp() {
            return JniUtil.getTimeStamp();
        }


        @Override
        public int getTotalFrame() {
            return JniUtil.getTotalFrame();
        }

        @Override
        public int getCurFrame() {
            return JniUtil.getCurFrame();
        }

        @Override
        public void setCurFrame(int curFrame) {
            JniUtil.setCurFrame(curFrame);
        }

        @Override
        public int getTotalMsec() {
            return JniUtil.getTotalMsec();
        }

        @Override
        public int getPlayedMsec() {
            return JniUtil.getPlayedMsec();
        }

        @Override
        public void clearStreamBuf() {
            JniUtil.clearStreamBuf();
        }

        @Override
        public int getPos() {
            return JniUtil.getPos();
        }

        @Override
        public void setPos(int pos) {
            JniUtil.setPos(pos);
        }

        @Override
        public void setSpeed(float speed) {
            JniUtil.setPlaySpeed(speed);
        }

        @Override
        public boolean stepLast() {
            return super.stepLast();
        }

        @Override
        public boolean stepNext() {
            return super.stepNext();
        }
    }
}
