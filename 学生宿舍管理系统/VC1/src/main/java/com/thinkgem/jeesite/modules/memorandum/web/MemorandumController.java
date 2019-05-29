/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.memorandum.web;

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
import com.thinkgem.jeesite.modules.memorandum.entity.Memorandum;
import com.thinkgem.jeesite.modules.memorandum.service.MemorandumService;

/**
 * 备忘录Controller
 * @author a
 * @version 2019-03-22
 */
@Controller
@RequestMapping(value = "${adminPath}/memorandum/memorandum")
public class MemorandumController extends BaseController {

	@Autowired
	private MemorandumService memorandumService;
	
	@ModelAttribute
	public Memorandum get(@RequestParam(required=false) String id) {
		Memorandum entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = memorandumService.get(id);
		}
		if (entity == null){
			entity = new Memorandum();
		}
		return entity;
	}
	
	@RequiresPermissions("memorandum:memorandum:view")
	@RequestMapping(value = {"list", ""})
	public String list(Memorandum memorandum, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Memorandum> page = memorandumService.findPage(new Page<Memorandum>(request, response), memorandum); 
		model.addAttribute("page", page);
		return "modules/memorandum/memorandumList";
	}

	@RequiresPermissions("memorandum:memorandum:view")
	@RequestMapping(value = "form")
	public String form(Memorandum memorandum, Model model) {
		model.addAttribute("memorandum", memorandum);
		return "modules/memorandum/memorandumForm";
	}

	@RequiresPermissions("memorandum:memorandum:edit")
	@RequestMapping(value = "save")
	public String save(Memorandum memorandum, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, memorandum)){
			return form(memorandum, model);
		}
		memorandumService.save(memorandum);
		addMessage(redirectAttributes, "保存备忘录成功");
		return "redirect:"+Global.getAdminPath()+"/memorandum/memorandum/?repage";
	}
	
	@RequiresPermissions("memorandum:memorandum:edit")
	@RequestMapping(value = "delete")
	public String delete(Memorandum memorandum, RedirectAttributes redirectAttributes) {
		memorandumService.delete(memorandum);
		addMessage(redirectAttributes, "删除备忘录成功");
		return "redirect:"+Global.getAdminPath()+"/memorandum/memorandum/?repage";
	}

}