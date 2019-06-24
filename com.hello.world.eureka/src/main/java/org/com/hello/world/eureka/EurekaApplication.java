package org.com.hello.world.eureka;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ht
 *
 */
@Slf4j
@EnableEurekaServer
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class EurekaApplication 
{	
	
    public static void main( String[] args )
    {	
    	log.info("Eureka Service Start :" + new Date());
    	
    	SpringApplication.run(EurekaApplication.class, args);
    	
    	log.info("Eureka Servce Start Success>>>>>>>>>>>>>>>>>>>>");
    	
    }
}
