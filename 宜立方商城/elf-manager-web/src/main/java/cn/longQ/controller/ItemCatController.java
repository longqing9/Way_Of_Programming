package cn.longQ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.longQ.common.pojo.EasyUITreeNode;
import cn.longQ.service.ItemCatService;

@RestController
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/item/cat/list")
	public List<EasyUITreeNode> getItemCatList(@RequestParam(name="id",defaultValue="0")long parentId){
		List<EasyUITreeNode> catList = itemCatService.getCatList(parentId);
		return catList;
	}

}
