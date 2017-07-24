package com.luna.myblog.tool;


import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {
	public static String upload( MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException{
		String trueFileName=null;
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
					trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
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
		return trueFileName;
	}
}
