package cn.longQ.publish;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPublish {
	
	@Test
	public void publishService() throws Exception {
		ApplicationContext application = 
				new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		System.out.println("服务启动。。。");
		System.in.read();
		System.out.println("服务关闭");
	}

}
