package com.hello.world.userServer.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.hello.world.userServer.mapper.UserMapper;
import com.hello.world.userServer.model.User;
import com.hello.world.userServer.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanTest {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void test() {
		User user = context.getBean(User.class);
		System.out.println(user);
	}
	
	@Test
	public void testOptmisticLock() {
		
		User user = userMapper.selectById("2");
		System.out.println(user);
		if(user==null) {
			return ;
		}
		user.setUsername("lustboy");
		user.setVersion(user.getVersion());
		
		try {
			System.out.println("wait....");
			Thread.sleep(5000);
			
			userMapper.updateById(user);
			System.out.println("end sleep....");
			System.out.println(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
