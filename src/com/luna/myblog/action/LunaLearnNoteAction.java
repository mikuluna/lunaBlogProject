package com.luna.myblog.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luna.myblog.entity.LunaLearnNote;
import com.luna.myblog.entity.Pager;
import com.luna.myblog.service.LunaLearnNoteService;
import com.luna.myblog.service.impl.LunaLearnNoteServiceImpl;

import net.sf.json.JSONArray;

@Controller
public class LunaLearnNoteAction {
	LunaLearnNoteService lunaLearnNoteService = new LunaLearnNoteServiceImpl();
	@RequestMapping("/getAllLearnNote")
	public void getLearnNote(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<LunaLearnNote> lunaLearnNotelist=null;
		Integer currentPage = Integer.parseInt(request.getParameter("currentPage"));
		Integer zoneId = Integer.parseInt(request.getParameter("zoneId"));
		Pager page = new Pager();
		page.setCurPage(currentPage);
		page.setPageSize(5);
		if(zoneId==0){
		page.setTotalPage(lunaLearnNoteService.totalPage());
		lunaLearnNotelist = lunaLearnNoteService.queryLearnNoteByPage(page);
		}
		else{
			page.setTotalPage(lunaLearnNoteService.totalPage(zoneId));
			lunaLearnNotelist = lunaLearnNoteService.queryLearnNoteByPage(page,zoneId);
		}
		JSONArray lunaJson = JSONArray.fromObject(lunaLearnNotelist);
		System.out.println(lunaJson);
		response.getWriter().print(lunaJson);
	}
	@RequestMapping("/getLearnNoteDetial")
	public String getLearnNoteDetial(HttpServletRequest request, HttpServletResponse response){
		Integer currentPage = Integer.parseInt(request.getParameter("currentPage"));
		return "learnNoteDetial";
	}
}
