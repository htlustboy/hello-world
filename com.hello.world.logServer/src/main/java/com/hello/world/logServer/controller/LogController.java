package com.hello.world.logServer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hello.world.common.base.controller.BaseController;

@RestController
@RequestMapping("/log")
public class LogController extends BaseController{
	
	@RequestMapping("/logTest")
	public String test() {
		return "logTest";
	}
}
