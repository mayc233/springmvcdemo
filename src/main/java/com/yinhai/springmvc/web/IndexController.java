package com.yinhai.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * 一个springmvc简单的控制器
 * @author casper
 * 控制器的方法的返回类型：
 * 		1.String 逻辑视图的名字     例如 index ---> /WEB-INF/page/index.jsp
 * 		2.ModelAndView 模型视图对象  设置视图的的逻辑名字和模型数据
 * 		3.void
 */
@Controller
public class IndexController {
	
	/**
	 * 1.控制器方法的返回类型为字符串
	 * 访问url:http://localhost:8080/springmvcdemo/index
	 * 链接到index.jsp
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(Model model){
		System.out.println("控制器方法返回参数类型为String");
		//添加数据到页面，页面可以采用el表达式去获取
		model.addAttribute("name","casper");
		//根据配置在springmvc.xml中的前后缀，视图解析器会去查找 /WEB-INF/page/index.jsp的页面
		return "index";
	}
	
	
	/**
	 * 2.控制器方法的返回类型为ModelAndView
	 * 访问url:http://localhost:8080/springmvcdemo/index1
	 * 链接访问index1.jsp
	 */
	@RequestMapping(value="index1",method=RequestMethod.GET)
	public ModelAndView index1(){
		System.out.println("控制器方法返回参数类型为ModelAndView");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index1");   		//设置视图的名字
		modelAndView.addObject("name", "Casper");	//设置的模型的数据
		return modelAndView;
	}
}
