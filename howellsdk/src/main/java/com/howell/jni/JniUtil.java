package com.howell.jni;


import com.howellsdk.player.ap.bean.ApTimeBean;
import com.howellsdk.player.ap.bean.ReplayFile;
import com.howellsdk.player.ecam.bean.StreamReqContext;

public class JniUtil {
	static{
//		System.loadLibrary("jpush");
//		System.loadLibrary("mp4sdk");
		System.loadLibrary("hwtrans");
		System.loadLibrary("hwplay");

		System.loadLibrary("player_jni");

	}
	
	//yuv
	public static native void logEnable(boolean enable);

	public static native void YUVInit();			//初始化
	public static native void YUVDeinit();			//释放内存
	public static native void YUVSetCallbackObject(Object callbackObject, int flag);
	public static native void YUVSetCallbackMethodName(String methodStr, int flag);
	public static native void YUVLock();
	public static native void YUVUnlock();
	public static native void YUVSetEnable();//开始显示YUV数据
	public static native void YUVRenderY();			//渲染Y数据
	public static native void YUVRenderU();			//渲染U数据
	public static native void YUVRenderV();			//渲染V数据

	public static native void YUVsetData(byte [] data,int len,int w,int h);
	public static native void setH264Data(byte [] data,int len,int w,int h,int isI);
	public static native void setHWData(byte [] data,int len);
	public static native byte [] H264toHWStream(byte [] inH264,int inLen,int isI);


	public static native void nativeAudioInit();
	public static native void nativeAudioDeinit();
    public static native void nativeAudioSetCallbackObject(Object o, int flag);
    public static native void nativeAudioSetCallbackMethodName(String str, int flag);
    public static native void nativeAudioBPlayable();
    public static native void nativeAudioStop();		
   
	
	//test
	
	//net & play
	public static native synchronized void netInit();
	public static native synchronized void netDeinit();
	public static native boolean login(String ip);
	public static native boolean loginOut();
	public static native boolean isLogin();
	public static native void setCallBackObj(Object o);
	public static native void setCallBackMethodName(String methodName,int flag);
	public static native boolean readyPlayLive();//use netReadyPlay

	public static native boolean readyPlayTurnLive(Object turnSubScribeAckBean, int isPlayback);
	public static native boolean readyPlayPlayback();//fixme same to readyPlayLive
	public static native void netSetPlayBackTime(ApTimeBean beg, ApTimeBean end);
	public static native boolean netReadyPlay(int isCrypto,int isPlayBack,int slot,int isSub);//isCrypto 0h264 1h265  2h264c  3h265c
	public static native boolean localReadyPlay(int crypto,String path);//
	public static native boolean isNetReady();
	public static native boolean isNetLogin();
	public static native void releasePlay();
	public static native void playView();
	public static native void pauseAndPlayView();
	public static native int isPause();
	public static native void netStopPlay();
	public static native void stopView();
	public static native int netGetStreamLenSomeTime();
	public static native long getFirstTimeStamp();
	public static native long getTimeStamp();
	public static native long getFileLen();
	public static native boolean stepNext();
	public static native boolean stepLast();
	//net ptz
	public static native boolean netPtzMove(int flag);
	public static native boolean netPtzCam(int flag);//0 1 2 3 4stop tele wide far near
	public static native boolean netPtzIris(int flag);//0 stop 1 open
	//net vod
	public static native int netGetVideoListCount(ApTimeBean beg,ApTimeBean end);//获取总录像文件数
	public static native int netGetVideoListPageCount(ApTimeBean beg,ApTimeBean end,int pageSize,int curPageNo);//获取分页 总页数 pageSize:单页文件数  curPageNo当前第几页
	public static native ReplayFile[] netGetVideoListAll(int count);
	public static native ReplayFile[] netGetVideoList(int startCount,int endCount);
	public static native void netCloseVideoList();
	//net set param
	public static native void netSetSystemTime(int year,int month,int day,int hour,int min,int sec,int msec,int dayOfWeek);
	public static native void netSetSystemTimeNow();
	public static native void netRegistAlarm();
	public static native void netUnregistAlarm();

	//local
	public static native void clearStreamBuf();
	public static native int getTotalFrame();
	public static native int getCurFrame();
	public static native void setCurFrame(int curFrame);
	public static native int getTotalMsec();
	public static native int getPlayedMsec();
	public static native long getTotalLen();
	public static native int getPos();
	public static native void setPos(int pos);
	public static native void setPlaySpeed(float speed);
	//transmission
	
	public static native synchronized void transInit();
	public static native synchronized void transSetCallBackObj(Object o, int flag);
	public static native synchronized void transSetCallbackMethodName(String methodName, int flag);
	public static native synchronized void transDeinit();
	public static native synchronized int transConnect(String ip, int port, boolean isUseSSL, int type, String id, String name, String pwd);
	public static native synchronized void transDisconnect();
	public static native synchronized void transSubscribe(String jsonStr, int jsonLen);
	public static native synchronized void transUnsubscribe();
	public static native synchronized void catchPic(String path);
	public static native synchronized int transGetStreamLenSomeTime();
	public static native synchronized void transGetCam(String jsonStr, int jsonLen);
	public static native synchronized void transGetRecordFiles(String jsonStr, int jsonLen);
	public static native synchronized void transSetCrt(String ca, String client, String key);
	public static native synchronized void transSetCrtPaht(String caPath, String clientPath, String keyPath);
	public static native synchronized void transPTZControl(String jsonStr, int jsonLen);

	//turn
	public static native synchronized void turnInputViewData(byte [] data,int len);


	//ecam
	public static native void ecamInit(String account);
	public static native void ecamDeinit();
	public static native void ecamSetCallbackObj(Object obj,int flag);
	public static native void ecamSetContextObj(StreamReqContext obj);
	public static native int ecamGetAudioType();//return:-1:error;0:aac;1:g711u
	public static native String ecamPrepareSDP();
	public static native void ecamHandleRemoteSDP(String dialogID,String remoteSDP);
	public static native int ecamStart();//return:0 ok; -1 :error; -2:timeout
	public static native int ecamStop();
	public static native int ecamGetMethod();//retrun 0:other; 1:turn;2sturn;3:other;-1 error
	public static native long []ecamGetSdpTime();//return long[0]:begtime ,long[1]:endTime;
	public static native int ecamSendAudioData(byte [] bytes,int len);
	public static native int ecamGetStreamLenSomeTime();

	//download
	public static native void downloadInit();
	public static native void downloadDeinit();
	public static native void downloadType(int flag);//0:hw  1:h264
	public static native void downloadSetCallbackObj(Object obj,int flag);
	public static native void downloadSetCallbackMethod(String methodName,int flag);
	public static native void downloadSetAudioCodeVideoCode(int audioCode,int videoCode);
	public static native void downloadEnable(boolean isEnable);

	//util
	public static native void hwFile2H264File(String hwFilePath,String h264FilePath);
	public static native void hwFile2mp4File(String hwFilePath,String mp4FilePath);//no
}
