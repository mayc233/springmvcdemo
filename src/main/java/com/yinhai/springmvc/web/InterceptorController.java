package com.yinhai.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("inter")
public class InterceptorController {
	
	/**
	 * 访问url:http://localhost:8080/springmvcdemo/inter/test
	 * @return
	 */
	@RequestMapping("test")
	public String test(){
		System.out.println("自定义拦截器测试");
		return "param";
	}
	
	
}	
