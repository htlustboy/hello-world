package org.com.hello.world.configServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableEurekaClient
@EnableApolloConfig
public class ConfigServerApplication {
	
    public static void main( String[] args )
    {
    	log.info("config sevrver start...");
    	
    	SpringApplication.run(ConfigServerApplication.class, args);
    	
    	log.info("config sevrver start successful...");
    }
    
}
