package com.atguigu.git;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Jedis jedis = new Jedis("192.168.192.129",6379);
		System.out.println(jedis.ping());
		jedis.set("k11", "11");
		System.out.println(jedis.get("k11"));
		Set<String> keys = jedis.keys("*");
		for (String string : keys) {
			System.out.println(string);
		}
		System.out.println(jedis.exists("k2"));
		System.out.println(jedis.ttl("k1"));
		jedis.lpush("l1", "423","rf","ghfg");
		List<String> list = jedis.lrange("l1", 0, -1);
		for (String string : list) {
			System.out.println(string);
		}
		jedis.sadd("s1", "1","2","3","4","5","6","7","8");
		Set<String> smembers = jedis.smembers("s1");
		for (String string : smembers) {
			System.out.print(string);
		}
		jedis.close();
	}

}
