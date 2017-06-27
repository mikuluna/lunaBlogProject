package com.luna.myblog.entity;

public class LunaDance {
	//自增长id
	private int id;
	//封面地址
	private String imgFace;
	//舞蹈链接
	private String danceUrl;
	//舞蹈题目
	private String danceTitle;

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
