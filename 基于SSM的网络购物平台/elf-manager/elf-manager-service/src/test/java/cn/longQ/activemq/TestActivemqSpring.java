package cn.longQ.activemq;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class TestActivemqSpring {
	
	@Test
	public void activemqSpringTest() {
		//初始化spring容器
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("classpath:spring/applicationContext-activemq.xml");
		//获取template对象
		JmsTemplate template = applicationContext.getBean(JmsTemplate.class);
		//从容器中获取Destination对象
		Destination destination = (Destination) applicationContext.getBean("queueDestination");
		//发送消息
		template.send(destination, new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("send message active MQ ");
			}
		});
	}

}
