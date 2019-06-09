package cn.longQ.search.service;

import cn.longQ.common.pojo.SearchResult;

public interface SearchService {
	
	//关键字 第几页 每页的记录数
	SearchResult search(String keywords,int page,int rows) throws Exception;
}
