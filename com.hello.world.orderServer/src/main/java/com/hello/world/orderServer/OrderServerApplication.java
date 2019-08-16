package com.hello.world.orderServer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication(scanBasePackages = "{com.hello.world}",exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableAutoConfiguration(exclude = { JpaRepositoriesAutoConfiguration.class })
@ComponentScan(basePackages = {"com.hello.world"})
public class OrderServerApplication 
{	
	
    public static void main( String[] args )
    {
    	log.info("order server begin start...");
    	
    	SpringApplication.run(OrderServerApplication.class, args);
    	
    	log.info("order server start successful...");
    }
    
}
