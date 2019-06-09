package cn.longQ.activemq;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ActivemqConsumer {
	
	@Test
	public void testActivemqConsumer() throws Exception{
		ApplicationContext applicationContext = new 
				ClassPathXmlApplicationContext("classpath:spring/applicationContext-activemq.xml");
		System.in.read();
		
	}

}
