package com.hello.world.logServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableEurekaClient
public class LogServerApplication 
{
    public static void main( String[] args )
    {	
    	log.info("log server begin start...");
    	
    	SpringApplication.run(LogServerApplication.class, args);
    	
    	log.info("log server begin start successful...");
    }
    
}
