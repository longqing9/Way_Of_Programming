package cn.longQ.search.service.impl;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.longQ.common.pojo.SearchResult;
import cn.longQ.search.dao.SearchDao;
import cn.longQ.search.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	private SearchDao searchDao;

	@Override
	public SearchResult search(String keywords, int page, int rows) throws Exception {
		//创建solrquery对象
		SolrQuery query = new SolrQuery();
		//设置查询条件
		query.setQuery(keywords);
		if(page <=0)
			page =1;
		query.setStart((page-1)*rows);
		query.setRows(rows);
		query.set("df","item_title");
		//开启高亮显示
		query.setHighlight(true);
		query.addHighlightField("item_title");
		query.setHighlightSimplePre("<em style=\"color:red\">");
		query.setHighlightSimplePost("</em>");
		SearchResult result = searchDao.search(query);
		//计算总页数
		long recordCount = result.getRecordCount();
		int pagecount = (int) (recordCount /rows);
		if(recordCount % rows>0)
			pagecount++;
		result.setTotalPage(pagecount);
		return result;
	}

}
