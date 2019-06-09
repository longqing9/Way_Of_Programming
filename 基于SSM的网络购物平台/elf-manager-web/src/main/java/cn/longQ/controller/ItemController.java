package cn.longQ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.longQ.common.pojo.EasyUIDataGridResult;
import cn.longQ.common.utils.ElfResult;
import cn.longQ.pojo.TbItem;
import cn.longQ.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/index/{itemid}")
	public TbItem SelectByid(@PathVariable("itemid") long itemid) {
		TbItem item = itemService.getItemByid(itemid);
		System.out.println(itemid);
		//System.out.println(item.toString());
		return item;
	}
	
	@RequestMapping("/item/list")
	public EasyUIDataGridResult getItemlist(int page,int rows ) {
		EasyUIDataGridResult item = itemService.getItem(page, rows);
		return item;
	}
	
	
	@RequestMapping(value="/item/save",method=RequestMethod.POST)
	public ElfResult addItem(TbItem item,String desc) {
		ElfResult result = itemService.addItem(item, desc);
		return result;
	}
	
	//删除商品信息,删除商品信息时不是真正的实现删除,而是修改商品的状态
	/**
	 * ,通过对访问的路径的判断在服务层中根据方法的不同执行不同的代码
	 * ,测试将参数类型修改为集合包装类型
	 * @param ids
	 * @param method
	 * @return
	 */
	@RequestMapping("/rest/item/{method}")
	public ElfResult deleteItem(@RequestParam(value="ids")List<Long> ids,@PathVariable("method")String method) {
		ElfResult result = itemService.updateItemStatus(ids, method);
		return result;
	}
	

}
