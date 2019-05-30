package cn.longQ.search.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.longQ.common.pojo.SearchItem;
import cn.longQ.common.pojo.SearchResult;

@Repository
public class SearchDao {

	@Autowired
	private SolrServer solrServer;
	
	
	public SearchResult search(SolrQuery query) throws Exception {
		//根据条件查询数据库
		QueryResponse queryResponse = solrServer.query(query);
		//获取查询结果
		SolrDocumentList results = queryResponse.getResults();
		//获取内容
		long numFound = results.getNumFound();
		//高亮显示
		Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
		SearchResult searchResult = new SearchResult();
		searchResult.setRecordCount(numFound);
		List<SearchItem> itemList = new ArrayList<>();
		for (SolrDocument solrDocument : results) {
			SearchItem searchItem = new SearchItem();
			searchItem.setId((String) solrDocument.get("id"));
			searchItem.setSell_point((String) solrDocument.get("item_sell_point"));
			searchItem.setPrice((long) solrDocument.get("item_price"));
			searchItem.setImage((String) solrDocument.get("item_image"));
			searchItem.setcategory_name((String) solrDocument.get("item_category_name"));
			List<String> list = highlighting.get(solrDocument.get("id")).get("item_title");
			String title = "";
			if(list !=null && list.size()>0) {
				title = list.get(0);
			}else {
				title=(String) solrDocument.get("item_title");
			}
			searchItem.setTitle(title);
			itemList.add(searchItem);
		}
		searchResult.setItemList(itemList);
		
		return searchResult;
	}
	
	
}
