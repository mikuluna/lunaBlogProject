package com.luna.myblog.service;

import java.util.List;

import com.luna.myblog.entity.LunaPhoto;
import com.luna.myblog.entity.Pager;

public interface LunaPhotoService {
	public List<LunaPhoto> queryPhotoByPage(Pager page);
	public Integer totalPage();
	public void addld(LunaPhoto lunaPhoto);
	public List<LunaPhoto>queryAllDance();
	public void deleteById(Integer id);
}
