package com.zhenzhen.demo.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

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
	
	public static void main(String[] args) {
		new Object();
		User user1 = new User("银真","23");
		Map<String,String> map = new ConcurrentHashMap<>();
		
		CountDownLatch countDownLatch = new CountDownLatch(3);
		countDownLatch.await();
		
		StringBuffer sb = new StringBuffer();
		Map<User,String> map = new HashMap<User,String>();
		System.out.println(user1.hashCode());
		map.put(user1, "hello");
		System.out.println(map.get(user1));
	}
	
	@RequestMapping("/ping")
	public String getOrder() {
		HashMap<String,String> hashMap = new HashMap<String,String>();
		List list = new ArrayList<>();
		Set<String> set = new HashSet<String>();
		
		
		Map map = new ConcurrentHashMap<>();
		hashMap.put("test", "test");
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
