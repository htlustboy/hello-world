package org.com.hello.world.feign.server;

import org.com.hello.world.feign.config.FeignCinfig;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value="user-server",configuration=FeignCinfig.class)
public interface UserServerFeignInterface {

}
