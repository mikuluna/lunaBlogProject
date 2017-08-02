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
import com.luna.myblog.service.LunaLogService;

import net.sf.json.JSONArray;

@Controller
public class LunaLogAction {
	@Autowired
	private LunaLogService lunaLogService;
	@RequestMapping("/getLunaLog")
	public void getLunaLog(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Integer currentPage = Integer.parseInt(request.getParameter("currentPage"));
		Pager page = new Pager();
		page.setCurPage(currentPage);
		page.setPageSize(4);
		page.setTotalPage(lunaLogService.totalPage());
		List<LunaLog> lunaLoglist = lunaLogService.queryLearnNoteByPage(page);
		JSONArray lunaJson = JSONArray.fromObject(lunaLoglist);
		response.getWriter().print(lunaJson);
	}
	@RequestMapping("/upLearnLog")
	public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("uploadlog", "lunalog", new LunaLog());
        return modelAndView;
    }
	@RequestMapping("/getLogDetial")
	public void getLearnNoteDetial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("id"));
		LunaLog lunaLog = lunaLogService.queryById(id);
		request.setAttribute("lunaLog", lunaLog);
		request.getRequestDispatcher("view/frontview/logDetial.jsp").forward(request, response);
	}
	@RequestMapping("/uploadLog")
	public ModelAndView uploadLog(LunaLog lunaLog, HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("uploadlog");
		Date date = new Date();
		lunaLog.setTime(date.toLocaleString());
		lunaLogService.addld(lunaLog);
		return modelAndView;
	}
	@RequestMapping("/upIndexLog")
	public String upIndexLearnLog(Model model){
		List<LunaLog> luLogList = lunaLogService.queryAllLog();
		model.addAttribute("luLogList", luLogList);
		return "/query/queryLog";
	}
	@RequestMapping("/deleteLog")
	public String deleteLog(Model model,HttpServletRequest request) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("id"));
		LunaLog lunaLog = lunaLogService.queryById(id);
		System.out.println(lunaLog.getTitle());
		lunaLogService.deleteById(id);
		List<LunaLog> luLogList = lunaLogService.queryAllLog();
		model.addAttribute("luLogList", luLogList);
		return "/query/queryLog";
	}
	
	

	

	public LunaLogService getLunaLogService() {
		return lunaLogService;
	}

	public void setLunaLogService(LunaLogService lunaLogService) {
		this.lunaLogService = lunaLogService;
	}
	
	
	
	
	
	
}
