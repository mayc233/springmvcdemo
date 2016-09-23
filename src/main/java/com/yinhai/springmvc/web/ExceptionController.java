package com.yinhai.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yinhai.springmvc.exception.CustomException;

@Controller
@RequestMapping("exception")
public class ExceptionController {
	
	/**
	 * 访问url：http://localhost:8080/springmvcdemo/exception/test
	 * 抛出异常，会根据的自定义异常解析器会自动 跳转到error.jsp页面
	 * @param id
	 * @return
	 * @throws CustomException
	 */
	@RequestMapping("test")
	public String test(String id) throws CustomException{
		System.out.println("验证自定义异常的信息");
		if(id == null){
			throw new CustomException("test Exception");
		}
		return "param";
	}
	
}
