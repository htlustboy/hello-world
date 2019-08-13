package com.hello.world.userServer.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.hello.world.userServer.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanTest {
	
	@Autowired
	private ApplicationContext context;
	
	@Test
	public void test() {
		User user = context.getBean(User.class);
		System.out.println(user);
	}

}
