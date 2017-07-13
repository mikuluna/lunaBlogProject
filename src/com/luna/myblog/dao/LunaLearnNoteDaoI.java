package com.luna.myblog.dao;

import java.util.List;

import com.luna.myblog.entity.LunaLearnNote;
import com.luna.myblog.entity.Pager;

public interface LunaLearnNoteDaoI{
	/**
	 * 查看每页舞蹈
	 * @param pager
	 * @return
	 */
	public List<LunaLearnNote> queryDancePage(Pager pager);
	/**
	 * 增加舞蹈
	 * @param ludan
	 * @throws Exception
	 */
	public void addLunaLearnNote(LunaLearnNote luln);
	
	public int totalPage();
	public void deleteLunaLearnNote(LunaLearnNote luln);
}
