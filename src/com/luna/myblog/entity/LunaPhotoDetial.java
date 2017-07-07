package com.luna.myblog.entity;

import java.io.Serializable;

public class LunaPhotoDetial implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private LunaPhoto photo;
	private String img;
	public LunaPhotoDetial(){}
	
	public LunaPhotoDetial(String img) {
		super();
		this.img = img;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public LunaPhoto getPhoto() {
		return photo;
	}

	public void setPhoto(LunaPhoto photo) {
		this.photo = photo;
	}

	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
}
