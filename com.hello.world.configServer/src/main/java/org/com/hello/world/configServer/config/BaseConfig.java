package org.com.hello.world.configServer.config;

import org.springframework.context.annotation.Configuration;

import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class BaseConfig {
	
	@ApolloConfigChangeListener
	private void onChange(ConfigChangeEvent changeEvent) {
		changeEvent.changedKeys().forEach(key ->{
			ConfigChange change = changeEvent.getChange(key);
			
			log.info("config change - key = {} : oldValue={};newValue={}",key,change.getOldValue(),change.getNewValue());
		});
	}
}
