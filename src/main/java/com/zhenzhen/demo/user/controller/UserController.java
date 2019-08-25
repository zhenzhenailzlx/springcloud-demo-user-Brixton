package com.zhenzhen.demo.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	
	@RequestMapping("/getUser")
	public Map<String,Object> getUser() {
		log.info("I am in getUser");
		 Map<String,Object> userMap = new HashMap<String,Object>();
		 userMap.put("id", "1");
		 userMap.put("name", "银真");
		 userMap.put("age", "31");
		 return userMap;
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
