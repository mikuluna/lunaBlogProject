package com.luna.myblog.service;

import java.util.List;

import com.luna.myblog.entity.LunaDance;
import com.luna.myblog.entity.Pager;

public interface LunaDanceService {
	public List<LunaDance> queryDanceByPage(Pager page);
	public Integer totalPage();
}
