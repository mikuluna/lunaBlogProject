package com.luna.myblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luna.myblog.dao.LunaHandWorkDaoI;
import com.luna.myblog.dao.impl.LunaHandWorkDaoImpl;
import com.luna.myblog.entity.LunaHandWork;
import com.luna.myblog.entity.LunaLog;
import com.luna.myblog.entity.Pager;
import com.luna.myblog.service.LunaHandWrokService;
@Service("lunaHandWrokService")
public class LunaHandWrokServiceImpl implements LunaHandWrokService{
	@Autowired
	private LunaHandWorkDaoI lunaHandWorkDao;
	@Override
	public List<LunaHandWork> queryDanceByPage(Pager page) {
		List<LunaHandWork> lunaList = lunaHandWorkDao.findByPage("LunaHandWork", page, null, null);
		return lunaList;
	}

	@Override
	public Integer totalPage() {
		return lunaHandWorkDao.totalPage("LunaHandWork", null, null, 6);
	}

	@Override
	public void addld(LunaHandWork lunaHandWrok) {
		lunaHandWorkDao.save(lunaHandWrok);
		
	}

	

	@Override
	public List<LunaHandWork> queryAllDance() {
		List<LunaHandWork> list = lunaHandWorkDao.findAll();
		return list;
	}

	@Override
	public void deleteById(Integer id) {
		LunaHandWork lunaHandWork = (LunaHandWork) lunaHandWorkDao.findById(LunaHandWork.class, id);
		lunaHandWorkDao.delete(lunaHandWork);
		
	}

	public LunaHandWorkDaoI getLunaHandWorkDao() {
		return lunaHandWorkDao;
	}

	public void setLunaHandWorkDao(LunaHandWorkDaoI lunaHandWorkDao) {
		this.lunaHandWorkDao = lunaHandWorkDao;
	}

	
	
}
