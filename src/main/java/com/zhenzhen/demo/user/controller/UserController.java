package com.zhenzhen.demo.user.controller;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhenzhen.demo.user.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUser")
	public Map<String,Object> getUser() {
		return userService.getUser();
		
	}
	
	@RequestMapping("/ping")
	public String getOrder() {
		 return "tong"+System.currentTimeMillis();
	}
	
	@RequestMapping("/sleep")
	public String sleep(String time) throws InterruptedException {
		int timeInt = 200;
		if(StringUtils.isNotEmpty(time)) {
			timeInt = Integer.parseInt(time);
		}
		Thread.sleep(timeInt);
		return "sleep"+timeInt;
	}

}
