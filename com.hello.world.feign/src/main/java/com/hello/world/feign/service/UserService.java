package com.hello.world.feign.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hello.world.feign.server.UserServerFeignInterface;

@Service
public class UserService {
	
	@Resource
	UserServerFeignInterface userServerFeignInterface;
	
	public String getUser() {
		return userServerFeignInterface.createUser();
	}
}
