package com.luna.myblog.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.luna.myblog.entity.LunaHandWork;
import com.luna.myblog.entity.Pager;
import com.luna.myblog.service.LunaHandWrokService;
import com.luna.myblog.service.impl.LunaHandWrokServiceImpl;
import com.luna.myblog.tool.UploadFile;

import net.sf.json.JSONArray;

@Controller
public class LunaHandWorkAction {
	@Autowired
	private LunaHandWrokService lunaHandWrokService;	
	@RequestMapping("/getLunaHandWork")
	public void getLunaHandWork(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Integer currentPage = Integer.parseInt(request.getParameter("currentPage"));
		Pager page = new Pager();
		page.setCurPage(currentPage);
		page.setPageSize(6);
		page.setTotalPage(lunaHandWrokService.totalPage());
		List<LunaHandWork> lunaHandWorklist = lunaHandWrokService.queryDanceByPage(page);
		JSONArray lunaJson = JSONArray.fromObject(lunaHandWorklist);
		response.getWriter().print(lunaJson);	
	}
	@RequestMapping("upIndexHandWork")
	public String upIndexHandWork( Model model) throws ServletException, IOException{
		List<LunaHandWork> luhandList = lunaHandWrokService.queryAllDance();
		model.addAttribute("luhandList", luhandList);
		return "/query/queryHandWork";
	}
	@RequestMapping("deletehandWork")
	public String deletehandWork(Model model,HttpServletRequest request) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("id"));
		lunaHandWrokService.deleteById(id);
		List<LunaHandWork> luhandList = lunaHandWrokService.queryAllDance();
		model.addAttribute("luhandList", luhandList);
		return "/query/queryHandWork";
	}
	@RequestMapping("/upHandWork")
	public ModelAndView form(){
		 ModelAndView modelAndView = new ModelAndView("uploadhandwork", "lunaHandWork", new LunaHandWork());
	        return modelAndView;
	}
	@RequestMapping(value="/uploadHand",method=RequestMethod.POST)
	public ModelAndView uploadHandWork(LunaHandWork lunaHandWork,@RequestParam("file") MultipartFile file,HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException{
		ModelAndView modelAndView = new ModelAndView("uploadhandwork");
		String trueFileName = UploadFile.upload(file, request);
		lunaHandWork.setFaceimg(trueFileName);
		lunaHandWrokService.addld(lunaHandWork);
		return modelAndView;
	}
	public LunaHandWrokService getLunaHandWrokService() {
		return lunaHandWrokService;
	}
	public void setLunaHandWrokService(LunaHandWrokService lunaHandWrokService) {
		this.lunaHandWrokService = lunaHandWrokService;
	}
	
	
	
}
