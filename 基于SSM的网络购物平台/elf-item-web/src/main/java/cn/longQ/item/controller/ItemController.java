package cn.longQ.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.longQ.item.pojo.Item;
import cn.longQ.pojo.TbItem;
import cn.longQ.pojo.TbItemDesc;
import cn.longQ.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	
	@RequestMapping("/item/{itemId}")
	public String showItemInfo(@PathVariable Long itemId,Model model) {
		TbItem tbitem = itemService.getItemByid(itemId);
		Item item = new Item(tbitem);
		TbItemDesc itemDesc = itemService.getItemDescByid(itemId);
		model.addAttribute("item", item);
		model.addAttribute("itemDesc", itemDesc);
		return "item";
	}
	
}
