package com.hello.world.userServer.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaHandler {
	
	@KafkaListener(topics = {"user-topic"})
	public void handle(String message) {
		
		log.info("开始处理消息：{}===>{}",message,System.currentTimeMillis());
		
	}
}
