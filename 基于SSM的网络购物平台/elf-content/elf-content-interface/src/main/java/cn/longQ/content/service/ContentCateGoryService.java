package cn.longQ.content.service;

import java.util.List;

import cn.longQ.common.pojo.EasyUITreeNode;
import cn.longQ.common.utils.ElfResult;

public interface ContentCateGoryService {
	//cn.longQ.content.service.ContentCateGoryService
	List<EasyUITreeNode> getContentCateList(long parentId);
	
	ElfResult addComtentCategory(long parentId,String name);
	

}
