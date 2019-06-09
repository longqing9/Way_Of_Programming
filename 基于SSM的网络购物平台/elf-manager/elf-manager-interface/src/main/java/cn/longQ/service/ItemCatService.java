package cn.longQ.service;

import java.util.List;

import cn.longQ.common.pojo.EasyUITreeNode;

public interface ItemCatService {
	
	public List<EasyUITreeNode> getCatList(long parentId);
}
