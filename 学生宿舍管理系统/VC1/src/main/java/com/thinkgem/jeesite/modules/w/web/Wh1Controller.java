/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.w.web;

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
import com.thinkgem.jeesite.modules.w.entity.Wh1;
import com.thinkgem.jeesite.modules.w.service.Wh1Service;

/**
 * 功能描述Controller
 * @author w
 * @version 2018-07-06
 */
@Controller
@RequestMapping(value = "${adminPath}/w/wh1")
public class Wh1Controller extends BaseController {

	@Autowired
	private Wh1Service wh1Service;
	
	@ModelAttribute
	public Wh1 get(@RequestParam(required=false) String id) {
		Wh1 entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = wh1Service.get(id);
		}
		if (entity == null){
			entity = new Wh1();
		}
		return entity;
	}
	
	@RequiresPermissions("w:wh1:view")
	@RequestMapping(value = {"list", ""})
	public String list(Wh1 wh1, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Wh1> page = wh1Service.findPage(new Page<Wh1>(request, response), wh1); 
		model.addAttribute("page", page);
		return "modules/w/wh1List";
	}

	@RequiresPermissions("w:wh1:view")
	@RequestMapping(value = "form")
	public String form(Wh1 wh1, Model model) {
		model.addAttribute("wh1", wh1);
		return "modules/w/wh1Form";
	}

	@RequiresPermissions("w:wh1:edit")
	@RequestMapping(value = "save")
	public String save(Wh1 wh1, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, wh1)){
			return form(wh1, model);
		}
		wh1Service.save(wh1);
		addMessage(redirectAttributes, "保存功能成功");
		return "redirect:"+Global.getAdminPath()+"/w/wh1/?repage";
	}
	
	@RequiresPermissions("w:wh1:edit")
	@RequestMapping(value = "delete")
	public String delete(Wh1 wh1, RedirectAttributes redirectAttributes) {
		wh1Service.delete(wh1);
		addMessage(redirectAttributes, "删除功能成功");
		return "redirect:"+Global.getAdminPath()+"/w/wh1/?repage";
	}

}