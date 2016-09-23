package com.yinhai.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author casper
 *	跳转方式：
 *		1.内部跳转（推荐）
 *			1.1页面
 *			1.2控制器	
 *		2.外部跳转（推荐）
 *			2.1页面
 *			2.2控制器
 *		3.javaee的跳转
 *			3.1javaee的外部跳转
 *				3.1.1外部跳转页面
 *				3.1.2外部跳转控制器
 *			3.2javaee内部跳转
 *				3.2.1内部跳转页面
 *				3.2.2内部跳转控制器
 */
@Controller
public class IndexController1 {
	
	/**
	 * 1.1 内部跳转页面
	 * 访问url:http://localhost:8080/springmvcdemo/test1
	 * 注意观察浏览器地址没有发生变化，所以说默认的方式就是内部跳转
	 * @return
	 */
	@RequestMapping(value="test1",method=RequestMethod.GET)
	public String test1(){
		System.out.println("内部跳转页面");
		return "index";
	}
	
	/**
	 * 1.2内部跳转控制器
	 * 访问地址：http://localhost:8080/springmvcdemo/test2
	 */
	@RequestMapping(value="test2",method=RequestMethod.GET)
	public String test2(){
		System.out.println("内部跳转到IndexController控制器的index1访问上");
		return "forward:/index1";   //注意的这里的写法！！！！！！ 不能写成   return "index1";就变内部跳转页面了额！！！！
	}

	
	/**
	 * 2.1外部跳转页面
	 * 访问地址：http://localhost:8080/springmvcdemo/test3
	 * 注意观察浏览器地址变化以及控制台的打印
	 */
	@RequestMapping(value="test3",method=RequestMethod.GET)
	public String test3(){
		System.out.println("外部跳转页面......");
		return "redirect:/index2.jsp";//根目录下的index2页面
	}
	

	/**
	 * 3.1Javaee的内部跳转控制器
	 * 访问url:http://localhost:8080/springmvcdemo/test5
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("test5")
	public void test5(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		//3.1.1跳转页面
		//request.getRequestDispatcher("/WEB-INF/page/index1.jsp").forward(request, response);
		//3.1.2跳转到IndexController的控制器index1方法上
		request.getRequestDispatcher("index1").forward(request, response);
	}
	
	/**
	 * 3.2 javaee的外部跳转
	 * 访问的url:http://localhost:8080/springmvcdemo/test6
	 * @throws Exception 
	 */
	@RequestMapping(value="test6")
	public void test6(HttpServletResponse response) throws Exception{
		//3.2.1外部跳转页面：根目录下的index2.jsp页面
		//response.sendRedirect("/index2.jsp");
		//3.2.2外部跳转控制器
		response.sendRedirect("index1");
	}
	
}
