package com.hello.world.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
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
		log.info("Zuul验证权限，开始......");
		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String authorToken = request.getHeader("author-token");
		if(StringUtils.isBlank(authorToken)){
			log.warn("用户未登陆，没有权限！");
			ctx.getResponse().setContentType("text/html;charset=UTF-8");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(800);
			ctx.setResponseBody("用户没有权限！");
		}
		log.info("当前登陆用户："+authorToken);
		return null;
	}

	/**
	 *控制过滤器是否生效，可以写一串逻辑进行控制
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/* 
	 * 值越小，越先执行
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/* 
	 * "pre" ：主要用在路由映射的阶段寻找路由映射表
	 * "post"：当routing，error运行完后才会调用该过滤器，实在最后阶段
	 * "routing"：具体的路由转发过滤器是routing路由器，具体的请求转发的时候会调用
	 * "error"：一旦前面的过滤器出错了，才会调用error过滤器
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	
}
