package com.luna.myblog.entity;

import java.io.Serializable;

public class LunaLog implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String introduction;
	private String contain;
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
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getContain() {
		return contain;
	}
	public void setContain(String contain) {
		this.contain = contain;
	}
	
}
