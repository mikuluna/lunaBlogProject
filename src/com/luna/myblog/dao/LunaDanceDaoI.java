package com.luna.myblog.dao;

import java.util.List;

import com.luna.myblog.entity.LunaDance;
import com.luna.myblog.entity.Pager;

public interface LunaDanceDaoI{
	/**
	 * 查看每页舞蹈
	 * @param pager
	 * @return
	 */
	public List<LunaDance> queryDancePage(Pager pager)throws Exception;
	/**
	 * 增加舞蹈
	 * @param ludan
	 * @throws Exception
	 */
	public void addLunaDance(LunaDance ludan)throws Exception;
	
	public int totalPage()throws Exception;
}
