package org.com.hello.world.common.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author ht
 *
 */
@CrossOrigin
public class BaseController {
	
	public HttpServletRequest getRequest(){
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return servletRequestAttributes.getRequest();
	}
	
	public HttpServletResponse getResponse(){
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return servletRequestAttributes.getResponse();
	}
	
	
}
