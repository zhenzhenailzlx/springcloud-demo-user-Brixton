package com.zhenzhen.demo.admin;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import de.codecentric.boot.admin.config.EnableAdminServer;


@SpringBootApplication
//@EnableEurekaClient
@EnableAdminServer
public class AdminApplication {

	public static void main(String[] args) {
		
		Map map = new HashMap<String,String>();
		 new SpringApplicationBuilder(AdminApplication.class).web(true).run(args);
	}

}
