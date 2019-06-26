package com.hello.world.userServer.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hello.world.userServer.mapper.UserMapper;
import com.hello.world.userServer.model.User;

@Service
public class UserService {
	
	@Resource
	private UserMapper userMapper;
	
	public User getUserById(String id) {
		return userMapper.getUserById(id);
	}

}
