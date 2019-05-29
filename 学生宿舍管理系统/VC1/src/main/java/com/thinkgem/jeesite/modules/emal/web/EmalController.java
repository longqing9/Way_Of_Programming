/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.emal.web;

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
import com.thinkgem.jeesite.modules.emal.entity.Emal;
import com.thinkgem.jeesite.modules.emal.service.EmalService;

/**
 * 信箱表Controller
 * @author WH
 * @version 2019-03-11
 */
@Controller
@RequestMapping(value = "${adminPath}/emal/emal")
public class EmalController extends BaseController {

	@Autowired
	private EmalService emalService;
	
	@ModelAttribute
	public Emal get(@RequestParam(required=false) String id) {
		Emal entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = emalService.get(id);
		}
		if (entity == null){
			entity = new Emal();
		}
		return entity;
	}
	
	@RequiresPermissions("emal:emal:view")
	@RequestMapping(value = {"list", ""})
	public String list(Emal emal, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Emal> page = emalService.findPage(new Page<Emal>(request, response), emal); 
		model.addAttribute("page", page);
		return "modules/emal/emalList";
	}

	@RequiresPermissions("emal:emal:view")
	@RequestMapping(value = "form")
	public String form(Emal emal, Model model) {
		model.addAttribute("emal", emal);
		return "modules/emal/emalForm";
	}

	@RequiresPermissions("emal:emal:edit")
	@RequestMapping(value = "save")
	public String save(Emal emal, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, emal)){
			return form(emal, model);
		}
		emalService.save(emal);
		addMessage(redirectAttributes, "保存信箱表成功");
		return "redirect:"+Global.getAdminPath()+"/emal/emal/?repage";
	}
	
	@RequiresPermissions("emal:emal:edit")
	@RequestMapping(value = "delete")
	public String delete(Emal emal, RedirectAttributes redirectAttributes) {
		emalService.delete(emal);
		addMessage(redirectAttributes, "删除信箱表成功");
		return "redirect:"+Global.getAdminPath()+"/emal/emal/?repage";
	}

}