package com.luna.myblog.tool;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
					String realPath = request.getSession().getServletContext().getRealPath("/") + "lunaimg/";
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
	/**
     * 批量上传文件 返回值为文件的新名字 UUID.randomUUID()+originalFilename
     * @param multipartFiles
     * @param request
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    public static List<String> uploadFileList(MultipartFile multipartFiles[], HttpServletRequest request) throws IllegalStateException, IOException {
        List<String>newFileNames=new ArrayList<String>();
   
            for(MultipartFile multipartFile:multipartFiles){
                //文件的原始名称
                String originalFilename=multipartFile.getOriginalFilename();
                String newFileName=null;
                if (multipartFile!=null&&originalFilename!=null&&originalFilename.length()>0){

//                    newFileName= UUID.randomUUID()+originalFilename;
                    newFileName=String.valueOf(System.currentTimeMillis()) + originalFilename;
                    //存储图片的物理路径
                    String pic_path = request.getSession().getServletContext().getRealPath("/lunaimg/photos");
                    //新图片路径
                    File targetFile = new File(pic_path, newFileName);
                    //内存数据读入磁盘
                    multipartFile.transferTo(targetFile);
                    newFileNames.add(newFileName);
                }

        }
        return newFileNames;
    }
    public static boolean deleteFile(String fileName){
    	   File file = new File(fileName);
    	   if (file.isFile() && file.exists()) {
    	  file.delete();//"删除单个文件"+name+"成功！"
    	  return true;
    	   }//"删除单个文件"+name+"失败！"
    	   return false;
    	  }
    public static boolean deleteFile(String pic_path,String fileName){
 	   File file = new File(pic_path,fileName);
 	   if (file.isFile() && file.exists()) {
 	  file.delete();//"删除单个文件"+name+"成功！"
 	  return true;
 	   }//"删除单个文件"+name+"失败！"
 	   return false;
 	  }
}
