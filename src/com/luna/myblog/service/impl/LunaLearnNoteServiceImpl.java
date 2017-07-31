package com.luna.myblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luna.myblog.dao.LunaLearnNoteDaoI;
import com.luna.myblog.dao.impl.LunaLearnNoteDaoImpl;
import com.luna.myblog.entity.LunaLearnNote;
import com.luna.myblog.entity.LunaLog;
import com.luna.myblog.entity.Pager;
import com.luna.myblog.service.LunaLearnNoteService;
@Service("lunaLearnNoteService")
public class LunaLearnNoteServiceImpl implements LunaLearnNoteService {
	@Autowired
	private LunaLearnNoteDaoI lunaLearnNoteDao;
	@Override
	public List<LunaLearnNote> queryLearnNoteByPage(Pager page) {
		List<LunaLearnNote> list = lunaLearnNoteDao.findByPage("LunaLearnNote", page, null, null);
		return list;
	}

	@Override
	public Integer totalPage() {
		return lunaLearnNoteDao.totalPage("LunaLearnNote", null, null,5);
	}

	@Override
	public void addld(LunaLearnNote lunaLearnNote) {
		lunaLearnNoteDao.save(lunaLearnNote);

	}

	@Override
	public List<LunaLearnNote> queryAllLearnNote() {
		List<LunaLearnNote> list=lunaLearnNoteDao.findAll();
		return list;
	}
	public List<LunaLearnNote> queryAllLearnNoteByZoneId(Integer zoneId) {
		List<LunaLearnNote> list=lunaLearnNoteDao.findByProperty("LunaLearnNote","zoneId",zoneId);
		return list;
	}

	@Override
	public void deleteById(Integer id) {
		LunaLearnNote lunaLearnNote=(LunaLearnNote) lunaLearnNoteDao.findById(LunaLearnNote.class, id);
		lunaLearnNoteDao.delete("LunaLearnNote",id);

	}

	@Override
	public LunaLearnNote queryById(Integer id) {
		return (LunaLearnNote) lunaLearnNoteDao.findById(LunaLearnNote.class, id);
	}

	
	

	@Override
	public List<LunaLearnNote> queryLearnNoteByPage(Pager page, Integer zoneId) {
		List<LunaLearnNote> learnNoteList = lunaLearnNoteDao.findByPage("LunaLearnNote", page, "zoneId", zoneId);
		return learnNoteList;
	}

	@Override
	public Integer totalPage(Integer zoneId) {
		return  lunaLearnNoteDao.totalPage("LunaLearnNote", "zoneId", zoneId,5);
	}
	
	
	public LunaLearnNoteDaoI getLunaLearnNoteDao() {
		return lunaLearnNoteDao;
	}

	public void setLunaLearnNoteDao(LunaLearnNoteDaoI lunaLearnNoteDao) {
		this.lunaLearnNoteDao = lunaLearnNoteDao;
	}

}
