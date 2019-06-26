package com.hello.world.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hutao
 *
 */
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
@Slf4j
public class ZuulApplication 
{
    public static void main( String[] args )
    {	
    	log.info("gateway service start...");
    	
        SpringApplication.run(ZuulApplication.class, args);
        
        log.info("gateway service started successful...");
    }
}
