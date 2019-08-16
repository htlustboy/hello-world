package com.hello.world.feign.server;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hello.world.feign.config.FeignCinfig;

import feign.Param;

@Component
@FeignClient(value="user-service",configuration=FeignCinfig.class)
public interface UserServerFeignInterface {
	
	@GetMapping("/user/createUser")
	public String createUser();
}
