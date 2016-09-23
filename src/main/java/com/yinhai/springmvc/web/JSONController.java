package com.yinhai.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yinhai.springmvc.bean.Goods;

/**
 * Json数据的绑定和JSON数据的返回
 * 结合fastjson一起处理
 * @author casper
 */
@RequestMapping("json")
@Controller
public class JSONController {
	
	/**
	 * 链接去json.jsp页面
	 * 访问url:http://localhost:8080/springmvcdemo/json/test1
	 * @return
	 */
	@RequestMapping("test1")
	public String test1(){
		System.out.println("链接跳转json页面.....");
		return "json";
	}
	
	/**
	 * json数据转成对象的转换 使用@RequestBody
	 * 对象转换成json数据 使用@ResponseBody
	 * @param goods
	 * @return
	 */
	@RequestMapping(value="test2",method=RequestMethod.POST)
	@ResponseBody
	public Goods test2(@RequestBody Goods goods){
		System.out.println("JSON数据转换成对象");
		System.out.println(goods);
		return goods;
	}
}
