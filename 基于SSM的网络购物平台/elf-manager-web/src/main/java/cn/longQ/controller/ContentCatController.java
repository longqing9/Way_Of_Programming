package cn.longQ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.longQ.common.pojo.EasyUITreeNode;
import cn.longQ.common.utils.ElfResult;
import cn.longQ.content.service.ContentCateGoryService;

@RestController
public class ContentCatController {
	
	@Autowired
	private ContentCateGoryService contentCateGoryService;

	@RequestMapping("/content/category/list")
	public List<EasyUITreeNode> getContentCatList(
			@RequestParam(name="id",defaultValue="0")long parentId){
		List<EasyUITreeNode> contentCateList = contentCateGoryService.getContentCateList(parentId);
		return contentCateList;
		
	}
	
	@RequestMapping(value="/content/category/create",method=RequestMethod.POST)
	public ElfResult CreateContentcateGory(long parentId,String name) {
		ElfResult result = contentCateGoryService.addComtentCategory(parentId, name);
		return result;
		
	}
	
}
