package com.hello.world.userServer;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ht
 *
 */
@Slf4j
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.hello.world"})
public class UserServiceApplication {
	
    public static void main( String[] args )
    {
        log.info("user service start...");
        
        SpringApplication.run(UserServiceApplication.class, args);
        
        log.info("user service started successful...");
    }
    
}
