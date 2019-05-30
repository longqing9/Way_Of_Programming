package cn.longQ.search.message;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;

import cn.longQ.common.pojo.SearchItem;
import cn.longQ.search.mapper.ItemMapper;

public class ItemAddMessageListener implements MessageListener {

	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private SolrServer solrServer;
	
	@Override
	public void onMessage(Message message) {
		try {
			//获取商品街id
			TextMessage textMessage = (TextMessage) message;
			String text = textMessage.getText();
			long itemid = new Long(text);
			Thread.sleep(1000);
			//根据商品信息查询商品
			SearchItem searchItem = itemMapper.getItemByid(itemid);
			//创建文档对象
			SolrInputDocument doc = new SolrInputDocument();
			//添加到域
			//创建域
			doc.addField("id", searchItem.getId());
			doc.addField("item_title", searchItem.getTitle());
			doc.addField("item_sell_point", searchItem.getSell_point());
			doc.addField("item_price", searchItem.getPrice());
			doc.addField("item_image", searchItem.getImage());
			doc.addField("item_category_name", searchItem.getcategory_name());
			//添加文档 写入索引库
			solrServer.add(doc);
			//提交
			solrServer.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
