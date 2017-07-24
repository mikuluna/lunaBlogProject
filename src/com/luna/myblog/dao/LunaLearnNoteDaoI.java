package com.luna.myblog.dao;

import java.util.List;

import com.luna.myblog.entity.LunaDance;
import com.luna.myblog.entity.LunaLearnNote;
import com.luna.myblog.entity.Pager;

public interface LunaLearnNoteDaoI{
	/**
	 * 查看全部每页学习笔记
	 * @param pager
	 * @return
	 */
	public List<LunaLearnNote> queryLearnNotePage(Pager pager);
	/**
	 * 增加学习笔记
	 * @param ludan
	 * @throws Exception
	 */
	public void addLunaLearnNote(LunaLearnNote luln);
	/**
	 * 全部学习笔记总页数
	 * @return
	 */
	public int totalPage();
	/**
	 * 查看分区每页学习笔记
	 * @param pager
	 * @return
	 */
	public List<LunaLearnNote> queryLearnNotePage(Pager pager,Integer zoneId);
	/**
	 * 分区学习笔记总页数
	 * @return
	 */
	public int totalPage(Integer zoneId);
	public void deleteLunaLearnNote(LunaLearnNote luln);
	public List<LunaLearnNote> queryAll();
	public LunaLearnNote query(Integer id);
}
