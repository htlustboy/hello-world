package com.hello.world.userServer.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hello.world.userServer.model.User;

@Repository
public interface UserMapper {

	User getUserById(@Param("id")String id);

}
