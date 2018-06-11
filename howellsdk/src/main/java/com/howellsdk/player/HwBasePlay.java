package com.howellsdk.player;

import android.support.annotation.Nullable;

import com.howell.jni.JniUtil;
import com.howellsdk.api.HWPlayApi;
import com.howellsdk.audio.AudioAction;
import com.howellsdk.player.turn.bean.PTZ_CMD;

/**
 * Created by Administrator on 2017/9/4.
 */

public class HwBasePlay implements HWPlayApi {
    @Override
    public HWPlayApi bindCam() {
        JniUtil.netInit();
        return this;
    }

    @Override
    public void unBindCam() {
        JniUtil.netDeinit();
    }

    @Override
    public boolean connect() {
        return false;
    }

    @Override
    public boolean disconnect() {
        return false;
    }

    @Override
    public void setUri(String uri) {

    }

    @Override
    public void play(boolean isSub) {
        AudioAction.getInstance().initAudio();
        AudioAction.getInstance().playAudio();
        JniUtil.playView();
    }

    @Override
    public void playback(boolean isSub, String begTime, String endTime) {
        AudioAction.getInstance().initAudio();
        AudioAction.getInstance().playAudio();
        JniUtil.playView();
    }

    @Override
    public boolean playPause() {
        JniUtil.pauseAndPlayView();
        return JniUtil.isPause()==1?true:false;
    }

    @Override
    public boolean isPause() {
        return JniUtil.isPause()==1?true:false;
    }

    @Override
    public void stop() {
        JniUtil.stopView();
        AudioAction.getInstance().stopAudio();
        AudioAction.getInstance().deInitAudio();

    }

    @Override
    public void reLink(boolean isSub, @Nullable String begTime, @Nullable String endTime) {

    }

    @Override
    public void playbackReLink(boolean isSub, long beg, long end) {

    }

    @Override
    public void clearStreamBuf() {

    }

    @Override
    public int getTotalFrame() {
        return 0;
    }

    @Override
    public int getCurFrame() {
        return 0;
    }

    @Override
    public void setCurFrame(int curFrame) {

    }

    @Override
    public int getTotalMsec() {
        return 0;
    }

    @Override
    public int getPlayedMsec() {
        return 0;
    }

    @Override
    public int getPos() {
        return 0;
    }

    @Override
    public void setPos(int pos) {

    }

    @Override
    public void setSpeed(float speed) {

    }

    @Override
    public boolean stepNext() {
        return JniUtil.stepNext();
    }

    @Override
    public boolean stepLast() {
        return JniUtil.stepLast();
    }

    @Override
    public boolean getRecordedFiles(String beg, String end,@Nullable Integer nowPage,@Nullable Integer pageSize) {
        return false;
    }

    @Override
    public boolean ptzControl(PTZ_CMD cmd, int speed, @Nullable Integer presetNo) {
        return false;
    }

    @Override
    public int getStreamLen() {
        return 0;
    }

    @Override
    public long getFirstTimestamp() {
        return 0;
    }

    @Override
    public long getTimestamp() {
        return 0;
    }

    @Override
    public void catchPic(String path) {
        JniUtil.catchPic(path);
    }

    @Override
    public boolean soundSendBuf(byte[] buf, int len) {
        return true;
    }
}
