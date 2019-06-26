package com.hello.world.feign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Retryer;

@Configuration
public class FeignCinfig {

	@Bean
	public Retryer feignRetryer(){
		return new Retryer.Default();
	}
}
