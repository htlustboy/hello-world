package com.hello.world.orderServer.irpc;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-service")
public interface IUserServerRpc {
	
	@GetMapping("/user/getUser")
	public String getUser(@RequestParam("id")String id);
}
