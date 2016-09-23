package com.yinhai.springmvc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义异常解析类
 * @author casper
 *
 */
public class CustomExceptionResolver implements HandlerExceptionResolver{
	
	
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		String message=null;
		//如果是自定义的异常
		if(ex instanceof CustomException){
			message= ((CustomException)ex).getMessage();
		}else{
			message="unknown error";
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", message);  //异常显示的信息
		modelAndView.setViewName("/error");          //出现异常显示的页面
		return modelAndView;
	}

}
