package com.hello.world.userServer;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hello.world.common.base.util.RedisUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ht
 *
 */
@SpringBootApplication(scanBasePackages={"com.hello.world"},exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableEurekaClient
@Slf4j
@EnableAutoConfiguration(exclude = { JpaRepositoriesAutoConfiguration.class })
@MapperScan(basePackages={"com.hello.world.userServer.mapper"})
@RestController
@RequestMapping("/user")
public class UserServiceApplication {
	
	@Autowired
	private RedisUtil redisUtil;
	
    public static void main( String[] args )
    {
        log.info("user service start...");
        
        SpringApplication.run(UserServiceApplication.class, args);
        
        log.info("user service started successful...");
    }
    
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
    	redisUtil.set("hello", "world");
    	return "test successful:" + redisUtil.get("hello");
    }
}