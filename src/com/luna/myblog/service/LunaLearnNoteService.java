package com.luna.myblog.service;

import java.util.List;

import com.luna.myblog.entity.LunaLearnNote;
import com.luna.myblog.entity.Pager;

public interface LunaLearnNoteService {
	public List<LunaLearnNote> queryLearnNoteByPage(Pager page);
	public Integer totalPage();
	public void addld(LunaLearnNote lunadance);
	public List<LunaLearnNote>queryAllLearnNote();
	public void deleteById(Integer id);
	public LunaLearnNote queryById(Integer id);
	public List<LunaLearnNote> queryLearnNoteByPage(Pager page,Integer zoneId);
	public Integer totalPage(Integer zoneId);
}
