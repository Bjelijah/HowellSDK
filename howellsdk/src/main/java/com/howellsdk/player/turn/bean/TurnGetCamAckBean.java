package com.howellsdk.player.turn.bean;

import java.util.ArrayList;

public class TurnGetCamAckBean {
	int code;
	int cameraCount;
	String detail;
	ArrayList<Camera> cameras;
	public int getCode() {
		return code;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCameraCount() {
		return cameraCount;
	}

	public void setCameraCount(int cameraCount) {
		this.cameraCount = cameraCount;
	}

	public ArrayList<Camera> getCameras() {
		return cameras;
	}

	public void setCameras(ArrayList<Camera> cameras) {
		this.cameras = cameras;
	}

	

	public TurnGetCamAckBean(int code, int cameraCount, String detail, ArrayList<Camera> cameras) {
		super();
		this.code = code;
		this.cameraCount = cameraCount;
		this.detail = detail;
		this.cameras = cameras;
	}

	@Override
	public String toString() {
		return "TurnGetCamAckBean{" +
				"code=" + code +
				", cameraCount=" + cameraCount +
				", detail='" + detail + '\'' +
				", cameras=" + cameras +
				'}';
	}

	public static class Camera{
		String deviceID;
		int channel;
		String name;
		public String getDeviceID() {
			return deviceID;
		}
		public void setDeviceID(String deviceID) {
			this.deviceID = deviceID;
		}
		public int getChannel() {
			return channel;
		}
		public void setChannel(int channel) {
			this.channel = channel;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Camera(String deviceID, int channel, String name) {
			super();
			this.deviceID = deviceID;
			this.channel = channel;
			this.name = name;
		}

		public Camera() {
		}

		@Override
		public String toString() {
			return "Camera [deviceID=" + deviceID + ", channel=" + channel + ", name=" + name + "]";
		}
		
	} 
}
