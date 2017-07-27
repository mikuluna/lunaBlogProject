package com.luna.myblog.service;

import java.util.List;

import com.luna.myblog.entity.LunaLog;
import com.luna.myblog.entity.Pager;

public interface LunaLogService {
	public List<LunaLog> queryLearnNoteByPage(Pager page);
	public Integer totalPage();
	public void addld(LunaLog lunadance);
	public List<LunaLog>queryAllLog();
	public void deleteById(Integer id);
	public LunaLog queryById(Integer id);
	
}
