package com.luna.myblog.entity;

import java.io.Serializable;

public class Pager implements Serializable{

	private static final long serialVersionUID = 1L;
	private int curPage; // 当前页
	private int pageSize; // 每页多少行
	private int totalRow; // 共多少行
	private int totalPage; // 共多少页
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRow() {
		return totalRow;
	}
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
