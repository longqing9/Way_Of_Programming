package cn.longQ.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;


public class ActiveMQ {
	/***
	 * 点到点的方式
	 */
	@Test
	public void TestQueueProduct() throws Exception {
		//创建连接工厂，指定IP和端口号
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.91:61616");
		//使用工厂创建一个连接对象
		Connection connection = connectionFactory.createConnection();
		//开启连接
		connection.start();
		//创建Session对象--有两个参数--1.是否开启事务，blooean值，如果开启第二个参数无意义，一般不开启
		//第二个参数  应答模式  自动应答和手动应答---一般为自动应答，在Session对象中的参数形式
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//使用Session对象创建一个消息队列的对象
		Queue queue = session.createQueue("test-queue");
		//创建一个消息生产者的对象
		MessageProducer producer = session.createProducer(queue);
		//创建消息体---两种形式
		/*TextMessage textMessage = new ActiveMQTextMessage();
		textMessage.setText("Hello ActiveMQ");*/
		
		TextMessage message = session.createTextMessage("Hello ActiveMQ");
		//发送消息
		producer.send(message);
		//关闭资源
		producer.close();
		session.close();
		connection.close();
		
	}
	
	@Test
	public void testQueueConsumer() throws Exception {
		//创建一个连接工厂
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.91:61616");
		//创建一个连接对象
		Connection connection = connectionFactory.createConnection();
		//开启里连接
		connection.start();
		//创建一个Session对象
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//创建一个消息队列的对象
		Queue createQueue = session.createQueue("test-queue");
		//创建一个消费消息的对象
		MessageConsumer consumer = session.createConsumer(createQueue);
		//创建一个监听消息队列的监听对象可
		consumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				
				TextMessage textMessage =(TextMessage) message;
				String text;
				try {
					text = textMessage.getText();
					System.out.println(text);
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
		//等待接收消息
		System.in.read();
		//关闭资源
		consumer.close();
		session.close();
		connection.close();
	}
	
	
	/***
	 * 发布/订阅式
	 */
	@Test
	public void TestTopicProduct() throws Exception {
		//创建连接工厂，指定IP和端口号
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.91:61616");
		//使用工厂创建一个连接对象
		Connection connection = connectionFactory.createConnection();
		//开启连接
		connection.start();
		//创建Session对象--有两个参数--1.是否开启事务，blooean值，如果开启第二个参数无意义，一般不开启
		//第二个参数  应答模式  自动应答和手动应答---一般为自动应答，在Session对象中的参数形式
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//使用Session对象创建一个消息队列的对象
		 Topic topic = session.createTopic("test-topic");
		//创建一个消息生产者的对象
		MessageProducer producer = session.createProducer(topic);
		//创建消息体---两种形式
		/*TextMessage textMessage = new ActiveMQTextMessage();
		textMessage.setText("Hello ActiveMQ");*/
		
		TextMessage message = session.createTextMessage("Hello ActiveMQ");
		//发送消息
		producer.send(message);
		//关闭资源
		producer.close();
		session.close();
		connection.close();
		
	}
	
	
	
	@Test
	public void testTopicConsumer() throws Exception {
		//创建一个连接工厂
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.91:61616");
		//创建一个连接对象
		Connection connection = connectionFactory.createConnection();
		//开启里连接
		connection.start();
		//创建一个Session对象
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//创建一个消息队列的对象
		Topic topic = session.createTopic("test-topic");
		//创建一个消费消息的对象
		MessageConsumer consumer = session.createConsumer(topic);
		//创建一个监听消息队列的监听对象可
		consumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				
				TextMessage textMessage =(TextMessage) message;
				String text;
				try {
					text = textMessage.getText();
					System.out.println(text);
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println("topic的消费者3已经启动");
		//等待接收消息
		System.in.read();
		//关闭资源
		consumer.close();
		session.close();
		connection.close();
	}
	

}
