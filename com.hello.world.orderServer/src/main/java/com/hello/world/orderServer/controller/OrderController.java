package com.hello.world.orderServer.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hello.world.common.base.util.RedisUtil;
import com.hello.world.orderServer.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Resource
	private RedisUtil redisUtil;
	
	@Resource
	private OrderService orderService;
	
    @RequestMapping("/test")
    public String test() {
    	String id = "2";
    	String result = orderService.getUser(id);
    	redisUtil.set("hello",result);
    	return result;
    }
	
}
