package org.com.hello.world.configServer.controller;

import javax.annotation.Resource;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;

@RestController
@RequestMapping("/config")
public class ConfigController {

	@Resource
	private Environment environment;
	
	@RequestMapping("/getKey")
	public String getProperties(@RequestParam("key")String key) {
		try {
			String result = environment.getProperty(key);
			if(StringUtils.isEmpty(result)) {
				throw new Exception("key 不存在！");
			}else {
				return result;
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
