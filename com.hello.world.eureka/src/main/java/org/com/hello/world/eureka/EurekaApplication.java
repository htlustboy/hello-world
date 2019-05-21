package org.com.hello.world.eureka;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ht
 *
 */
@SpringBootApplication
public class EurekaApplication 
{	
	
	private final static Logger logger = LoggerFactory.getLogger(EurekaApplication.class);
	
    public static void main( String[] args )
    {	
    	logger.info("Eureka Service Start :" + new Date());
    	
    	SpringApplication.run(EurekaApplication.class, args);
    	
    	logger.info("Eureka Service Start Success>>>>>>>>>>>>>>>>>>>>");
    }
}
