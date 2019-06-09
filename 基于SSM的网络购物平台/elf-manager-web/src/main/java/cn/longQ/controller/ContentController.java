package cn.longQ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.longQ.common.utils.ElfResult;
import cn.longQ.content.service.ContentService;
import cn.longQ.pojo.TbContent;

/**保存数据
 * 
 * @author 龍
 *
 */
@RestController
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	@RequestMapping(value="/content/save",method=RequestMethod.POST)
	public ElfResult addContent(TbContent content) {
		ElfResult result = contentService.addContent(content);
		return result;
	}
}
