package com.hello.world.userServer;



import javax.xml.transform.Source;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ht
 *
 */
@Slf4j
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.hello.world.userServer.mapper")
public class UserServiceApplication {
	
    public static void main( String[] args )
    {
        log.info("user service start...");
        
        SpringApplication.run(UserServiceApplication.class, args);
        
        log.info("user service started successful...");
    }
    
}
