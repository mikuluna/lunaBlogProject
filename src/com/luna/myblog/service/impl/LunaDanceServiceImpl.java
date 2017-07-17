package com.luna.myblog.service.impl;

import java.util.List;

import com.luna.myblog.dao.LunaDanceDaoI;
import com.luna.myblog.dao.impl.LunaDanceDaoImpl;
import com.luna.myblog.entity.LunaDance;
import com.luna.myblog.entity.Pager;
import com.luna.myblog.service.LunaDanceService;

public class LunaDanceServiceImpl implements LunaDanceService{
	LunaDanceDaoI lunaDanceDao = new LunaDanceDaoImpl();

	@Override
	public List<LunaDance> queryDanceByPage(Pager page) {
		List<LunaDance> lunaList = lunaDanceDao.queryDancePage(page);
		return lunaList;
		
	}

	@Override
	public Integer totalPage() {
		
		return lunaDanceDao.totalPage();
	}


}
