package com.luna.myblog.test;

import java.util.List;

import org.junit.Test;

import com.luna.myblog.entity.LunaLearnNote;
import com.luna.myblog.entity.Pager;
import com.luna.myblog.service.LunaLearnNoteService;
import com.luna.myblog.service.impl.LunaLearnNoteServiceImpl;

public class TestDao {

	@Test
	public void testPage() {
		LunaLearnNoteService lunaLearnNoteService = new LunaLearnNoteServiceImpl();
		
		Pager page = new Pager();
		page.setCurPage(2);
		page.setPageSize(5);
		page.setTotalPage(lunaLearnNoteService.totalPage());
		List<LunaLearnNote>lunaLearnNotelist = lunaLearnNoteService.queryLearnNoteByPage(page);
		for(LunaLearnNote lu:lunaLearnNotelist){
			System.out.println(lu.getTitle());
		}
	}

}
