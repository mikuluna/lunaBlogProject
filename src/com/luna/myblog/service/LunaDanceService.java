package com.luna.myblog.service;

import java.util.List;

import com.luna.myblog.entity.LunaDance;
import com.luna.myblog.entity.Pager;

public interface LunaDanceService {
	public List<LunaDance> queryDanceByPage(Pager page);
	public Integer totalPage();
	public void addld(LunaDance lunadance);
	public void deleteLd(LunaDance lunadance);
	public List<LunaDance>queryAllDance();
	public void deleteById(Integer id);
}
