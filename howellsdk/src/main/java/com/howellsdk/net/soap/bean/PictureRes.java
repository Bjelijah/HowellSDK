package com.howellsdk.net.soap.bean;
/**
 * @author 霍之昊 
 *
 * 类说明
 */
public class PictureRes {
	private String result;
	private String pictureID;
	private String picture;
	public PictureRes(String result, String pictureID, String picture) {
		super();
		this.result = result;
		this.pictureID = pictureID;
		this.picture = picture;
	}
	public PictureRes() {
		super();
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getPictureID() {
		return pictureID;
	}
	public void setPictureID(String pictureID) {
		this.pictureID = pictureID;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "PictureRes{" +
				"result='" + result + '\'' +
				", pictureID='" + pictureID + '\'' +
				", picture='" + picture + '\'' +
				'}';
	}
}
