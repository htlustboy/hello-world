package com.hello.world.userServer.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hello.world.userServer.mapper.UserMapper;
import com.hello.world.userServer.model.User;

@Service
public class UserService {
	
	@Resource
	private UserMapper userMapper;
	
	/**
	 * 根据ID查询用户
	 * @param id
	 * @return
	 */
	public User getUserById(String id) {
		return userMapper.getUserById(id);
	}

	/**
	 * 创建用户
	 */
	public void createUser() {
		User user = new User();
		user.setUsername("hutao");
		user.setPassword("123456");
		user.setDisplayName("胡涛");
		user.setPhone("18326910507");
		user.setCountry("China");
		user.setProvince("ShangHai");
		user.setDistincts("QingPu");
		user.setAddress("巷佳华苑1期10号楼11001");
		user.setAge(26);
		user.setSex(1);
		userMapper.createUser(user);
	}
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public int deleteUser(String id) {
		return userMapper.deleteUser(id);
	}

	/**
	 * 验证用户名是否被占用
	 * @param username
	 * @return
	 */
	public String queryIdByUserName(String username) {
		return userMapper.queryIdByUserName(username);
	}

	/**
	 * 更新用户
	 * @param id
	 * @return
	 */
	public String updateById(String id) {
		try {
			User user = getUserById(id);
			user.setUsername("ping");
			int result = userMapper.updateById(user);
			return result==1?"success":"error";
		} catch (Exception e) {
			return e.getMessage();	 
		}
	}
	
}
