package com.hello.world.userServer.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hello.world.common.base.controller.BaseController;
import com.hello.world.userServer.model.User;
import com.hello.world.userServer.service.UserService;

/**
 * 用户服务
 * @author hutao
 *
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/getUser")
	public User getUser(){
		String id = this.getRequest().getParameter("id");
		User user = userService.getUserById(id);
		return user;
	}
}
