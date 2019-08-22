package com.hello.world.userServer.controller;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hello.world.common.base.controller.BaseController;
import com.hello.world.common.base.util.RedisUtil;
import com.hello.world.userServer.constant.TopicConstant;
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
	private RedisUtil redisUtil;
	
	@Resource
	private UserService userService;
	
	@Resource
	private KafkaTemplate<String, String> kafkaTemplate;
	

	@RequestMapping("/getUser")
	public User getUser(){
		String id = this.getRequest().getParameter("id");
		User user = userService.getUserById(id);
		return user;
	}
	
	
	@RequestMapping("/createUser")
	public String createUser() {
		String id =  userService.queryIdByUserName("hutao");
		if(StringUtils.isNoneBlank(id)) {
			return "error:the user is exits !";
		}
		userService.createUser();
		return "success";
	}
	
	@RequestMapping(path = "/deleteUser",method = RequestMethod.GET)
	public int deleteUser() {
		String id = this.getRequest().getParameter("id");
		return userService.deleteUser(id);
	}
	
	@RequestMapping("/updateUser")
	public String updateUser() {
		String id = this.getRequest().getParameter("id");
		if(StringUtils.isBlank(id)) {
			return "error:id不能为null!";
		}
		try {
			String result = userService.updateById(id);
			return result;
		} catch (Exception e) {
			return "error";
		}
	}
	
	//kafka消息测试
	@RequestMapping("/send")
	public String send(@RequestParam("message")String message) {
		try {
			kafkaTemplate.send(TopicConstant.LOG_TOPIC, message);
			return "success";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	//幂等性测试
	@RequestMapping("/unique")
	public String unique() {
		try {
			String token = this.getRequest().getHeader("token");
			if(StringUtils.isBlank(token)) {
				throw new Exception("token不能为null!");
			}
			Object result = redisUtil.get(token);
			if(result!=null) {
				throw new Exception("请不要重复提交!");
			}
			redisUtil.set(token, token);
			Thread.sleep(5000);
			log.info("doSomething..........");
			redisUtil.delete(token);
			log.info("end..............{}",redisUtil.get(token));
		} catch (Exception e) {
			return e.getMessage();
		}
		return "success";
	}
}
