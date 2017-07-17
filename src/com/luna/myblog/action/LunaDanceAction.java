package com.luna.myblog.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.luna.myblog.entity.LunaDance;
import com.luna.myblog.entity.Pager;
import com.luna.myblog.service.LunaDanceService;
import com.luna.myblog.service.impl.LunaDanceServiceImpl;

import net.sf.json.JSONArray;

@Controller
public class LunaDanceAction {
	LunaDanceService lunaDanceService = new LunaDanceServiceImpl();

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping("/uploadDance")
	public void uploadDance(@RequestParam("file") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws IllegalStateException, IOException {
		if (file != null) {// 判断上传的文件是否为空
			String path = null;// 文件路径
			String type = null;// 文件类型
			String fileName = file.getOriginalFilename();// 文件原名称
			type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length())
					: null;
			if (type != null) {// 判断文件类型是否为空
				if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase())
						|| "JPG".equals(type.toUpperCase())) {
					// 项目在容器中实际发布运行的根路径
					String realPath = request.getSession().getServletContext().getRealPath("/") + "upload/";
					// 自定义的文件名称
					String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
					// 设置存放图片文件的路径
					path = realPath + trueFileName;
					System.out.println(path);
					File saveDir = new File(path);
					if (!saveDir.getParentFile().exists())
						saveDir.getParentFile().mkdirs();
					// 转存文件
					file.transferTo(saveDir);
				}
			}
		}

			System.out.println("文件成功上传到指定目录下");
		
	}

}
