package com.howellsdk.player.ecam;


import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.howell.jni.JniUtil;
import com.howellsdk.api.HWPlayApi;

import com.howellsdk.audio.AudioAction;
import com.howellsdk.net.soap.bean.NATServerRes;
import com.howellsdk.player.HwBasePlay;
import com.howellsdk.player.ecam.bean.CodecBean;
import com.howellsdk.player.ecam.bean.Crypto;
import com.howellsdk.player.ecam.bean.StreamReqContext;
import com.howellsdk.player.ecam.bean.StreamReqIceOpt;
import com.howellsdk.player.turn.TurnFactory;
import com.howellsdk.player.turn.bean.PTZ_CMD;
import com.howellsdk.utils.RxUtil;
import com.howellsdk.utils.ThreadUtil;
import com.howellsdk.utils.Util;

import org.codehaus.jackson.map.util.ISO8601DateFormat;
import org.kobjects.base64.Base64;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.TimeZone;

/**
 * Created by Administrator on 2017/8/22.
 */

public class EcamFactory {
    String mAccount;
    String mUpnpIP;
    int mUpnpPort;
    int mModeType;
    NATServerRes mNAT;
    Random random;
    HWPlayApi.IEcamCB mCB;
    private EcamFactory(String account,String ip,int port,HWPlayApi.IEcamCB cb){
        mAccount = account;
        mUpnpIP = ip;
        mUpnpPort = port;
        mCB = cb;
        random = new Random();
    }
    public EcamProduct create(){
        return new EcamProduct();
    }
    public static final class Builder{
        String account;
        String ip;
        int port;
        int modeType;

        HWPlayApi.IEcamCB cb;
        public Builder setAccount(String account){
            this.account = account;
            return this;
        }
        public Builder setUpnp(String ip,int port){
            this.ip = ip;
            this.port = port;
            return this;
        }
        public Builder setMethodType(int type){
            modeType = type;
            return this;
        }
        public Builder setEcamCB(HWPlayApi.IEcamCB cb){
            this.cb = cb;
            return this;
        }
        public EcamFactory build(){
            return new EcamFactory(account,ip,port,cb);
        }

    }

    public final class EcamProduct extends HwBasePlay{
        boolean isInvited = false;
        boolean mIsPlayBack = false;
        private StreamReqContext fillStreamReqContext(int isPlayBack, long beg, long end, int re_invite, int methodType, int stream){
            Log.e("123","isPlayBack="+isPlayBack+" beg="+beg+" end="+end+" re="+re_invite+" methodtype="+methodType+" stream="+stream);
            if (mCB==null) throw new NullPointerException();
            StreamReqContext streamReqContext = null;
            if (mNAT == null){
                mNAT = mCB.getNATServer();
            }
            if (mNAT == null) return null;
            Log.i("123","mNat="+mNAT.toString());
            NATServerRes.STUNServer s = mNAT.getStunServers().get(0);
            NATServerRes.TURNServer t = mNAT.getTurnServers().get(0);
            StreamReqIceOpt opt = new StreamReqIceOpt(1, s.getIPv4Address(), s.getPort(),
                    t.getIPv4Address(), t.getPort(),
                    0, t.getUsername(), t.getPassword());
            Crypto crypto = new Crypto(1);
            if(methodType == 0){//连接模式  udp+ice
                streamReqContext = new StreamReqContext(isPlayBack,
                        beg, end, re_invite, 1 << 1 | 1 << 2 ,mUpnpIP , mUpnpPort, opt,crypto,0,stream);
                Log.e("streamReqContext", "java stream:"+stream);
                Log.e("streamReqContext", "UpnpIP:"+mUpnpIP+"UpnpPort:"+mUpnpPort);
            }else if(methodType == 2){//ice
//	        	streamReqContext = new StreamReqContext(isPlayBack,
//		                beg, end, re_invite, 1 << 2 ,UpnpIP , UpnpPort, opt);
                streamReqContext = new StreamReqContext(isPlayBack,
                        beg, end, re_invite, 1 << 2 ,mUpnpIP , mUpnpPort, opt,crypto,0,stream);
                Log.e("streamReqContext", "java stream:"+stream);
                Log.e("streamReqContext", "UpnpIP:"+mUpnpIP+"UpnpPort:"+mUpnpPort);
            }
            return streamReqContext;
        }

        private boolean invite(boolean isSub){
            if (mCB==null)throw new NullPointerException("mcb==null");
//            if (isInvited)return true;
            String dilogID = String.valueOf(random.nextInt());
            String localSDP = JniUtil.ecamPrepareSDP();
            String sdpMessage = Base64.encode(localSDP.getBytes());
            String s = mCB.getBase64RemoteSDP(isSub,dilogID,sdpMessage);
            if (s==null)return false;
            Log.i("123","s="+s);
            String remoteSDP = new String(Base64.decode(s));
            Log.i("123","remoteSPD = "+remoteSDP);
            JniUtil.ecamHandleRemoteSDP(dilogID,remoteSDP);
//            isInvited = true;
            return true;
        }

        private boolean ready(int isplayback){
            int auType = JniUtil.ecamGetAudioType();
            Log.i("123","auType="+auType);
            CodecBean codec = new CodecBean();
            codec.setAudioSamples(8000).setVideoCodec(0).setAudioBitwidth(16)
                    .setAudioChannels(1).setAudioCodec(auType);
            return JniUtil.readyPlayTurnLive(codec,isplayback);
        }

        @Override
        public HWPlayApi bindCam() {
            super.bindCam();
            isInvited = false;
            Log.i("123","bindcam ecam init");
            JniUtil.ecamInit(mAccount);

            return this;
        }

        @Override
        public void unBindCam() {
            Log.i("123","unbindcam ecam deinit");
            JniUtil.releasePlay();
            JniUtil.ecamDeinit();
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
        public void play( boolean isSub) {

            mIsPlayBack = false;
            StreamReqContext c = fillStreamReqContext(mIsPlayBack?1:0,0,0,0,0/*mModeType*/,isSub?1:0);
            if (c==null)                {Log.e("123","c==null");mCB.onError(0);return;}
            JniUtil.ecamSetContextObj(c);
            if(!invite(isSub))          {Log.e("123","invite error");mCB.onError(0);return;}
            //ready

            long [] sdpTime = JniUtil.ecamGetSdpTime();
            Log.i("123","sdptime  beg="+sdpTime[0]+"   end="+sdpTime[1]);

            Log.i("123","ready  0");
            if(!ready(0))               {Log.e("123","read error");mCB.onError(0);return;}
            //申请
            Log.i("123","ecamer start");
            if(JniUtil.ecamStart()!=0)  {Log.e("123","start error");mCB.onError(0);return;}
            Log.i("123","play");
            //play
            super.play(isSub);

            //
            int method = JniUtil.ecamGetMethod();
            Log.e("123","~~~~~~~~~method = "+method);
        }

        @Override
        public void playback(final boolean isSub, final String begTime, final String endTime) {
            mIsPlayBack = true;
            long beg = Util.ISODateString2ISODate(begTime).getTime()/1000;
            long end = Util.ISODateString2ISODate(endTime).getTime()/1000;
            StreamReqContext c = fillStreamReqContext(mIsPlayBack?1:0,beg,end,0,0/*mModeType*/,isSub?1:0);
            if (c==null)                    {mCB.onError(0);return;}
            JniUtil.ecamSetContextObj(c);
            if (!invite(isSub))             {mCB.onError(0);return;}
            long sdp[] = JniUtil.ecamGetSdpTime();
            Log.i("123","beg="+beg+"   end="+end+"  sdp beg="+sdp[0]+"   sdp end="+sdp[1]);//// FIXME: 2017/9/1
            mCB.onPlayBackBegEndTime(sdp[0],sdp[1]);
            if(!ready(1))                   {mCB.onError(0);return;}
            if(JniUtil.ecamStart()!=0)      {mCB.onError(0);return;}

            super.playback(isSub,begTime,endTime);
        }

        @Override
        public boolean playPause() {
            return super.playPause();
        }

        @Override
        public void stop() {
            int ret = JniUtil.ecamStop();
            Log.i("123","ecamStop="+ret);
            super.stop();
        }

        @Override
        public void reLink(final boolean isSub, @Nullable final String begTime, @Nullable final String endTime) {
            //// STOP
            ThreadUtil.cachedThreadStart(new Runnable() {
                @Override
                public void run() {
                    stop();
                    JniUtil.ecamDeinit();
                    //play
                    JniUtil.ecamInit(mAccount);
                    play(isSub);
                }
            });

        }

        @Override
        public void playbackReLink(boolean isSub, long beg, long end) {
            super.playbackReLink(isSub, beg, end);
            stop();
            StreamReqContext c = fillStreamReqContext(mIsPlayBack?1:0,beg,end,1,0/*mModeType*/,isSub?1:0);
            if (c==null){mCB.onError(0);return;}
            JniUtil.ecamSetContextObj(c);
//            if(!invite(isSub)){mCB.onError(0);return;}
            if(JniUtil.ecamStart()!=0){mCB.onError(0);return;}
            Log.i("123","ecam Start");
            super.play(isSub);
        }

        @Override
        public boolean getRecordedFiles(String beg, String end ,@Nullable Integer nowPage,@Nullable Integer pageSize) {
            return false;
        }


        @Override
        public boolean ptzControl(PTZ_CMD cmd, int speed, @Nullable Integer presetNo) {
            return false;
        }

        @Override
        public int getStreamLen() {
            return JniUtil.ecamGetStreamLenSomeTime();
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
        public boolean soundSendBuf(byte[] buf, int len) {
            super.soundSendBuf(buf, len);
            return JniUtil.ecamSendAudioData(buf,len)==0?true:false;
        }
    }

}
