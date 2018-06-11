package com.howellsdk.player.turn.utils;


import android.util.Log;

import com.howellsdk.player.turn.bean.Subscribe;
import com.howellsdk.player.turn.bean.TurnConnectAckBean;
import com.howellsdk.player.turn.bean.TurnConnectBean;
import com.howellsdk.player.turn.bean.TurnDisConnectAckBean;
import com.howellsdk.player.turn.bean.TurnDisConnectBean;
import com.howellsdk.player.turn.bean.TurnDisSubscribeAckBean;
import com.howellsdk.player.turn.bean.TurnDisSubscribeBean;
import com.howellsdk.player.turn.bean.TurnGetCamAckBean;
import com.howellsdk.player.turn.bean.TurnGetCamBean;
import com.howellsdk.player.turn.bean.TurnGetRecordedFileAckBean;
import com.howellsdk.player.turn.bean.TurnGetRecordedFilesBean;
import com.howellsdk.player.turn.bean.TurnPtzCtrlAckBean;
import com.howellsdk.player.turn.bean.TurnPtzCtrlBean;
import com.howellsdk.player.turn.bean.TurnSubScribe;
import com.howellsdk.player.turn.bean.TurnSubScribeAckBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * turn protocol json util<br/>
 * most turn protocol has been packed in libhwtrans.so,but you also can send protocol direct with Struct head plus jsonString to turn server;
 * more information {@see "皓维流转发服务协议.doc"}
 * @author howell
 */
public class TurnJsonUtil {
	public static String getTurnConnectJsonStr(TurnConnectBean bean){
		JSONObject object = null;
		
		object = new JSONObject();
		
		try {
			object.put("type", bean.getType());
			object.put("device_id", bean.getDeviceId());
			object.put("username", bean.getUserName());
			object.put("password", bean.getPassWord());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return object.toString();
	}
	
	public static String getTurnSubScribe(TurnSubScribe bean){
		JSONObject object = null;
		object = new JSONObject();
		try {
			object.put("session_id", bean.getSessionId());
			object.put("topic", bean.getTopic());
			JSONObject media = new JSONObject();
			media.put("dialog_id", bean.getMedia().getDialogId());
			JSONObject meta = new JSONObject();
			meta.put("device_id", bean.getMedia().getMeta().getDeviceId());
			String mode =  bean.getMedia().getMeta().getMode();
			meta.put("mode",mode);
			meta.put("channel", bean.getMedia().getMeta().getChannel());
			meta.put("stream", bean.getMedia().getMeta().getStream());
			if ("playback".equals(mode)) {
				meta.put("begin", bean.getMedia().getMeta().getBegin());
				meta.put("end", bean.getMedia().getMeta().getEnd());
			}
			media.put("meta", meta);
			object.put("media", media);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return object.toString();
	}
	
	public static TurnConnectAckBean getTurnConnectAckFromJsonStr(String jsonStr){
		JSONObject obj = null;
		int code = 0;
		String sessionId = null;
		String detail = null;
		try {
			obj = new JSONObject(jsonStr);
			code = obj.getInt("code");
			if (code!=200) {
				detail = obj.getString("detail");
			}else{
				sessionId = obj.getString("session_id");
			}
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
		return new TurnConnectAckBean(code, sessionId,detail);
	}
	
	public static String getTurnDisconnectJsonStr(TurnDisConnectBean bean){
		JSONObject object = null;
		object = new JSONObject();
		try {
			object.put("session_id", bean.getSessionId());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object.toString();
	}
	
	public static TurnDisConnectAckBean getTurnDisconnectAckFromJsonStr(String jsonStr){
		int code = 0;
		String detail = null;
		JSONObject obj = null;
		
		try {
			obj = new JSONObject(jsonStr);
			code = obj.getInt("code");
			if (code!=200) {
				detail = obj.getString("detail");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new TurnDisConnectAckBean(code, detail);
	}
	
	public static String getSubScribeJsonStr(Subscribe subscribe){

		JSONObject object = null;

		object = new JSONObject();
		try {
			object.put("session_id", subscribe.getSessionId());
			object.put("topic", "media");

			JSONObject childchild = null;
			childchild = new JSONObject();
			childchild.put("device_id", subscribe.getDeviceId());
			childchild.put("mode", subscribe.getMode());
			childchild.put("channel", 0);
			childchild.put("stream", subscribe.getIs_sub());
			if(subscribe.getStartTime()!=null && subscribe.getEndTime()!=null){
				childchild.put("begin", subscribe.getStartTime());
				childchild.put("end", subscribe.getEndTime());
			}

			JSONObject child = null;
			child = new JSONObject();
			child.put("dialog_id", subscribe.getDialogId());
			child.put("meta", childchild);

			object.put("media", child);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object.toString();
	}
	
	public static TurnSubScribeAckBean getTurnSubscribeAckFromJsonStr(String jsonStr){
		int code = 0;
		String subscribeId = null;
		String detail = null;
		JSONObject obj = null;
		try {
			obj = new JSONObject(jsonStr);
			code = obj.getInt("code");
			if (code!=200) {
				detail = obj.getString("detail");
			}else{
				subscribeId = obj.getString("subscribe_id");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return new TurnSubScribeAckBean(code, subscribeId, detail);
	}

	/**
	 * get subscribe result from json String
	 * @param jsonStr {@see "皓维流转发服务协议.doc"}
	 * @return {@link TurnSubScribeAckBean}
	 */
	public static TurnSubScribeAckBean getTurnSubscribeAckAllFromJsonStr(String jsonStr){
		TurnSubScribeAckBean bean = new TurnSubScribeAckBean();
		int code = 0;
		String subscribeID = null;
		String detail = null;
		JSONObject obj = null;
		JSONObject mediaObj = null;
		int dialogID = 0;
		JSONObject metaObj = null;
		String deviceID = null;
		String mode = null;
		int channel = 0;
		int stream = 0;
		JSONObject videoObj = null;
		int [] resolution = new int[2];
		int frameRate = 0;
		String bitctrl = null;
		int bitrate = 0;
		int gop = 0;
		String videoCodec = null;
		JSONObject audioObj = null;
		int samples = 0;
		int channels = 0;
		int bitwidth = 0;
		String audioCodec = null;
		boolean keyFrameIndex = false;
		try {
			obj = new JSONObject(jsonStr);
			code = obj.getInt("code");
			if (code!=200){
				detail = obj.getString("detail");
				bean.setCode(code);
				bean.setDetail(detail);
			}else{
				subscribeID = obj.getString("subscribe_id");
				mediaObj = obj.getJSONObject("media");
				dialogID = mediaObj.getInt("dialog_id");
				metaObj = mediaObj.getJSONObject("meta");
				deviceID = metaObj.getString("device_id");
				mode = metaObj.getString("mode");
				channel = metaObj.getInt("channel");
				stream = metaObj.getInt("stream");
				videoObj = metaObj.getJSONObject("video");
				JSONArray arr = videoObj.getJSONArray("resolution");
				resolution[0] = arr.getInt(0);
				resolution[1] = arr.getInt(1);
				frameRate = videoObj.getInt("frame_rate");
				bitctrl = videoObj.getString("bitctrl");
				bitrate = videoObj.getInt("bitrate");
				gop = videoObj.getInt("gop");
				videoCodec = videoObj.getString("codec");

				try {
					audioObj = metaObj.getJSONObject("audio");
					samples = audioObj.getInt("samples");
					channels = audioObj.getInt("channels");
					bitwidth = audioObj.getInt("bitwidth");
					audioCodec = audioObj.getString("codec");
				}catch (Exception ex){
					samples=8000;
					channels = 1;
					bitwidth = 16;
					audioCodec="G711";
				}
				keyFrameIndex = metaObj.getBoolean("key_frame_index");

				//set
				bean.setCode(code);
				bean.setSubscribeId(subscribeID);
				bean.setMediaDialogID(dialogID);
				bean.setDeviceID(deviceID);
				bean.setMode(mode);
				bean.setChannel(channel);
				bean.setStream(stream);
				bean.setVideoResolution(resolution);
				bean.setVideoFrameRate(frameRate);
				bean.setVideoBitctrl(bitctrl);
				bean.setVideoBitrate(bitrate);
				bean.setVideoGop(gop);

				if (videoCodec.contains("h265")){
					bean.setVideoCodec(videoCodec.contains("encrypt")?3:2);
				}else if(videoCodec.contains("h264")){
					bean.setVideoCodec(videoCodec.contains("encrypt")?1:0);
				}else {
					bean.setVideoCodec(0);
				}
//				bean.setVideoCodec(1);//FIXME just for test hwplay.so
				bean.setAudioSamples(samples);
				bean.setAudioChannels(channels);
				bean.setAudioBitwidth(bitwidth);

				if (audioCodec.contains("aac")){
					bean.setAudioCodec(0);
				}else if(audioCodec.contains("711")){
					bean.setAudioCodec(1);
				}
				bean.setKeyFrameIndex(keyFrameIndex);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return bean;
	}




	public static String getTurnDisSubscribeJsonStr(TurnDisSubscribeBean bean){
		JSONObject obj = new JSONObject();
		try {
			obj.put("session_id", bean.getSessionId());
			obj.put("subscribe_id", bean.getSubScribeId());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj.toString();
		
	}
	
	public static TurnDisSubscribeAckBean getTurnDisSubscribeAckFromJsonStr(String jsonStr){
		int code = 0;
		String detail = null;
		JSONObject obj = null;
		try {
			obj = new JSONObject(jsonStr);
			code = obj.getInt("code");
			if (code!=200) {
				detail = obj.getString("detail");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return new TurnDisSubscribeAckBean(code, detail);
	}
	
	public static String getTurnCamJsonStr(TurnGetCamBean bean){

		JSONObject object = null;

		object = new JSONObject();
		try {
			object.put("username", bean.getUserName());
			object.put("password", bean.getPassword());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return object.toString();
	}
	
	public static TurnGetCamAckBean getTurnCamFromJsonStr(String jsonStr){
		Log.i("123","~~~~~~jsonStr="+jsonStr);
		JSONObject obj = null;
		int code = 0;
		String detail = null;
		int cameraCount = 0;
		ArrayList<TurnGetCamAckBean.Camera> cameras=null;
		try {
			obj = new JSONObject(jsonStr);
			code = obj.getInt("code");
			if (code!=200) {
				detail = obj.getString("detail");
			}else{
				cameraCount = obj.getInt("camera_count");
				cameras = new ArrayList<>();


				JSONArray array =  obj.getJSONArray("camera");
				for(int i=0;i<cameraCount;i++){
					JSONObject child = array.getJSONObject(i);
					String deviceId = child.getString("device_id");
					int channel = child.getInt("channel");
					String name = child.getString("name");
					TurnGetCamAckBean.Camera camera = new TurnGetCamAckBean.Camera();
					camera.setDeviceID(deviceId);
					camera.setChannel(channel);
					camera.setName(name);
					cameras.add(camera);
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return new TurnGetCamAckBean(code, cameraCount, detail, cameras);
	}
	
	public static String getTurnRecordFilesJsonStr(TurnGetRecordedFilesBean bean){

		JSONObject object = null;
		object = new JSONObject();

		try {
			object.put("device_id", bean.getDeviceId());
			object.put("channel", bean.getChannel());
			object.put("begin", bean.getBegin());
			object.put("end", bean.getEnd());
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return object.toString();
	}
	
	
	public static TurnGetRecordedFileAckBean getTurnRecordAckFromJsonStr(String jsonStr){
		JSONObject obj = null;
		int code = 0;
		String detail = null;
		String deviceId = null;
		int channel = 0;
		int recordedFileCount = 0;
		ArrayList<TurnGetRecordedFileAckBean.RecordedFile> recordedFiles = new ArrayList<>();
		try {
			obj = new JSONObject(jsonStr);
			code = obj.getInt("code");
			if (code!=200) {
				detail = obj.getString("detail");
			}else{
				deviceId = obj.getString("device_id");
				channel = obj.getInt("channel");
				recordedFileCount = obj.getInt("recordedfile_count");
//				Log.i("123","coutn="+recordedFileCount);

				JSONArray array = obj.getJSONArray("recordedfile");
				for(int i=0;i<recordedFileCount;i++){
					JSONObject child = array.getJSONObject(i);
					String begin = child.getString("begin");
					String end = child.getString("end");
					recordedFiles.add(new TurnGetRecordedFileAckBean.RecordedFile(begin,end));
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}catch (NullPointerException e){
			e.printStackTrace();
		}
		return new TurnGetRecordedFileAckBean(code, detail, deviceId, channel, recordedFileCount, recordedFiles);
	}
	
	public static String getTurnPtzJsonStr(TurnPtzCtrlBean bean){
		JSONObject object = null;

		object = new JSONObject();
		try {
			object.put("session_id", bean.getSessionId());
			object.put("device_id", bean.getDeviceId());
			object.put("channel", bean.getChannel());
			object.put("ptz_command", bean.getPtzCmd());
			object.put("speed", bean.getSpeed());
			
			if (bean.getPresetNo()!=-1) {
				object.put("preset_no",bean.getPresetNo());
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return object.toString();
	}
	
	public static TurnPtzCtrlAckBean getTurnPtzAckFromJsonStr(String jsonStr){
		int code = 0;
		String detail = null;
		try {
			JSONObject obj = new JSONObject(jsonStr);
			code = obj.getInt("code");
			if (code!=200) {
				detail = obj.getString("detail");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return new TurnPtzCtrlAckBean(code, detail);
	}


	@Deprecated
	public static String subScribeJson(Subscribe subscribe){

		JSONObject object = null;

		object = new JSONObject();
		try {
			object.put("session_id", subscribe.getSessionId());
			object.put("topic", "media");

			JSONObject childchild = null;
			childchild = new JSONObject();
			childchild.put("device_id", subscribe.getDeviceId());
			childchild.put("mode", subscribe.getMode());
			childchild.put("channel", 0);
			childchild.put("stream", subscribe.getIs_sub());
			if(subscribe.getStartTime()!=null && subscribe.getEndTime()!=null){
				childchild.put("begin", subscribe.getStartTime());
				childchild.put("end", subscribe.getEndTime());
			}

			JSONObject child = null;
			child = new JSONObject();
			child.put("dialog_id", subscribe.getDialogId());
			child.put("meta", childchild);

			object.put("media", child);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object.toString();
	}

}
