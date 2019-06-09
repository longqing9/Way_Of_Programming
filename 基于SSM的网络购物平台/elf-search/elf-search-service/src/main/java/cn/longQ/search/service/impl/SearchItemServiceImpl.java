package cn.longQ.search.service.impl;

import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.longQ.common.pojo.SearchItem;
import cn.longQ.common.utils.ElfResult;
import cn.longQ.search.mapper.ItemMapper;
import cn.longQ.search.service.SearchItemService;

@Service
public class SearchItemServiceImpl implements SearchItemService {

	@Autowired
	private ItemMapper itemMapper;
	
	@Autowired
	private SolrServer solrServer;
	
	
	@Override
	public ElfResult importAllItems() {
			try {
				//查询商品列表
				List<SearchItem> list = itemMapper.getItemList();
				//遍历
				for (SearchItem searchItem : list) {
					//创建文档对象
					SolrInputDocument doc = new SolrInputDocument();
					//创建域
					doc.addField("id", searchItem.getId());
					doc.addField("item_title", searchItem.getTitle());
					doc.addField("item_sell_point", searchItem.getSell_point());
					doc.addField("item_price", searchItem.getPrice());
					doc.addField("item_image", searchItem.getImage());
					doc.addField("item_category_name", searchItem.getcategory_name());
					//添加文档 写入索引库
					solrServer.add(doc);
				}
				solrServer.commit();
				return ElfResult.ok();
			} catch (Exception e) {
				e.printStackTrace();
				return ElfResult.build(500, "数据添加失败");
			} 
	}

}
