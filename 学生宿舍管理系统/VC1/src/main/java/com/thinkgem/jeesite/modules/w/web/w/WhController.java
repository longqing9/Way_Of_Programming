/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.w.web.w;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.w.entity.w.Wh;
import com.thinkgem.jeesite.modules.w.service.w.WhService;

/**
 * wController
 * @author w
 * @version 2018-07-05
 */
@Controller
@RequestMapping(value = "${adminPath}/w/w/wh")
public class WhController extends BaseController {

	@Autowired
	private WhService whService;
	
	@ModelAttribute
	public Wh get(@RequestParam(required=false) String id) {
		Wh entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = whService.get(id);
		}
		if (entity == null){
			entity = new Wh();
		}
		return entity;
	}
	
	@RequiresPermissions("w:w:wh:view")
	@RequestMapping(value = {"list", ""})
	public String list(Wh wh, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Wh> page = whService.findPage(new Page<Wh>(request, response), wh); 
		model.addAttribute("page", page);
		return "modules/w/w/whList";
	}

	@RequiresPermissions("w:w:wh:view")
	@RequestMapping(value = "form")
	public String form(Wh wh, Model model) {
		model.addAttribute("wh", wh);
		return "modules/w/w/whForm";
	}

	@RequiresPermissions("w:w:wh:edit")
	@RequestMapping(value = "save")
	public String save(Wh wh, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, wh)){
			return form(wh, model);
		}
		whService.save(wh);
		addMessage(redirectAttributes, "保存w成功");
		return "redirect:"+Global.getAdminPath()+"/w/w/wh/?repage";
	}
	
	@RequiresPermissions("w:w:wh:edit")
	@RequestMapping(value = "delete")
	public String delete(Wh wh, RedirectAttributes redirectAttributes) {
		whService.delete(wh);
		addMessage(redirectAttributes, "删除w成功");
		return "redirect:"+Global.getAdminPath()+"/w/w/wh/?repage";
	}

}