package com.yinhai.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Restful风格的演示
 * @author casper
 * 
 * 普通方式的传参的方式：xxxxxtest?name=casper
 * restful的风格：xxxxtest/casper/
 */
@RequestMapping("rest")
@Controller
public class RestController {
	
	/**
	 * 1.rest风格的访问的方式
	 *  访问url: http://localhost:8080/springmvcdemo/rest/test/casper/123
	 */
	@RequestMapping("test/{name}/{id}")
	public String test(@PathVariable("name")String name){
		System.out.println("rest风格访问方式......");
		System.out.println(name);
		return "param";
	}
}
