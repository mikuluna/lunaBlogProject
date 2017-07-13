package com.luna.myblog.dao;

import java.util.List;

import com.luna.myblog.entity.LunaHandWork;
import com.luna.myblog.entity.Pager;

public interface LunaHandWorkDaoI{
	/**
	 * 查看每页舞蹈
	 * @param pager
	 * @return
	 */
	public List<LunaHandWork> queryLunaHandWorkPage(Pager pager);
	/**
	 * 增加舞蹈
	 * @param ludan
	 * @throws Exception
	 */
	public void addLunaHandWork(LunaHandWork luhk);
	
	public int totalPage();
	public void deleteLunaHandWork(LunaHandWork luhk);
}
