package com.luna.myblog.service;

import java.util.List;

import com.luna.myblog.entity.LunaDance;
import com.luna.myblog.entity.LunaHandWork;
import com.luna.myblog.entity.Pager;

public interface LunaHandWrokService {
	public List<LunaHandWork> queryDanceByPage(Pager page);
	public Integer totalPage();
	public void addld(LunaHandWork lunaHandWrok);
	public List<LunaHandWork>queryAllDance();
	public void deleteById(Integer id);
}
