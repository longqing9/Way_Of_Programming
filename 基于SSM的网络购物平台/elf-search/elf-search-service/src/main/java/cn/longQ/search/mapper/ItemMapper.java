package cn.longQ.search.mapper;

import java.util.List;

import cn.longQ.common.pojo.SearchItem;

public interface ItemMapper {
	
	List<SearchItem> getItemList();
	
	SearchItem getItemByid(long itemid);

}
