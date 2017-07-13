package com.luna.myblog.dao;

import java.util.List;

import com.luna.myblog.entity.LunaPhoto;
import com.luna.myblog.entity.Pager;

public interface LunaPhotoDaoI{
	/**
	 * 查看每页舞蹈
	 * @param pager
	 * @return
	 */
	public List<LunaPhoto> queryLunaPhotoPage(Pager pager);
	/**
	 * 增加舞蹈
	 * @param ludan
	 * @throws Exception
	 */
	public void addLunaPhoto(LunaPhoto lup);
	
	public int totalPage();
	public void deleteLunaPhoto(LunaPhoto lup);
}
