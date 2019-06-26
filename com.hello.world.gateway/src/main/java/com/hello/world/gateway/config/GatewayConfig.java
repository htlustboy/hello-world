package com.hello.world.gateway.config;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * 网管熔断配置
 * @author hutao
 *
 */
@Component
public class GatewayConfig implements ZuulFallbackProvider{

	@Override
	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse() {
			
			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				return headers;
			}
			
			@Override
			public InputStream getBody() throws IOException {
				return new ByteArrayInputStream("sorry the service is not allow to arriver!".getBytes()); 
			}
			
			@Override
			public String getStatusText() throws IOException {
				return "OK";
			}
			
			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.OK;
			}
			
			@Override
			public int getRawStatusCode() throws IOException {
				return 200;
			}
			
			@Override
			public void close() {
				// TODO Auto-generated method stub
				
			}
		};
	}

	@Override
	public String getRoute() {
		return "user-service";
	}
	
	
}
