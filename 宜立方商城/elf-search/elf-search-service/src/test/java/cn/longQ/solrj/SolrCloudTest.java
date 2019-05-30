package cn.longQ.solrj;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrCloudTest {
	
	@Test
	public void testSolrCloud() throws Exception {
		//创建一个solr集群的类，使用CloudSolrServer创建，并设置zkHost
		CloudSolrServer cloudSolrServer = new CloudSolrServer("192.168.25.89:2181,192.168.25.89:2182,192.168.25.89:2183");
		//设置一个默认的DefaultCollection属性
		cloudSolrServer.setDefaultCollection("collection2");
		//创建文档对象
		SolrInputDocument document = new SolrInputDocument();
		//向文档中添加域
		document.addField("id", "solrcloud01");
		document.addField("item_title", "测试商品01");
		document.addField("item_price", 1000);
		//将文件写入索引库
		cloudSolrServer.add(document);
		//提交
		cloudSolrServer.commit();
	}
	
	@Test
	public void testQuery() throws Exception {
		//创建一个solr集群的类，使用CloudSolrServer创建，并设置zkHost
		CloudSolrServer cloudSolrServer = new CloudSolrServer("192.168.25.89:2181,192.168.25.89:2182,192.168.25.89:2183");
		//设置一个默认的DefaultCollection属性
		cloudSolrServer.setDefaultCollection("collection2");
		//创建查询对象
		SolrQuery solrQuery = new SolrQuery();
		//设置查询条件
		solrQuery.setQuery("*:*");
		//执行查询
		QueryResponse query = cloudSolrServer.query(solrQuery);
		SolrDocumentList list = query.getResults();
		System.out.println(list.getNumFound());
		for (SolrDocument solrDocument : list) {
			System.out.println(solrDocument.toString());
		}
	}

}
