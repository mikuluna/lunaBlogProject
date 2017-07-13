package com.luna.myblog.dao;

import java.util.List;

import com.luna.myblog.entity.LunaLog;
import com.luna.myblog.entity.Pager;

public interface LunaLogDaoI{
	/**
	 * 查看每页舞蹈
	 * @param pager
	 * @return
	 */
	public List<LunaLog> queryDancePage(Pager pager);
	/**
	 * 增加舞蹈
	 * @param ludan
	 * @throws Exception
	 */
	public void addLunaLog(LunaLog lul);
	
	public int totalPage();
	public void deleteLunaLog(LunaLog lul);
}
