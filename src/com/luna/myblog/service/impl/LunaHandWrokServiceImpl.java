package com.luna.myblog.service.impl;

import java.util.List;

import com.luna.myblog.dao.LunaHandWorkDaoI;
import com.luna.myblog.dao.impl.LunaHandWorkDaoImpl;
import com.luna.myblog.entity.LunaHandWork;
import com.luna.myblog.entity.Pager;
import com.luna.myblog.service.LunaHandWrokService;

public class LunaHandWrokServiceImpl implements LunaHandWrokService{
	LunaHandWorkDaoI lunaHandWorkDao = new LunaHandWorkDaoImpl();
	@Override
	public List<LunaHandWork> queryDanceByPage(Pager page) {
		List<LunaHandWork> lunaList = lunaHandWorkDao.queryLunaHandWorkPage(page);
		return lunaList;
	}

	@Override
	public Integer totalPage() {
		return lunaHandWorkDao.totalPage();
	}

	@Override
	public void addld(LunaHandWork lunaHandWrok) {
		lunaHandWorkDao.addLunaHandWork(lunaHandWrok);
		
	}

	

	@Override
	public List<LunaHandWork> queryAllDance() {
		List<LunaHandWork> list = lunaHandWorkDao.queryAll();
		return list;
	}

	@Override
	public void deleteById(Integer id) {
		LunaHandWork lunaHandWork = lunaHandWorkDao.query(id);
		lunaHandWorkDao.deleteLunaHandWork(lunaHandWork);
		
	}

}
