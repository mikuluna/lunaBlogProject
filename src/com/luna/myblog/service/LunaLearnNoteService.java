package com.luna.myblog.service;

import java.util.List;

import com.luna.myblog.entity.LunaLearnNote;
import com.luna.myblog.entity.Pager;

public interface LunaLearnNoteService {
	public List<LunaLearnNote> queryDanceByPage(Pager page);
	public Integer totalPage();
	public void addld(LunaLearnNote lunadance);
	public List<LunaLearnNote>queryAllDance();
	public void deleteById(Integer id);
	public LunaLearnNote queryById(Integer id);
}
