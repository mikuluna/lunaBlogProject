package com.luna.myblog.entity;

import java.io.Serializable;

public class LunaLearnNote implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String introduction;
	/**
	 * 1.Java基础
	 * 2.后端框架
	 * 3.SQL
	 * 4.JSP
	 * 5.JavaScript
	 * 6.前端框架
	 * 7.其他
	 */
	private Integer zoneId;
	private String contain;
	private String time;

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

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}


	public Integer getZoneId() {
		return zoneId;
	}

	public void setZoneId(Integer zoneId) {
		this.zoneId = zoneId;
	}

	public String getContain() {
		return contain;
	}

	public void setContain(String contain) {
		this.contain = contain;
	}

}
