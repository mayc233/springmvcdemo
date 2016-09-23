package com.yinhai.springmvc.web;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 自定义参数类型的绑定
 * @author casper
 *  日期类型
 *  IP地址
 */
@RequestMapping("custom")
@Controller
public class CustomParamController {
	
	/**
	 * 访问url:http://localhost:8080/springmvcdemo/custom/test?date=1993-01-01
	 * @param date
	 * @return
	 */
	@RequestMapping("test")
	public String test(Date date){
		System.out.println("自定义日期类型参数的转换....");
		System.out.println(date);
		return "param";
	}
}
