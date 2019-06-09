package cn.longQ.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.longQ.content.service.ContentService;
import cn.longQ.pojo.TbContent;

/**
 * ,首页前台展示
 * @author 龍
 *
 */
@Controller
public class IndexController {
	
	@Value("${CONTENT_LUNBO_ID}")
	private long CONTENT_LUNBO_ID;
	
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/index")
	public String ShowIndex(Model model) {
		//显示首页加载页面数据
		List<TbContent> ad1List = contentService.getContentListByCid(CONTENT_LUNBO_ID);
		model.addAttribute("ad1List", ad1List);
		
		return "index";
	}

}
