package com.hello.world.feign;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hello.world.feign.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hutao
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@Slf4j
@RestController
@RequestMapping("/feign")
public class FeignApplication 
{
	
	@Resource
	UserService userService;
	
    public static void main( String[] args )
    {
    	log.info("feign server begin...");
    	
        SpringApplication.run(FeignApplication.class, args);
        
        log.info("feign server start successful...");
    }
    
    @RequestMapping("/test")
    public String test() {
    	return userService.getUser();
    }
}
