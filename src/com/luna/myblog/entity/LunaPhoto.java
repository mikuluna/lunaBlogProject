package com.luna.myblog.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class LunaPhoto implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String intro;
	private String time;
	private String imgFace;
	private Set<LunaPhotoDetial> lunaphodet = new HashSet<LunaPhotoDetial>();

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Set<LunaPhotoDetial> getLunaphodet() {
		return lunaphodet;
	}

	public void setLunaphodet(Set<LunaPhotoDetial> lunaphodet) {
		this.lunaphodet = lunaphodet;
	}

	public String getImgFace() {
		return imgFace;
	}

	public void setImgFace(String imgFace) {
		this.imgFace = imgFace;
	}

}
