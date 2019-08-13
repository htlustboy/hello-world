package com.hello.world.userServer.enums;

/**
 * 响应参数
 * @author taohu
 *
 */
public enum HttpResponseStatusEnum {
	
	SUCCESS("200","OK"),
	ERROR("500","ERROR");
	
	private String code;
	private String message;
	
	private HttpResponseStatusEnum(String code,String message) {
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
