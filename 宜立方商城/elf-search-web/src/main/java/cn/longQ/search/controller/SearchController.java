package cn.longQ.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.longQ.common.pojo.SearchResult;
import cn.longQ.search.service.SearchService;

@Controller
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	@Value("${SREACH_RESULT_ROWS}")
	private int rows;
	
	@RequestMapping("/search")
	public String Search(String keyword,@RequestParam(defaultValue="1")int page,Model model) throws Exception {
		keyword = new String(keyword.getBytes("iso-8859-1"), "UTF-8");
		SearchResult result = searchService.search(keyword, page, rows);
		model.addAttribute("query", keyword);
		model.addAttribute("totalPages", result.getTotalPage());
		model.addAttribute("page", page);
		model.addAttribute("recourdCount",result.getRecordCount());
		model.addAttribute("itemList", result.getItemList());
		//异常测试
		//int a = 1/0;
		return "search";
	}

}
