package com.luna.myblog.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

import com.luna.myblog.entity.LunaDance;
import com.luna.myblog.entity.Pager;
import com.luna.myblog.service.LunaDanceService;
import com.luna.myblog.service.impl.LunaDanceServiceImpl;
import com.luna.myblog.tool.UploadFile;

import net.sf.json.JSONArray;

@Controller
public class LunaDanceAction {
	@Autowired
	private LunaDanceService lunaDanceService ;
	
	@RequestMapping("/getLunaDance")
	public void getLunaDance(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Integer currentPage = Integer.parseInt(request.getParameter("currentPage"));
		Pager page = new Pager();
		page.setCurPage(currentPage);
		page.setPageSize(9);
		page.setTotalPage(lunaDanceService.totalPage());
		List<LunaDance> ludanList = lunaDanceService.queryDanceByPage(page);
		JSONArray lunaJson = JSONArray.fromObject(ludanList);
		System.out.println(lunaJson.toString());
		try {
			response.getWriter().print(lunaJson);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	@RequestMapping(value = "/updance")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("uploaddance", "lunaDance", new LunaDance());
        return modelAndView;
    }
	
	@RequestMapping(value = "/upIndexDance")
	public String indexDance(Model model) throws ServletException, IOException {
	List<LunaDance> ludanList = lunaDanceService.queryAllDance();
	model.addAttribute("danceList", ludanList);
	return "/query/queryLunaDance";
    }
	@RequestMapping(value = "/deletedance")
	public String deleteDance(HttpServletRequest request,Model model) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("id"));
		LunaDance lunaDance = lunaDanceService.queryById(id);
		lunaDanceService.deleteById(id);
		String fileNamePath = request.getSession().getServletContext().getRealPath("/") + "lunaimg/"+lunaDance.getImgFace();
		UploadFile.deleteFile(fileNamePath);
		List<LunaDance> ludanList = lunaDanceService.queryAllDance();
		model.addAttribute("danceList", ludanList);
		return "/query/queryLunaDance";
	}
	
	@RequestMapping(value="/uploadDance",method=RequestMethod.POST)
	public ModelAndView uploadDance(LunaDance lunaDance,@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
		 ModelAndView modelAndView = new ModelAndView("uploaddance");
		 String trueFileName=UploadFile.upload(file, request);
		 	lunaDance.setImgFace(trueFileName);
			lunaDanceService.addld(lunaDance);
			return modelAndView;
	}
	public LunaDanceService getLunaDanceService() {
		return lunaDanceService;
	}
	public void setLunaDanceService(LunaDanceService lunaDanceService) {
		this.lunaDanceService = lunaDanceService;
	}
	

	
	
	
}
