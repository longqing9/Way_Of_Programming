package cn.longQ.item.listener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import cn.longQ.item.pojo.Item;
import cn.longQ.pojo.TbItem;
import cn.longQ.pojo.TbItemDesc;
import cn.longQ.service.ItemService;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class HandleGenListener implements MessageListener{

	@Autowired
	private ItemService itemService;
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	@Value("${HTML_GEN_PATH}")
	private String path;
	
	@Override
	public void onMessage(Message message) {
		try {
			//创建FTL模板
			//从善品种获取商品id
			TextMessage textMessage = (TextMessage) message;
			String text = textMessage.getText();
			long itemId = new Long(text);
			//等待事物提交
			Thread.sleep(100);
			//根据商品id 查询圣品
			TbItem tbitem = itemService.getItemByid(itemId);
			Item item = new Item(tbitem);//新的类对图片的属性进行了处理
			TbItemDesc itemDesc = itemService.getItemDescByid(itemId);
			//封装数据集
			Map< String, Object> data = new HashMap<>();
			data.put("item",item );
			data.put("itemDesc", itemDesc);
			//加载模板对象
			Configuration configuration = freeMarkerConfigurer.getConfiguration();
			Template template = configuration.getTemplate("item.ftl");
			//创建流
			Writer out = new FileWriter(new File(path +itemId+".html"));
			//shengchang wenjian n
			template.process(data, out);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block 	
			e.printStackTrace();
		}
		
		
		
	}

}
