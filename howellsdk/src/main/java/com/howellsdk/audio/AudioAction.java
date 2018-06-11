package com.howellsdk.audio;


import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaRecorder;
import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.NoiseSuppressor;
import android.util.Log;

import com.howell.jni.JniUtil;
import com.howellsdk.utils.ThreadUtil;

public class AudioAction {
	private static AudioAction mInstance = null;
	private AudioAction(){}
	public static AudioAction getInstance(){
		if(mInstance==null){
			mInstance = new AudioAction();
		}
		return mInstance;
	}

	private AudioTrack mAudioTrack;//FIXME
	private byte[] mAudioData;
	private int mAudioDataLength;
	
	private AudioManager mAudioManager = null;
	
	public void initAudio(){
		int buffer_size = AudioTrack.getMinBufferSize(8000, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT);
		mAudioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, 8000, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT, buffer_size*8, AudioTrack.MODE_STREAM);
		mAudioData = new byte[buffer_size*8];
		JniUtil.nativeAudioInit();
		JniUtil.nativeAudioSetCallbackObject(this, 0);
		JniUtil.nativeAudioSetCallbackMethodName("mAudioDataLength", 0);
		JniUtil.nativeAudioSetCallbackMethodName("mAudioData", 1);
		JniUtil.nativeAudioBPlayable();
	}


	public void pauseAudio(){
		if (mAudioTrack==null)return;
		mAudioTrack.pause();
	}

	public void playAudio(){
		if(mAudioTrack==null)return;		
		if(mAudioTrack.getPlayState() != AudioTrack.PLAYSTATE_PLAYING){
			mAudioTrack.play();
		}
		JniUtil.nativeAudioBPlayable();
	}
	
	public void stopAudio(){
		Log.e("123", "~~~~~~~~~~~~~~audio stop");
		JniUtil.nativeAudioStop();
		if(mAudioTrack!=null){
			mAudioTrack.stop();	
		}
	}
	
	public void deInitAudio(){
	
		if(mAudioTrack != null){
			if (mAudioTrack.getPlayState()== AudioTrack.PLAYSTATE_PLAYING){
				mAudioTrack.stop();
			}
			mAudioTrack.release();
			mAudioTrack = null;
		}
		JniUtil.nativeAudioDeinit();
	}

	
	public void audioWrite() {
		//Log.e("123", "audio write  mAudioDataLength="+mAudioDataLength+" dataLen="+mAudioData.length);
		
		//Log.i("123","play state="+	mAudioTrack.getPlayState()+"     1:stop 2:pause 3:play");//1 stop 2 pause 3 play
		mAudioTrack.write(mAudioData,0,mAudioDataLength);
	}    
	
	public void audioSoundMute(Context context, boolean bMute){
		if (mAudioManager == null) {//should just do once otherwise it will never be Unmuted
			mAudioManager =  (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		}
		mAudioManager.setStreamMute(AudioManager.STREAM_MUSIC, bMute);
	}

	public void setStreamVolum(Context context,int vol){//vol  0- 100%
		if (mAudioManager==null){
			mAudioManager =  (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		}
		int max =  mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC,vol*max /100,0);
	}

	public int getStreamVolum(Context context){
		if (mAudioManager==null){
			mAudioManager =  (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		}
		int max = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		int cur = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
		return cur*100/max;
	}


	/**
	 *
	 */
	//google录音类
	private AudioRecord audioRecord;
	private int recBufSize;
	//语音对讲各个参数
	private static final int frequency = 8000;
	private static final int channelConfiguration = AudioFormat.CHANNEL_CONFIGURATION_MONO;
	private static final int audioEncoding = AudioFormat.ENCODING_PCM_16BIT;
	private boolean bAudioRecording = false;
	private AcousticEchoCanceler canceler = null;//回声消除器
	private NoiseSuppressor suppressor = null;//噪声消除器

	public boolean chkNewDev(){
//		return false;
		return android.os.Build.VERSION.SDK_INT >=16;
	}

	private boolean isDeviceSupportCanceler(){
		return AcousticEchoCanceler.isAvailable();
	}


	public boolean initAEC(int audioSession){
		if(canceler!=null){
			return false;
		}
		canceler = AcousticEchoCanceler.create(audioSession);
		suppressor = NoiseSuppressor.create(audioSession);

		try {
			suppressor.setEnabled(true);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(NullPointerException e){
			e.printStackTrace();
		}

		canceler.setEnabled(true);
		return canceler.getEnabled();
	}


	public boolean releaseAEC(){
		if(null == canceler ){
			return false;
		}
		canceler.setEnabled(false);
		canceler.release();
		canceler = null;

		if(null == suppressor){
			return false;
		}
		suppressor.setEnabled(false);
		suppressor.release();
		suppressor = null;
		return true;
	}


	public void initAudioRecord(){//talk activity on create
		recBufSize = AudioRecord.getMinBufferSize(frequency, channelConfiguration, audioEncoding);
		if(chkNewDev()){
			audioRecord = new AudioRecord(MediaRecorder.AudioSource.VOICE_COMMUNICATION, frequency,
					channelConfiguration, audioEncoding, recBufSize);
			//初始化 回声消除器
			if(isDeviceSupportCanceler()){
				initAEC(audioRecord.getAudioSessionId());
			}
		}else{
			audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC, frequency,
					channelConfiguration, audioEncoding, recBufSize);
		}
	}

	public void deInitAudioRecord(){
		stopAudioRecord();
		if(audioRecord!=null){
			if(audioRecord.getRecordingState()== AudioRecord.RECORDSTATE_RECORDING){
				audioRecord.stop();
			}
			audioRecord.release();
			audioRecord = null;
		}
		releaseAEC();
	}

	public interface AudioRecordHelp{
		void sendAudioData(byte [] buf,int len);
	}

	public void startAudioRecord(final AudioRecordHelp h){
		if(bAudioRecording) {
//			Log.i("123","bAudioRecording alreadly  bAudioRecording");
				return;
		}
		bAudioRecording = true;

		ThreadUtil.cachedThreadStart(new Runnable() {
			@Override
			public void run() {
				byte[] buffer = new byte[recBufSize];
				audioRecord.startRecording();//开始录制

				while(bAudioRecording){
					int bufferReadResult = audioRecord.read(buffer, 0, recBufSize);
					//TalkManager.getInstance().setData(buffer, bufferReadResult);//FIXME

//					boolean ret = TalkManager.getInstance().sendVoiceData2Service(buffer, bufferReadResult);
//					boolean ret = JniUtil.nativeAudioSetdata(buffer,bufferReadResult);
//					Log.i("123","buffer readResult="+bufferReadResult);
//					boolean ret = PlayAction.getInstance().soundSendBuf(buffer,bufferReadResult);
					h.sendAudioData(buffer,bufferReadResult);
//					Log.i("123","send ret=   "+ret);
//					if (!ret) {
//						bAudioRecording = false;
//					}
				}

				if(audioRecord!=null){
					audioRecord.stop();
				}
			}
		});


	}

	public void stopAudioRecord(){
		bAudioRecording = false;
	}


	/**
	 * 声音大小
	 */

	private AudioManager mAudioMgr;
	private int mMaxVolume;
	private boolean bMute=false;
	public boolean audioSoundIsMute(){
		return bMute;
	}
	public void initSound(Context context){
		if (mAudioMgr==null) {
			mAudioMgr = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		}
		mMaxVolume = mAudioMgr.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
	}

	public void audioSoundMute(){
		if (mAudioMgr==null)return;
		bMute = true;
		mAudioMgr.setStreamVolume(AudioManager.STREAM_MUSIC,0,0);
	}

	public void audioSoundUnmute(){
		if (mAudioMgr==null)return;
		bMute = false;
		mAudioMgr.setStreamVolume(AudioManager.STREAM_MUSIC,mMaxVolume/2,0);

	}

}
