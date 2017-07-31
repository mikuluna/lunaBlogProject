package com.luna.myblog.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.luna.myblog.entity.LunaDance;
import com.luna.myblog.entity.LunaPhoto;
import com.luna.myblog.entity.LunaPhotoDetial;
import com.luna.myblog.entity.Pager;
import com.luna.myblog.service.LunaPhotoService;
import com.luna.myblog.tool.UploadFile;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

@Controller
public class LunaPhotoAction {
	@Autowired
	private LunaPhotoService lunaPhotoService;
	
	@RequestMapping("/getLunaPhoto")
	public void getLunaPhoto(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		Integer currentPage = Integer.parseInt(request.getParameter("currentPage"));
		Pager page = new Pager();
		page.setCurPage(currentPage);
		page.setPageSize(6);
		page.setTotalPage(lunaPhotoService.totalPage());
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"lunaphodet"});
		List<LunaPhoto> ludanList = lunaPhotoService.queryPhotoByPage(page);
		JSONArray lunaJson = JSONArray.fromObject(ludanList,jsonConfig);
		System.out.println(lunaJson.toString());
		try {
			response.getWriter().print(lunaJson);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	@RequestMapping("/upPhoto")
	public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("uploadPhoto", "lunaPhoto", new LunaPhoto());
        return modelAndView;
    }
	
	@RequestMapping("/uploadPhoto")
	public ModelAndView uploadPhoto(LunaPhoto lunaPhoto, HttpServletRequest request,@RequestParam("file") MultipartFile []files) throws IllegalStateException, IOException{
		ModelAndView modelAndView = new ModelAndView("uploadPhoto");
		Date date = new Date();
		lunaPhoto.setTime(date.toLocaleString());
		List<String> fileNames =UploadFile.uploadFileList(files, request);
		lunaPhoto.setImgFace(fileNames.get(0));
		for(String fileName:fileNames){
			LunaPhotoDetial lundetial = new LunaPhotoDetial();
			lundetial.setImg(fileName);
			lunaPhoto.getLunaphodet().add(lundetial);
		}
		lunaPhotoService.addld(lunaPhoto);
		return modelAndView;
	}
}
