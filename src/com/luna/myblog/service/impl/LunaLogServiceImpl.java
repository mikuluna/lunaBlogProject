package com.luna.myblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luna.myblog.dao.LunaLogDaoI;
import com.luna.myblog.entity.LunaLog;
import com.luna.myblog.entity.Pager;
import com.luna.myblog.service.LunaLogService;
@Service("lunaLogService")
public class LunaLogServiceImpl implements LunaLogService {
	@Autowired
	private LunaLogDaoI lunaLogDao;
	@Override
	public List<LunaLog> queryLearnNoteByPage(Pager page) {
		
		return lunaLogDao.findByPage("LunaLog", page, null, null);
	}

	@Override
	public Integer totalPage() {
		return lunaLogDao.totalPage("LunaLog", null, null,4);
	}

	@Override
	public void addld(LunaLog lunadance) {
		lunaLogDao.save(lunadance);

	}

	@Override
	public List<LunaLog> queryAllLog() {
		return lunaLogDao.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		LunaLog instance = (LunaLog)lunaLogDao.findById(LunaLog.class, id);
		lunaLogDao.delete(instance);
		

	}

	@Override
	public LunaLog queryById(Integer id) {
		return (LunaLog)lunaLogDao.findById(LunaLog.class, id);
	}
	
	
	
	

	public LunaLogDaoI getLunaLogDao() {
		return lunaLogDao;
	}

	public void setLunaLogDao(LunaLogDaoI lunaLogDao) {
		this.lunaLogDao = lunaLogDao;
	}

	

}
