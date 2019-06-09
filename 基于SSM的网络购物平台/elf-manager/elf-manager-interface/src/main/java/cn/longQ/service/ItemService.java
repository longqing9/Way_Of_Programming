package cn.longQ.service;

import java.util.List;
import java.util.Map;

import cn.longQ.common.pojo.EasyUIDataGridResult;
import cn.longQ.common.utils.ElfResult;
import cn.longQ.pojo.TbItem;
import cn.longQ.pojo.TbItemDesc;

public interface ItemService {
	
	TbItem getItemByid(long itemid);
	
	EasyUIDataGridResult getItem(int page,int rows);
	
	ElfResult addItem(TbItem item,String desc);
	
	ElfResult updateItemStatus(List<Long> ids,String method);
	
	Map updateItemToEdit(long itemid);
	
	TbItemDesc getItemDescByid(long itemid);

}
