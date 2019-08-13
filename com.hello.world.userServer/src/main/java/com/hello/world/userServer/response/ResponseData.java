package com.hello.world.userServer.response;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.hello.world.userServer.enums.HttpResponseStatusEnum;

public class ResponseData {
	
	private long timestamp;
	private String status;
	private String message;
	private Object data;
	
	public String getStatus() {
		if(StringUtils.isBlank(status)) {
			this.status = HttpResponseStatusEnum.SUCCESS.getCode();
		}
		return status;
	}
	
	public void stStatus(String status) {
		this.status = status;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getData() {
		return JSONObject.toJSONString(data);
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	public long getTimestamp() {
		this.timestamp = System.currentTimeMillis();
		return timestamp;
	}
}
