package com.hello.world.orderServer.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hello.world.orderServer.irpc.IUserServerRpc;

@Service
public class OrderService {
	
	@Resource
	IUserServerRpc userServerRpc;
	
	public String getUser(String id) {
		return userServerRpc.getUser(id);
	}
}
