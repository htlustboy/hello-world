package com.hello.world.logServer.controller;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hello.world.common.base.controller.BaseController;

@RestController
@RequestMapping("/log")
public class LogController extends BaseController{
	
	@Resource
	private Environment environment;
	
	@RequestMapping("/logTest")
	public String test(@RequestParam("key")String key) {
		try {
			String result = environment.getProperty(key);
			if(StringUtils.isBlank(result)) {
				throw new Exception("KEY 不存在...");
			}
			return result;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
