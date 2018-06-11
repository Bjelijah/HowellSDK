package com.howellsdk.player.turn;


import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import com.howell.jni.JniUtil;
import com.howellsdk.api.HWPlayApi;
import com.howellsdk.audio.AudioAction;
import com.howellsdk.player.HwBasePlay;
import com.howellsdk.player.turn.bean.PTZ_CMD;
import com.howellsdk.player.turn.bean.TurnGetRecordedFilesBean;
import com.howellsdk.player.turn.bean.TurnPtzCtrlBean;
import com.howellsdk.player.turn.bean.TurnSubScribe;
import com.howellsdk.player.turn.utils.TurnJsonUtil;
import com.howellsdk.utils.FileUtil;
import com.howellsdk.utils.SDKDebugLog;
import com.howellsdk.utils.ThreadUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/8/22.
 */

public class TurnFactory {
    String mIP;
    int mPort;
    String mIMEI;
    boolean mIsSSL;
    HWPlayApi.ITurnCB mCb;
    String mName;
    String mPwd;
    Context mContext;
    String mDeviceId;
    int mChannel;
    private TurnFactory(Context context,String ip,int port,boolean ssl
            ,String name,String pwd
            ,String deviceId,int channel
            ,String imei,HWPlayApi.ITurnCB cb){
        mIP = ip;
        mPort = port;
        mIsSSL = ssl;
        mIMEI = imei;
        mCb = cb;
        mName = name;
        mPwd = pwd;
        mContext = context;
        mDeviceId = deviceId;
        mChannel = channel;
    }
    public HWPlayApi create(){
        return new TurnProduct();
    }


    public static final class Builder{
        String ip;
        int port;
        boolean ssl;
        String imei;
        HWPlayApi.ITurnCB cb;
        String name;
        String pwd;
        Context c;
        String deviceID;
        int channel;
        boolean isSub;
        public Builder setIP(String ip){
            this.ip = ip;
            return this;
        }
        public Builder setPort(int port){
            this.port = port;
            return this;
        }
        public Builder setName(String name){
            this.name = name;
            return this;
        }
        public Builder setPwd(String pwd){
            this.pwd = pwd;
            return this;
        }
        public Builder setSSL(boolean isSSL){
            ssl = isSSL;
            return this;
        }
        public Builder setIMEI(String imei){
            this.imei = imei;
            return this;
        }
        public Builder setTurnCallback( HWPlayApi.ITurnCB cb){
            this.cb = cb;
            return this;
        }
        public Builder setContext(Context context){
            c = context;
            return this;
        }
        public Builder setDeviceId(String deviceId){
            this.deviceID = deviceId;
            return this;
        }
        public Builder setChannel(int channel){
            this.channel = channel;
            return this;
        }

        public TurnFactory build(){
            return new TurnFactory(c,ip,port,ssl,name,pwd
                    ,deviceID,channel
                    ,imei,cb);
        }

    }

    public final class TurnProduct extends HwBasePlay{
        private String mSessionID;
        private final String TAG = TurnProduct.class.getName();
        private int dialogId;
        private final int CMD_NONE          = 0x00;
        private final int SUBSCRIBE_PLAY    = 0x01;
        private final int SUBSCRIBE_REPLAY  = 0x02;
        private final int RECORDED_LIST     = 0x10;
        private int mCmdType;
        private String mCmdJsonStr;
        private boolean mIsPlayback;
        private boolean mIsSub;
        private String mBeg,mEnd;
        private void onConnect(String sessionId){
            Log.i("123","onConnect sessid="+sessionId+"  mcmdType="+mCmdType);
            mSessionID=sessionId;
            mCb.onConnect(sessionId);
            switch (mCmdType){
                case SUBSCRIBE_PLAY:
                case SUBSCRIBE_REPLAY:
                    mCmdJsonStr=getSubscribeJsonStr(mSessionID,mDeviceId,mChannel,mIsSub,mBeg,mEnd);
                    Log.i("123","mcmdType="+mCmdType+"    cmd="+mCmdJsonStr);
                    JniUtil.transSubscribe(mCmdJsonStr,mCmdJsonStr.length());
                    break;
                case RECORDED_LIST:
                    Log.i("123","mcmdJsonStr="+mCmdJsonStr);
                    JniUtil.transGetRecordFiles(mCmdJsonStr,mCmdJsonStr.length());
                    break;
                default:
                    Log.e("123","error No CMD mCmdType="+mCmdType);
                    break;
            }
            mCmdType = CMD_NONE;
        }
        private void onDisconnect(){
            Log.i("123","onDisconnect  cmdType="+mCmdType);
            if (mCmdType == SUBSCRIBE_REPLAY){
                ThreadUtil.scheduledThreadStart(new Runnable() {
                    @Override
                    public void run() {
                        taskConnect();
                    }
                },500, TimeUnit.MILLISECONDS);

                return;
            }
            mCb.onDisconnect();
        }
        private void onDisconnectUnexpect(int flag){//0 socket 1 sync  2 packet receive false   3  http !=200
            SDKDebugLog.logE(TAG+":onDisconnectUnexpect","disconnectUnexpect");
            mCb.onDisconnectUnexpect(flag);}
        private void onRecordFileList(String jsonStr){
            mCb.onRecordFileList(TurnJsonUtil.getTurnRecordAckFromJsonStr(jsonStr));
            taskDisconnect();
        }
        private void onSubscribe(String jsonStr){
            Log.i("123","onSubscribe="+jsonStr);
            //ready
            JniUtil.readyPlayTurnLive(TurnJsonUtil.getTurnSubscribeAckAllFromJsonStr(jsonStr),mIsPlayback?1:0);
            JniUtil.playView();
            mCb.onSubscribe(TurnJsonUtil.getTurnSubscribeAckAllFromJsonStr(jsonStr));
            //wait for unsubscribe;
        }
        private void onUnsubscribe(String jsonStr){
            Log.i("123","on Unsubscribe"+jsonStr);
            JniUtil.releasePlay();
            mCb.onUnsubscribe();
            taskDisconnect();
        }

        private int getDialogId(){
            return dialogId++;
        }

        TurnProduct(){

        }

        private void setCrtPath(Context context){
            InputStream ca = getClass().getResourceAsStream("/assets/ca.crt");
            InputStream client = getClass().getResourceAsStream("/assets/client.crt");
            InputStream key = getClass().getResourceAsStream("/assets/client.key");
            String caPath = new String(FileUtil.saveCreateCertificate(ca,"ca.crt",context));
            String clPath = new String(FileUtil.saveCreateCertificate(client,"client.crt",context));
            String keyPath = new String(FileUtil.saveCreateCertificate(key,"client.key",context));
            JniUtil.transSetCrtPaht(caPath,clPath,keyPath);
            try {
                ca.close();
                client.close();
                key.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        private HWPlayApi init(Context context) {
            Log.i("123","~~~~~~~~~~  api init  "+this.hashCode());
            JniUtil.transInit();
            JniUtil.transSetCallBackObj(this, 0);
            JniUtil.transSetCallbackMethodName("onConnect", 0);
            JniUtil.transSetCallbackMethodName("onDisconnect", 1);
            JniUtil.transSetCallbackMethodName("onRecordFileList", 2);
            JniUtil.transSetCallbackMethodName("onDisconnectUnexpect", 3);
            JniUtil.transSetCallbackMethodName("onSubscribe", 4);
            JniUtil.transSetCallbackMethodName("onUnsubscribe", 6);//fixme 5 is no use
            setCrtPath(context);
            return this;
        }

        private void deinit() {
            JniUtil.transSetCallBackObj(null,0);
            JniUtil.transDeinit();

        }


        @Override
        public HWPlayApi bindCam() {
            super.bindCam();
            init(mContext);

            return this;
        }

        @Override
        public void unBindCam() {
            JniUtil.releasePlay();
            deinit();
            super.unBindCam();
        }

        @Override
        public boolean connect() {
            return true;
        }

        @Override
        public boolean disconnect() {
            return true;
        }


        @Override
        public void play(boolean isSub) {
            mIsPlayback = false;
            subscribe(isSub,null,null);
            super.play(isSub);
        }

        @Override
        public void playback(boolean isSub,String begTime, String endTime) {
            mIsPlayback = true;
            subscribe(isSub,begTime,endTime);
            super.playback(isSub,begTime,endTime);
        }

        @Override
        public boolean playPause() {
            return super.playPause();
        }

        @Override
        public void stop() {
            unSubscribe();
            super.stop();
        }

        @Override
        public void reLink(boolean isSub,@Nullable String begTime,@Nullable String endTime) {
            mCmdType = SUBSCRIBE_REPLAY;
            mIsSub = isSub;
            mBeg=begTime;
            mEnd = endTime;
//            mCmdJsonStr = getSubscribeJsonStr(mDeviceId,mChannel,isSub,begTime,endTime);
            JniUtil.stopView();
            unSubscribe();
        }

        @Override
        public boolean getRecordedFiles(String beg, String end,@Nullable Integer nowPage,@Nullable Integer pageSize) {
            Log.i("123","turnFactory getRecordedFiles");
            getRecordedFiles(mDeviceId,mChannel,beg,end);
            return true;
        }

        @Override
        public boolean ptzControl(PTZ_CMD cmd, int speed, @Nullable Integer presetNo) {
            int no = presetNo==null?-1:presetNo;
            ptzControl(mDeviceId,mChannel,cmd,speed,no);
            return true;
        }

        private void taskConnect(){
            Log.i("123","~~~~~~~~~~~task  connect");
            int ret = JniUtil.transConnect(mIP,mPort,mIsSSL,101,mIMEI,mName,mPwd);
            if (ret==-1){
                Log.e("123","transConnect ret="+ret+"  we init and connect again");
                init(mContext);
                JniUtil.transConnect(mIP,mPort,mIsSSL,101,mIMEI,mName,mPwd);
            }
        }

        private void taskDisconnect(){
            Log.i("123","~~~~~~~~~task disconnect");
            JniUtil.transDisconnect();
        }

        private String getSubscribeJsonStr(String session,String deviceId, int channel, boolean isSub, @Nullable String begTime, @Nullable String endTime){
            boolean islive = false;
            if (begTime==null || endTime==null) islive = true;
            TurnSubScribe bean = new TurnSubScribe(
                    session,
                    "media",
                    new TurnSubScribe.media(
                            getDialogId(),
                            new TurnSubScribe.meta(
                                    deviceId,
                                    islive?"live":"playback",
                                    channel,
                                    isSub?1:0,
                                    begTime,
                                    endTime
                            ))
            );
            return  TurnJsonUtil.getTurnSubScribe(bean);
        }

        private void subscribe(boolean isSub, @Nullable String begTime, @Nullable String endTime) {
            mIsSub = isSub;
            mBeg = begTime;
            mEnd = endTime;
//            mCmdJsonStr = getSubscribeJsonStr(deviceId,channel,isSub,begTime,endTime);
//            Log.i("123","subcribe    jsonStr="+mCmdJsonStr);
            mCmdType = SUBSCRIBE_PLAY;
            taskConnect();
        }


        private void unSubscribe() {
            JniUtil.transUnsubscribe();
        }


        private void getRecordedFiles(String deviceId, int channel, String beg, String end) {
            mCmdJsonStr = TurnJsonUtil.getTurnRecordFilesJsonStr(new TurnGetRecordedFilesBean(
                    deviceId,
                    channel,
                    beg,
                    end
            ));
            mCmdType = RECORDED_LIST;
            Log.i("123","getRecFiles  cmd="+mCmdType   +" this="+this.hashCode());
            taskConnect();
        }


        private void ptzControl(String deviceId, int channel, PTZ_CMD cmd, int speed, int presetNo) {
            String str = TurnJsonUtil.getTurnPtzJsonStr(new TurnPtzCtrlBean(
                    mSessionID,
                    deviceId,
                    channel,
                    cmd.getVal(),
                    speed,
                    presetNo
            ));
            JniUtil.transPTZControl(str,str.length());
        }

        @Override
        public int getStreamLen() {
            return JniUtil.transGetStreamLenSomeTime();
        }

        @Override
        public long getFirstTimestamp() {
            return JniUtil.getFirstTimeStamp();
        }

        @Override
        public long getTimestamp() {
            return JniUtil.getTimeStamp();
        }


    }














}
