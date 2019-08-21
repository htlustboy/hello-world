package com.hello.world.userServer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hello.world.userServer.model.User;

@Mapper
public interface UserMapper extends BaseMapper<User>{

	User getUserById(@Param("id")String id);

	void createUser(@Param("user")User user);

	int deleteUser(@Param("id")String id);

	String queryIdByUserName(@Param("username")String username);
	
}
