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
	public List<LunaDance> queryDancePage(Pager pager);
	/**
	 * 增加舞蹈
	 * @param ludan
	 * @throws Exception
	 */
	public void addLunaDance(LunaDance ludan);
	
	public int totalPage();
	
	public void deleteLunaDancd(LunaDance ludan);
	public List<LunaDance> queryAll();
	public LunaDance query(Integer id);
}
