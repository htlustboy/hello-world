package com.hello.world.userServer.exception;

import java.io.Serializable;

/**
 * 自定义异常
 * @author taohu
 *
 */
public class UserServerException extends Exception implements Serializable{
	
	public static final String SQL_EXCEPTION_CODE = "101";
	
	public static final String SYSTEM_EXCEPTION_CODE = "201";
	
	private String code;
	
	private String message;
	
	public UserServerException(String code,String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
