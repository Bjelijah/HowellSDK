package com.howellsdk.player.turn.bean;

public class TurnPtzCtrlBean {
	String sessionId;//会话id
	String deviceId;//设备id
	int channel;//通道号
	int ptzCmd;//命令
	int speed;//速度0-255   0停止
	int presetNo;//预置位置0-255
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public int getPtzCmd() {
		return ptzCmd;
	}
	public void setPtzCmd(int ptzCmd) {
		this.ptzCmd = ptzCmd;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getPresetNo() {
		return presetNo;
	}
	public void setPresetNo(int presetNo) {
		this.presetNo = presetNo;
	}
	public TurnPtzCtrlBean(String sessionId, String deviceId, int channel, int ptzCmd, int speed, int presetNo) {
		super();
		this.sessionId = sessionId;
		this.deviceId = deviceId;
		this.channel = channel;
		this.ptzCmd = ptzCmd;
		this.speed = speed;
		this.presetNo = presetNo;
	}

	public TurnPtzCtrlBean(String sessionId, String deviceId, int channel, int ptzCmd, int speed) {
		this.sessionId = sessionId;
		this.deviceId = deviceId;
		this.channel = channel;
		this.ptzCmd = ptzCmd;
		this.speed = speed;
		this.presetNo = -1;
	}

	@Override
	public String toString() {
		return "TurnPtzCtrlBean [sessionId=" + sessionId + ", deviceId=" + deviceId + ", channel=" + channel
				+ ", ptzCmd=" + ptzCmd + ", speed=" + speed + ", presetNo=" + presetNo + "]";
	}
}
