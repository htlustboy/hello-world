package com.hello.world.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.slf4j.Slf4j;

/**
 * 权限过滤器
 * @author hutao
 *
 */
@Component
@Slf4j
public class AuthorFilter extends ZuulFilter{

	
	/*
	 * 逻辑处理
	 */
	@Override
	public Object run() {
		log.info("验证权限，开始......");
		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String authorToken = request.getHeader("author-token");
//		if(StringUtils.isBlank(authorToken)){
//			log.warn("用户未登陆，没有权限！");
//			ctx.getResponse().setContentType("text/html;charset=UTF-8");
//			ctx.setSendZuulResponse(false);
//			ctx.setResponseStatusCode(800);
//			ctx.setResponseBody("用户没有权限！");
//		}
		log.info("当前登陆用户："+authorToken);
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	/* 
	 * 值越小，越先执行
	 */
	@Override
	public int filterOrder() {
		return 1;
	}

	/* 
	 * "pre","post","routing","error"
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	
}
