package cn.longQ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.longQ.common.utils.ElfResult;
import cn.longQ.search.service.SearchItemService;

@RestController
public class SearchItemController {

	@Autowired
	private SearchItemService searchItemService;
	
	@RequestMapping("/index/item/import")
	public ElfResult importItemList() {
		ElfResult result = searchItemService.importAllItems();
		return result;
	}
}
