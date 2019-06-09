package cn.lojngQ.Jedis;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

public class JedisTest {
	
	@Test
	public void testJedis() {
		 Jedis jedis = new Jedis("192.168.25.91", 6379);
		jedis.set("test1", "This My first Redis");
		
		String string = jedis.get("test1");
		System.out.println(string);
		jedis.close();
	}
	
	@Test
	public void testJedisCluster() {
		//创建了个连接JedisCluster对象
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.25.93", 7001));
		nodes.add(new HostAndPort("192.168.25.93", 7002));
		nodes.add(new HostAndPort("192.168.25.93", 7003));
		nodes.add(new HostAndPort("192.168.25.93", 7004));
		nodes.add(new HostAndPort("192.168.25.93", 7005));
		nodes.add(new HostAndPort("192.168.25.93", 7006));
		JedisCluster jedisCluster = new JedisCluster(nodes);
		jedisCluster.set("test", "123");
		String string = jedisCluster.get("test");
		System.out.println(string);
		jedisCluster.close();
	}
	
	
	

}
