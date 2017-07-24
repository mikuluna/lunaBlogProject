package com.luna.myblog.entity;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class LunaDance implements Serializable{
	private static final long serialVersionUID = 1L;
	//自增长id
	private int id;
	//封面地址
	private String imgFace;
	//舞蹈链接
	private String danceUrl;
	//舞蹈题目
	private String danceTitle;
	
	public LunaDance(){}
	public LunaDance(String imgFace, String danceUrl, String danceTitle) {
		super();
		this.imgFace = imgFace;
		this.danceUrl = danceUrl;
		this.danceTitle = danceTitle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImgFace() {
		return imgFace;
	}

	public void setImgFace(String imgFace) {
		this.imgFace = imgFace;
	}

	public String getDanceUrl() {
		return danceUrl;
	}

	public void setDanceUrl(String danceUrl) {
		this.danceUrl = danceUrl;
	}

	public String getDanceTitle() {
		return danceTitle;
	}

	public void setDanceTitle(String danceTitle) {
		this.danceTitle = danceTitle;
	}
	
	
}
