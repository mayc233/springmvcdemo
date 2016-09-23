package com.yinhai.springmvc.exception;
/**
 * 自定义异常类
 * @author casper
 *
 */
public class CustomException extends Exception{
	private String message;
	
	public CustomException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
