package com.zhenzhen.demo.user;

import java.util.Arrays;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

public class JedisSentinelPoolUtil {
	private static String redisIp = ResourceBundle.getBundle("config").getString("redis.sentinel.ip");
	private static String password = ResourceBundle.getBundle("config").getString("redis.sentinel.password");
	private static String masterName = ResourceBundle.getBundle("config").getString("redis.sentinel.masterName");
	private static volatile JedisSentinelPool jedisSentinelPool = null;
	
	private JedisSentinelPoolUtil(){
		
	}
	
	public static void main(String[] args) {
		Jedis jedis = JedisSentinelPoolUtil.getJedisSentinelPoolInstance().getResource();
		jedis.set("hello", "test");
		System.out.println(jedis.get("hello"));
	}
	
	public static JedisSentinelPool getJedisSentinelPoolInstance(){
		if(null == jedisSentinelPool){
			synchronized (JedisSentinelPoolUtil.class) {
				if(null == jedisSentinelPool){
					JedisPoolConfig poolConfig = new JedisPoolConfig();
					poolConfig.setMaxTotal(1000);
					poolConfig.setMaxIdle(32);
					poolConfig.setMaxWaitMillis(100*1000);
					poolConfig.setTestOnBorrow(false);
					Set<String> sentinels = new HashSet<String>(Arrays.asList(redisIp.split(",")));
					jedisSentinelPool = new JedisSentinelPool(masterName, sentinels, poolConfig, password);
				}
			}
		}
		return jedisSentinelPool;
	}
	
	public static void release( JedisSentinelPool jedisSentinelPool,Jedis jedis){
		if(null != jedis){
			jedisSentinelPool.returnResourceObject(jedis);
		}
	}
}
