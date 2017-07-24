package com.luna.myblog.entity;

import java.io.Serializable;

public class LunaHandWork implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String faceimg;
	private String title;
	private String uploadDate;
	private String handWorkUrl;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFaceimg() {
		return faceimg;
	}
	public void setFaceimg(String faceimg) {
		this.faceimg = faceimg;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getHandWorkUrl() {
		return handWorkUrl;
	}
	public void setHandWorkUrl(String handWorkUrl) {
		this.handWorkUrl = handWorkUrl;
	}
	
}
