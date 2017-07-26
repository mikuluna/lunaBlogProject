package com.luna.myblog.service.impl;

import java.util.List;

import com.luna.myblog.dao.LunaLearnNoteDaoI;
import com.luna.myblog.dao.impl.LunaLearnNoteDaoImpl;
import com.luna.myblog.entity.LunaLearnNote;
import com.luna.myblog.entity.Pager;
import com.luna.myblog.service.LunaLearnNoteService;

public class LunaLearnNoteServiceImpl implements LunaLearnNoteService {
	private LunaLearnNoteDaoI lunaLearnNoteDao=new LunaLearnNoteDaoImpl();
	@Override
	public List<LunaLearnNote> queryLearnNoteByPage(Pager page) {
		List<LunaLearnNote> list = lunaLearnNoteDao.queryLearnNotePage(page);
		return list;
	}

	@Override
	public Integer totalPage() {
		return lunaLearnNoteDao.totalPage();
	}

	@Override
	public void addld(LunaLearnNote lunaLearnNote) {
		lunaLearnNoteDao.addLunaLearnNote(lunaLearnNote);

	}

	@Override
	public List<LunaLearnNote> queryAllLearnNote() {
		List<LunaLearnNote> list=lunaLearnNoteDao.queryAll();
		return list;
	}

	@Override
	public void deleteById(Integer id) {
		LunaLearnNote lunaLearnNote=lunaLearnNoteDao.query(id);
		lunaLearnNoteDao.deleteLunaLearnNote(lunaLearnNote);

	}

	@Override
	public LunaLearnNote queryById(Integer id) {
		return lunaLearnNoteDao.query(id);
	}

	public LunaLearnNoteDaoI getLunaLearnNoteDao() {
		return lunaLearnNoteDao;
	}

	public void setLunaLearnNoteDao(LunaLearnNoteDaoI lunaLearnNoteDao) {
		this.lunaLearnNoteDao = lunaLearnNoteDao;
	}

	@Override
	public List<LunaLearnNote> queryLearnNoteByPage(Pager page, Integer zoneId) {
		List<LunaLearnNote> learnNoteList = lunaLearnNoteDao.queryLearnNotePage(page, zoneId);
		return learnNoteList;
	}

	@Override
	public Integer totalPage(Integer zoneId) {
		return lunaLearnNoteDao.totalPage(zoneId);
	}

}
