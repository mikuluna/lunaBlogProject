package com.luna.myblog.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.luna.myblog.entity.LunaLearnNote;
import com.luna.myblog.entity.LunaLog;
import com.luna.myblog.entity.Pager;
import com.luna.myblog.service.LunaLearnNoteService;
import com.luna.myblog.service.impl.LunaLearnNoteServiceImpl;

import net.sf.json.JSONArray;

@Controller
public class LunaLearnNoteAction {
	@Autowired
	private LunaLearnNoteService lunaLearnNoteService;
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
	public void getLearnNoteDetial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("id"));
		LunaLearnNote lunaLearnNote = lunaLearnNoteService.queryById(id);
		System.out.println(lunaLearnNote.toString());
		request.setAttribute("lunaLearnNote", lunaLearnNote);
		request.getRequestDispatcher("view/frontview/learnNoteDetial.jsp").forward(request, response);
	}
	@RequestMapping("/upLearnNote")
	public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("uploadlearnnote", "learnNote", new LunaLearnNote());
        return modelAndView;
    }
	@RequestMapping("/uploadLearnNote")
	public ModelAndView uploadLearnNote(LunaLearnNote lunaLearnNote, HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("uploadlog");
		Date date = new Date();
		lunaLearnNote.setTime(date.toLocaleString());
		lunaLearnNoteService.addld(lunaLearnNote);
		return modelAndView;
	}
	@RequestMapping("/upIndexLearnNote")
	public String upIndexLearnLog(Model model,HttpServletRequest request){
		String zone = request.getParameter("zoneId");
		List<LunaLearnNote> lulearnnoteList;
		if(zone!=null&&!zone.equals("")){
			Integer zoneId = Integer.parseInt(zone);
			lulearnnoteList=lunaLearnNoteService.queryAllLearnNoteByZoneId(zoneId);
		}else{
		lulearnnoteList = lunaLearnNoteService.queryAllLearnNote();
		}
		model.addAttribute("lulearnnoteList", lulearnnoteList);
		return "/query/queryLearnNote";
	}
	@RequestMapping("/deleteLearnNote")
	public String deleteLog(Model model,HttpServletRequest request) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("id"));
		lunaLearnNoteService.deleteById(id);
		List<LunaLearnNote> lulearnnoteList = lunaLearnNoteService.queryAllLearnNote();
		model.addAttribute("lulearnnoteList", lulearnnoteList);
		return "/query/queryLearnNote";
	}
	
	public LunaLearnNoteService getLunaLearnNoteService() {
		return lunaLearnNoteService;
	}
	public void setLunaLearnNoteService(LunaLearnNoteService lunaLearnNoteService) {
		this.lunaLearnNoteService = lunaLearnNoteService;
	}
	
	
	
	
	
}
