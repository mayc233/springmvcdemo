package com.yinhai.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义拦截器
 * @author casper
 */
public class MyInterceptor implements HandlerInterceptor {

	/**
	 * 进入控制器之前验证
	 * 	此方法可以验证登录，验证权限
	 * 返回false 则表示不再进入控制器
	 * 返回true 则表示进入控制器
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("prehandle..........");
		return true;
	}
	
	/**
	 * 可以放置一些公共数据到ModelAndView里面，
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle..........");
	}
	
	/**
	 * 控制器执行完之后
	 * 可以进行日志记录
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion......");
	}

}
