package cn.lojngQ.Jedis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.longQ.common.jedis.JedisClient;

public class JedisClientTest {
	
	@Test
	public void testJedisClient() {
		ApplicationContext axt = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-redis.xml");
		JedisClient jedisClient = axt.getBean(JedisClient.class);
		jedisClient.set("mytest", "JedisClient Test");
		String string = jedisClient.get("mytest");
		System.out.println(string);
		
	}

}
