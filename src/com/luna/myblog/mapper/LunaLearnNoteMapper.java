package com.luna.myblog.mapper;

import java.util.List;

import com.luna.myblog.entity.LunaLearnNote;
import com.luna.myblog.entity.Pager;

public interface LunaLearnNoteMapper {
	// 插入lunaLearnNote
	public void insertLunaLearnNote(LunaLearnNote lunaLearnNote) throws Exception;

	// 删除lunaLearnNote
	public void deleteLunaLearnNote(int id) throws Exception;

	// 分页查看lunaLearnNote
	public List<LunaLearnNote> queryLunaLearnNoteList(Pager pager) throws Exception;

	// lunaLearnNote总数
	public Integer countLunaLearnNote() throws Exception;
}
