/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sobz.web;

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
import com.thinkgem.jeesite.modules.sobz.entity.TbSobz;
import com.thinkgem.jeesite.modules.sobz.service.TbSobzService;

/**
 * 简历信息的转储表Controller
 * @author a
 * @version 2019-03-12
 */
@Controller
@RequestMapping(value = "${adminPath}/sobz/tbSobz")
public class TbSobzController extends BaseController {

	@Autowired
	private TbSobzService tbSobzService;
	
	@ModelAttribute
	public TbSobz get(@RequestParam(required=false) String id) {
		TbSobz entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbSobzService.get(id);
		}
		if (entity == null){
			entity = new TbSobz();
		}
		return entity;
	}
	
	@RequiresPermissions("sobz:tbSobz:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbSobz tbSobz, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbSobz> page = tbSobzService.findPage(new Page<TbSobz>(request, response), tbSobz); 
		model.addAttribute("page", page);
		return "modules/sobz/tbSobzList";
	}

	@RequiresPermissions("sobz:tbSobz:view")
	@RequestMapping(value = "form")
	public String form(TbSobz tbSobz, Model model) {
		model.addAttribute("tbSobz", tbSobz);
		return "modules/sobz/tbSobzForm";
	}

	@RequiresPermissions("sobz:tbSobz:edit")
	@RequestMapping(value = "save")
	public String save(TbSobz tbSobz, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbSobz)){
			return form(tbSobz, model);
		}
		tbSobzService.save(tbSobz);
		addMessage(redirectAttributes, "保存转储简历信息成功");
		return "redirect:"+Global.getAdminPath()+"/sobz/tbSobz/?repage";
	}
	
	@RequiresPermissions("sobz:tbSobz:edit")
	@RequestMapping(value = "delete")
	public String delete(TbSobz tbSobz, RedirectAttributes redirectAttributes) {
		tbSobzService.delete(tbSobz);
		addMessage(redirectAttributes, "删除转储简历信息成功");
		return "redirect:"+Global.getAdminPath()+"/sobz/tbSobz/?repage";
	}

}