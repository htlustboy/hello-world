package com.hello.world.feign.server;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.hello.world.feign.config.FeignCinfig;

@FeignClient(value="user-server",configuration=FeignCinfig.class)
public interface UserServerFeignInterface {

}
