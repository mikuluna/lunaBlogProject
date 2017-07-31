package com.luna.myblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luna.myblog.dao.LunaDanceDaoI;
import com.luna.myblog.entity.LunaDance;
import com.luna.myblog.entity.LunaLog;
import com.luna.myblog.entity.Pager;
import com.luna.myblog.service.LunaDanceService;
@Service("lunaDanceService")
public class LunaDanceServiceImpl implements LunaDanceService{
	@Autowired
	private LunaDanceDaoI lunaDanceDao;

	@Override
	public List<LunaDance> queryDanceByPage(Pager page) {
		List<LunaDance> lunaList = lunaDanceDao.findByPage("LunaDance", page, null, null);
		return lunaList;
		
	}

	@Override
	public Integer totalPage() {
		
		return lunaDanceDao.totalPage("LunaDance", null, null,9);
	}

	@Override
	public void addld(LunaDance lunadance) {
		lunaDanceDao.save(lunadance);
		
	}



	@Override
	public List<LunaDance> queryAllDance() {
		List<LunaDance> list =lunaDanceDao.findAll();
		return list;
	}
	public void deleteById(Integer id){
		LunaDance lunaDance = (LunaDance) lunaDanceDao.findById(LunaLog.class, id);
		lunaDanceDao.delete(lunaDance);
	}

	public LunaDanceDaoI getLunaDanceDao() {
		return lunaDanceDao;
	}

	public void setLunaDanceDao(LunaDanceDaoI lunaDanceDao) {
		this.lunaDanceDao = lunaDanceDao;
	}


	
}
