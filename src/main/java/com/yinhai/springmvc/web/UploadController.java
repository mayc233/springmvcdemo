package com.yinhai.springmvc.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传的控制器
 * @author casper
 * 	1.需要commons-fileupload,commons-io的支持，在pom.xml中配置依赖;
 * 	2.配置文件解析的参数，在springmvc.xml中的第7点；
 * 	出现问题：当上传文件大于文件解析配置的大小，自定义的异常不会起效果，会直接抛出错误；
 * 	目前解决思路：前端提交文件的时候要验证文件的大小，不然后超出大小后，后台直接会出错,利用拦截器的机制，进行文件大小的验证,超大文件出现的时候，直接在拦截器判断就终止掉;  
 */
@RequestMapping("upload")
@Controller
public class UploadController {
	
	@RequestMapping("test")
	public String test(){
		System.out.println("链接到文件上传的页面");
		return "/upload/index";
	}
	
	/**
	 * 文件上传
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("test1")
	public String test1(MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException{
		System.out.println("文件上传....");
		if(!file.isEmpty()){
			System.out.println(file.getOriginalFilename()+" >>> "+file.getName());
			//获取存储文件的路径
			String path = request.getSession().getServletContext().getRealPath("/static/images");
			System.out.println(path);
			String newFileName = UUID.randomUUID()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			
			File newFile = new File(path,newFileName);
			//写到磁盘
			file.transferTo(newFile);
		}else{
			
		}
		return "upload/index";
	}
	
}
