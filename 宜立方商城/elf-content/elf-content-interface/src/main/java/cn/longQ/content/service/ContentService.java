package cn.longQ.content.service;

import java.util.List;

import cn.longQ.common.utils.ElfResult;
import cn.longQ.pojo.TbContent;

public interface ContentService {
	
	ElfResult addContent(TbContent content);
	
	List<TbContent> getContentListByCid(long cid);
}
