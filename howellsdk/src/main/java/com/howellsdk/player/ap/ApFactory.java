package com.howellsdk.player.ap;

import android.support.annotation.Nullable;
import android.util.Log;

import com.howell.jni.JniUtil;
import com.howellsdk.api.HWPlayApi;
import com.howellsdk.audio.AudioAction;

import com.howellsdk.player.HwBasePlay;
import com.howellsdk.player.ap.bean.ApTimeBean;
import com.howellsdk.player.ap.bean.ReplayFile;
import com.howellsdk.player.turn.bean.PTZ_CMD;
import com.howellsdk.utils.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.jar.JarInputStream;

/**
 * Created by Administrator on 2017/9/4.
 */

public class ApFactory {
    String ip;
    int slot;
    int isCrypto;
    HWPlayApi.IAPCamCB cb;
    private ApFactory(String ip,int slot,int isCrypto,HWPlayApi.IAPCamCB cb){
        this.ip = ip;
        this.slot = slot;
        this.isCrypto = isCrypto;
        this.cb = cb;
    }
    public static final class Builder{
        String ip;
        int slot;
        int isCrypto;
        HWPlayApi.IAPCamCB cb;
        public Builder setIP(String ip){
            this.ip = ip;
            return this;
        }
        public Builder setSlot(int slot){
            this.slot = slot;
            return this;
        }
        public Builder setCrypto(int crypto){
            isCrypto = crypto;
            return this;
        }
        public Builder setCallback(HWPlayApi.IAPCamCB cb){
            this.cb = cb;
            return this;
        }

        public ApFactory build(){
            return new ApFactory(ip,slot,isCrypto,cb);
        }
    }
    public HWPlayApi create(){
        return new ApProduct();
    }

    public final class ApProduct extends HwBasePlay{
        boolean lastIsPlayback = false;

        private void onAlarm(int type,String msg){
            cb.onAlarm(type,msg);
        }

        @Override
        public HWPlayApi bindCam() {
            super.bindCam();
            JniUtil.setCallBackObj(this);
            JniUtil.setCallBackMethodName("onAlarm",0);
            return this;
        }

        @Override
        public void unBindCam() {
            JniUtil.netCloseVideoList();
            JniUtil.releasePlay();//释放解码器
            super.unBindCam();
        }

        @Override
        public boolean connect() {
            Log.i("123","login ip="+ip);
            return JniUtil.login(ip);
        }

        @Override
        public boolean disconnect() {

            return JniUtil.loginOut();
        }

        @Override
        public void play(boolean isSub) {
            lastIsPlayback = false;
            if (JniUtil.isNetReady()) {
                JniUtil.netStopPlay();
                JniUtil.stopView();
            }
            JniUtil.netReadyPlay(isCrypto, 0, slot, isSub ? 1 : 0);

            super.play(isSub);
        }

        @Override
        public void playback(boolean isSub, String begTime, String endTime) {
//            ApTimeBean bean[] = phaseTime(begTime,endTime);
//            Log.i("123","ap Factory play back begTime="+begTime+"  endTime="+endTime);
            lastIsPlayback = true;
//            Log.i("123","net set play back time begTime="+begTime+"   endTime="+endTime);
            if (JniUtil.isNetReady()){
                //关掉重开
                Log.i("123","is net ready we close it");
                JniUtil.netStopPlay();
                JniUtil.stopView();
            }else{
                Log.i("123","is not ready we ready it");
            }
            JniUtil.netSetPlayBackTime(new ApTimeBean(begTime,0),new ApTimeBean(endTime,0));
            Log.i("123","ap Factory play back set play back time ");
            JniUtil.netReadyPlay(isCrypto,1,slot,isSub?1:0);
            super.playback(isSub,begTime,endTime);
        }

        @Override
        public boolean playPause() {
            return super.playPause();

        }

        @Override
        public boolean stepNext() {
            return super.stepNext();
        }

        @Override
        public boolean stepLast() {
            return super.stepLast();
        }

        @Override
        public void stop() {
            JniUtil.netStopPlay();
            super.stop();
            JniUtil.releasePlay();
        }

        @Override
        public void reLink(boolean isSub, @Nullable String begTime, @Nullable String endTime) {
            //stop
            Log.i("123","reLink");
            stop();
            //reconnect;
            disconnect();
            connect();
            //play
            if (lastIsPlayback){
                playback(isSub,begTime,endTime);
            }else{
                play(isSub);
            }

        }

        private  ReplayFile[] getRecordedFilesOld(int count,int nowPage,int pageSize){//nowPage from 0;

            int totalPage = count/pageSize;
//            Log.i("123","  getRecordedFilesOld  count="+count+"  nowPage="+nowPage+"  pageSize="+pageSize+ "  totalPage="+totalPage);
            if (count%pageSize!=0)totalPage+=1;
            int start = (count-1)-nowPage*pageSize;
            if (start<0)start=0;
            int end = (count-1)-(nowPage+1)*pageSize;
            if (end<0)end=0;
//            Log.i("123","startCount="+start+" endCount="+end);
            return JniUtil.netGetVideoList(start,end);
        }


        @Override
        public boolean getRecordedFiles(String beg, String end,@Nullable Integer nowPage,@Nullable Integer pageSize) {
            ApTimeBean [] timeBeen = phaseTime(beg,end);
            int count = 0;
            ReplayFile[] replayFiles=null;
            count = JniUtil.netGetVideoListPageCount(timeBeen[0],timeBeen[1],nowPage,pageSize);
            Log.i("123","count="+count);
            if (count>20 || count<0)count = 0;
            if (count==0 || true){//fixme
                count = JniUtil.netGetVideoListCount(timeBeen[0],timeBeen[1]);
                Log.i("123","all  count="+count);
                replayFiles =  getRecordedFilesOld(count,nowPage,pageSize);
            }else{
                Log.i("123","get videoList all");
                replayFiles = JniUtil.netGetVideoListAll(count);
            }
            Log.i("123","length="+replayFiles.length);
            if (replayFiles==null){Log.e("123","replayFiles==null");return false;}
            ArrayList<ReplayFile> lists = new ArrayList<>();
            for (int i=0;i<replayFiles.length;i++){
//                Log.i("123","file="+replayFiles[i]);
                lists.add(replayFiles[i]);
            }

            cb.onRecordFileList(lists);

            return true;
        }

        @Override
        public boolean ptzControl(PTZ_CMD cmd, int speed, @Nullable Integer presetNo) {
            boolean ret = false;
            switch (cmd){
                case ptz_up:
                    ret = JniUtil.netPtzMove(1);
                    break;
                case ptz_down:
                    ret = JniUtil.netPtzMove(2);
                    break;
                case ptz_left:
                    ret = JniUtil.netPtzMove(3);
                    break;
                case ptz_right:
                    ret = JniUtil.netPtzMove(4);
                    break;
                case ptz_stop:
                    ret = JniUtil.netPtzMove(0);
                    break;
                case ptz_lrisOpen:
                    ret = JniUtil.netPtzIris(1);
                    break;
                case ptz_lrisClose:
                    ret = JniUtil.netPtzIris(0);
                    break;
                case ptz_focusFar:
                    ret = JniUtil.netPtzCam(3);
                    break;
                case ptz_focusNear:
                    ret = JniUtil.netPtzCam(4);
                    break;
                case ptz_focusStop:
                case ptz_zoomStop:
                    ret = JniUtil.netPtzCam(0);
                    break;
                case ptz_zoomTele:
                    ret = JniUtil.netPtzCam(1);
                    break;
                case ptz_zoomWide:
                    ret = JniUtil.netPtzCam(2);
                    break;
                default:
                    ret = false;
                    break;
            }
            return ret;
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
        public void setSpeed(float speed) {
            JniUtil.setPlaySpeed(speed);
        }
    }

    private ApTimeBean [] phaseTime(String startTime,String endTime){
        ApTimeBean [] beans = new ApTimeBean[2];
        Date dateStart = null;
        Date dateEnd = null;
        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat(
//                "yyyy-MM-dd'T'HH:mm:ss");
//        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
//
//        try {
//            dateStart = sdf.parse(startTime);
//            dateEnd  = sdf.parse(endTime);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


        dateStart = Util.DateString2Date(startTime);
        dateEnd = Util.DateString2Date(endTime);

        calendar.setTime(dateEnd);
        beans[1] = new ApTimeBean((short) (calendar.get(calendar.YEAR)),(short)(1+calendar.get(calendar.MONTH)),
                (short)(calendar.get(calendar.DAY_OF_WEEK)-1),(short)calendar.get(calendar.DAY_OF_MONTH),
                (short)calendar.get(calendar.HOUR_OF_DAY),(short)calendar.get(calendar.MINUTE),
                (short)calendar.get(calendar.SECOND),(short)calendar.get(calendar.MILLISECOND));
        if (dateStart.getYear()==70){
            calendar.add(Calendar.MONTH,-2);//2 month before
        }else{
            calendar.setTime(dateStart);
        }

        beans[0] = new ApTimeBean((short) (calendar.get(calendar.YEAR)),(short)(1+calendar.get(calendar.MONTH)),
                (short)(calendar.get(calendar.DAY_OF_WEEK)-1),(short)calendar.get(calendar.DAY_OF_MONTH),
                (short)calendar.get(calendar.HOUR_OF_DAY),(short)calendar.get(calendar.MINUTE),
                (short)calendar.get(calendar.SECOND),(short)calendar.get(calendar.MILLISECOND));
        return beans;
    }

    private ApTimeBean phaseTime10Before(String endTime){
        Calendar calendar = Calendar.getInstance();
        Date dateEnd = Util.ISODateString2ISODate(endTime);
        calendar.setTime(dateEnd);
        calendar.add(Calendar.DAY_OF_MONTH,-10);
        return  new ApTimeBean((short) (calendar.get(calendar.YEAR)),(short)(1+calendar.get(calendar.MONTH)),
                (short)(calendar.get(calendar.DAY_OF_WEEK)-1),(short)calendar.get(calendar.DAY_OF_MONTH),
                (short)calendar.get(calendar.HOUR_OF_DAY),(short)calendar.get(calendar.MINUTE),
                (short)calendar.get(calendar.SECOND),(short)calendar.get(calendar.MILLISECOND));
    }
}
