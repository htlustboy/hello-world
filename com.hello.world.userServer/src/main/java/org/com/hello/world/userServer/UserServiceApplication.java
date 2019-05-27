package org.com.hello.world.userServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * user-service
 * @author hutao
 *
 */
@SpringBootApplication
@EnableEurekaClient
@Slf4j
@RestController
@RequestMapping("/user")
public class UserServiceApplication 
{
    public static void main( String[] args )
    {
        log.info("user service start......");
        
        SpringApplication.run(UserServiceApplication.class, args);
        
        log.info("user service started successful......");
    }
    
    @ResponseBody
    @RequestMapping("/test")
    public String test(){
    	return "hello world";
    }
}
