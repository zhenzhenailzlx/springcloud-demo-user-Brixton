package com.zhenzhen.demo.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.zhenzhen.demo.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public Map<String, Object> getUser() {
		 Map<String,Object> userMap = new HashMap<String,Object>();
		 userMap.put("id", "1");
		 userMap.put("name", "银真");
		 userMap.put("age", "31");
		 return userMap;
	}

}
