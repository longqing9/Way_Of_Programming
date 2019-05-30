package cn.longQ.solrj;


import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.junit.Test;

public class SolrjTest {

	@Test
	public void AddDocumentTest() throws Exception  {
		//创建一个solrServer 对象，创建一个连接
		SolrServer solerserver = new HttpSolrServer("http://192.168.25.89:8080/solr/collection1");
		//创建一个文档对象SolrInputDocument
		SolrInputDocument document = new SolrInputDocument();
		//向文档中添加域 每一个域必须有一个id 域的名称在scheme文件中存在
		document.addField("id", "doc01");
		document.addField("item_title", "测试商品01");
		document.addField("item_price", 1000);
		//把文档添加到索引库
		solerserver.add(document);
		solerserver.commit();
	}
	
	@Test
	public void delDocumentTest() throws Exception{
		SolrServer solerserver = new HttpSolrServer("http://192.168.25.89:8080/solr/collection1");
		//solerserver.deleteById("doc01");
		solerserver.deleteByQuery("id:doc01");
		solerserver.commit();
	}
	
	@Test
	public void queryTest() throws Exception {
		//创建SolrServer
		SolrServer solrserver = new HttpSolrServer("http://192.168.25.89:8080/solr/collection1");
		//创建SolrQuery
		SolrQuery solrQuery = new SolrQuery();
		//设置查询条件  查询所有
	//	solrQuery.setQuery("*:*");
		solrQuery.set("q", "*:*");
		//执行查询
		QueryResponse query = solrserver.query(solrQuery);
		SolrDocumentList solrDocumentList = query.getResults();
		System.out.println(solrDocumentList.getNumFound());
		for (SolrDocument list : solrDocumentList) {
			System.out.println(list.get("id"));
			System.out.println(list.get("item_title"));
			System.out.println(list.get("item_sell_point"));
			System.out.println(list.get("item_price"));
			System.out.println(list.get("item_image"));
			System.out.println(list.get("item_category_name"));
			System.out.println("---------------------------------------------");
		}
		
	}
	
}
