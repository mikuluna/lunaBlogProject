package com.luna.myblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luna.myblog.dao.LunaPhotoDaoI;
import com.luna.myblog.entity.LunaPhoto;
import com.luna.myblog.entity.Pager;
import com.luna.myblog.service.LunaPhotoService;
@Service("lunaPhotoService")
public class LunaPhotoServiceImpl implements LunaPhotoService {
	@Autowired
	private LunaPhotoDaoI lunaPhotoDao;
	@Override
	public List<LunaPhoto> queryPhotoByPage(Pager page) {
		return lunaPhotoDao.findByPage("LunaPhoto", page, null, null);
	}

	@Override
	public Integer totalPage() {
		Integer count=lunaPhotoDao.totalPage("LunaPhoto", null, null, 6);
		return count;
	}

	@Override
	public void addld(LunaPhoto lunaPhoto) {
		lunaPhotoDao.save(lunaPhoto);

	}

	@Override
	public List<LunaPhoto> queryAllDance() {
		return lunaPhotoDao.findAll();
	}
	@Override
	public LunaPhoto queryById(Integer id) {
		return (LunaPhoto) lunaPhotoDao.findById(LunaPhoto.class, id);
	}
	

	@Override
	public void deleteById(Integer id) {
		LunaPhoto luph = (LunaPhoto) lunaPhotoDao.findById(LunaPhoto.class, id);
		lunaPhotoDao.delete(luph);
	}

	public LunaPhotoDaoI getLunaPhotoDao() {
		return lunaPhotoDao;
	}

	public void setLunaPhotoDao(LunaPhotoDaoI lunaPhotoDao) {
		this.lunaPhotoDao = lunaPhotoDao;
	}

	

}
