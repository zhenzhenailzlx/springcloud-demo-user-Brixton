package com.zhenzhen.demo.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhenzhen.demo.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUser")
	public Map<String,Object> getUser() {
		return userService.getUser();
		
	}
	
	@RequestMapping("/getUserPressLog")
	public String getUserPressLog() throws InterruptedException {
		log.info("带日志压力测试开始");
		Thread.sleep(200);
		log.info("带日志压力测试结束");
		return "压力测试";
	}
	
	@RequestMapping("/getUserPressSleep200ms")
	public String getUserPressSleep200ms() throws InterruptedException {
		Thread.sleep(200);
		return "压力测试";
	}
	
	@RequestMapping("/userPing")
	public String userPing() throws InterruptedException {
		return "压力测试";
	}
	
	@RequestMapping("/getUserPressSleep15s")
	public String getUserPressSleep15s() throws InterruptedException {
		Thread.sleep(15000);
		return "压力测试";
	}
	
	@RequestMapping("/getUserPressERROR")
	public String getUserPressERROR() throws InterruptedException {
		int i = 2/0;
		return "压力测试";
	}

}
