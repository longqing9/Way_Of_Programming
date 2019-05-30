package cn.longQ.search.message;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MySessageListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			String text = textMessage.getText();
			System.out.println(text);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
