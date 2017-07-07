package com.luna.myblog.mapper;

import java.util.List;

import com.luna.myblog.entity.LunaDance;
import com.luna.myblog.entity.Pager;



/**
 * 
 */
public interface LunaDanceMapper {
	

	//插入lunadance
	public void insertLunaDance(LunaDance lunaDance)throws Exception;
	//删除lunadance
	public void deleteLunaDance(int id) throws Exception;
	//分页查看LunaDance
	public List<LunaDance> queryLunaDanceList(Pager pager) throws Exception;
	//lunaDance总数
	public Integer countLunaDance()throws Exception;
	
	

}
