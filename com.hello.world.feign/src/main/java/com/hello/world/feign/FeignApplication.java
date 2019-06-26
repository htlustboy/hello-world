package com.hello.world.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hutao
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@Slf4j
public class FeignApplication 
{
    public static void main( String[] args )
    {
    	log.info("feign server begin...");
    	
        SpringApplication.run(FeignApplication.class, args);
        
        log.info("feign server start successful...");
    }
}
