package com.hello.world.userServer.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hello.world.common.base.controller.BaseController;
import com.hello.world.userServer.model.User;
import com.hello.world.userServer.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * 用户服务
 * @author hutao
 *
 */
@Slf4j
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
	
	@RequestMapping("/createUser")
	public String createUser() {
		userService.createUser();
		return "success";
	}
	
	@RequestMapping(path = "/deleteUser",method = RequestMethod.GET)
	public int deleteUser() {
		String id = this.getRequest().getParameter("id");
		return userService.deleteUser(id);
	}
}
