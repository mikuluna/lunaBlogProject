package com.luna.myblog.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
	@RequestMapping("/getPhotoDetial")
	public void getLearnNoteDetial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("id"));
		LunaPhoto lunaPhoto = lunaPhotoService.queryById(id);
		request.setAttribute("lunaPhoto", lunaPhoto);
		System.out.println(lunaPhoto.getLunaphodet().toString());
		request.getRequestDispatcher("view/frontview/photodetial.jsp").forward(request, response);
	}
	
	@RequestMapping("/upPhoto")
	public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("uploadPhoto", "lunaPhoto", new LunaPhoto());
        return modelAndView;
    }
	
	@RequestMapping("/uploadPhoto")
	public ModelAndView uploadPhoto(LunaPhoto lunaPhoto, HttpServletRequest request,@RequestParam("file") MultipartFile []files) throws IllegalStateException, IOException{
		ModelAndView modelAndView = new ModelAndView("uploadPhoto");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		lunaPhoto.setTime(sdf.format(date));
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
	@RequestMapping(value = "/upIndexPhoto")
	public String indexDance(Model model) throws ServletException, IOException {
	List<LunaPhoto> ludanList = lunaPhotoService.queryAllDance();
	model.addAttribute("lunaPhotoList", ludanList);
	return "/query/queryPhoto";
    }
	@RequestMapping(value = "/deletePhoto")
	public String deletePhoto(HttpServletRequest request,Model model) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("id"));
		LunaPhoto lunaphoto = lunaPhotoService.queryById(id);
		Set<LunaPhotoDetial> lpdFiles = lunaphoto.getLunaphodet();
		for(LunaPhotoDetial lpd :lpdFiles){
			String fileNamePath = request.getSession().getServletContext().getRealPath("/lunaimg/photos");
			System.out.println(fileNamePath);
			UploadFile.deleteFile(fileNamePath,lpd.getImg());
		}
		lunaPhotoService.deleteById(id);
		List<LunaPhoto> ludanList = lunaPhotoService.queryAllDance();
		model.addAttribute("lunaPhotoList", ludanList);
		return "/query/queryPhoto";
	}


	public LunaPhotoService getLunaPhotoService() {
		return lunaPhotoService;
	}


	public void setLunaPhotoService(LunaPhotoService lunaPhotoService) {
		this.lunaPhotoService = lunaPhotoService;
	}
	
}
