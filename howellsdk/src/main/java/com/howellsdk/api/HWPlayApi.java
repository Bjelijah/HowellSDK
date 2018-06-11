package com.howellsdk.api;

import android.support.annotation.Nullable;

import com.howellsdk.net.soap.bean.NATServerRes;
import com.howellsdk.player.ap.bean.ReplayFile;
import com.howellsdk.player.turn.bean.PTZ_CMD;
import com.howellsdk.player.turn.bean.TurnGetRecordedFileAckBean;
import com.howellsdk.player.turn.bean.TurnSubScribeAckBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/25.
 */

public interface HWPlayApi {
    HWPlayApi bindCam();//初始化
    void unBindCam();

    boolean connect();//连接
    boolean disconnect();//断连

    void setUri(String uri);

    void play(boolean isSub);//播放
    void playback(boolean isSub,String begTime,String endTime);
    boolean playPause();
    boolean isPause();
    void stop();//停止
    void reLink(boolean isSub, @Nullable String begTime,@Nullable String endTime);//重连
    void playbackReLink(boolean isSub,long beg,long end);

    //local
    void clearStreamBuf();
    int getTotalFrame();
    int getCurFrame();
    void setCurFrame(int curFrame);
    int getTotalMsec();
    int getPlayedMsec();
    int getPos();
    void setPos(int pos);
    void setSpeed(float speed);
    boolean stepNext();
    boolean stepLast();
    //fun
    boolean getRecordedFiles(String beg,String end,@Nullable Integer nowPage,@Nullable Integer pageSize);
    boolean ptzControl(PTZ_CMD cmd,int speed,@Nullable Integer presetNo);
    int getStreamLen();
    long getFirstTimestamp();
    long getTimestamp();
    void catchPic(String path);
    boolean soundSendBuf(byte [] buf,int len);

    interface ITurnCB{
        void onConnect(String sessionId);
        void onDisconnect();
        void onDisconnectUnexpect(int flag);
        void onRecordFileList(TurnGetRecordedFileAckBean fileList);
        void onSubscribe(TurnSubScribeAckBean res);
        void onUnsubscribe();
    }

    interface IEcamCB{
        String getBase64RemoteSDP(boolean isSub,String dilogID,String sdpMessage);
        NATServerRes getNATServer();
        void onError(int flag);
        void onPlayBackBegEndTime(long beg,long end);
    }

    interface IAPCamCB{
        void onRecordFileList(ArrayList<ReplayFile> files);
        void onAlarm(int type,String msg);
    }

}
