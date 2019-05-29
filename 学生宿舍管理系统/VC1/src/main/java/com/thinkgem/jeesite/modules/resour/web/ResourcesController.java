/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.resour.web;

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
import com.thinkgem.jeesite.modules.resour.entity.Resources;
import com.thinkgem.jeesite.modules.resour.service.ResourcesService;

/**
 * 资源链接Controller
 * @author a
 * @version 2019-04-16
 */
@Controller
@RequestMapping(value = "${adminPath}/resour/resources")
public class ResourcesController extends BaseController {

	@Autowired
	private ResourcesService resourcesService;
	
	@ModelAttribute
	public Resources get(@RequestParam(required=false) String id) {
		Resources entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = resourcesService.get(id);
		}
		if (entity == null){
			entity = new Resources();
		}
		return entity;
	}
	
	@RequiresPermissions("resour:resources:view")
	@RequestMapping(value = {"list", ""})
	public String list(Resources resources, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Resources> page = resourcesService.findPage(new Page<Resources>(request, response), resources); 
		model.addAttribute("page", page);
		return "modules/resour/resourcesList";
	}

	@RequiresPermissions("resour:resources:view")
	@RequestMapping(value = "form")
	public String form(Resources resources, Model model) {
		model.addAttribute("resources", resources);
		return "modules/resour/resourcesForm";
	}

	@RequiresPermissions("resour:resources:edit")
	@RequestMapping(value = "save")
	public String save(Resources resources, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, resources)){
			return form(resources, model);
		}
		resourcesService.save(resources);
		addMessage(redirectAttributes, "保存资源链接成功");
		return "redirect:"+Global.getAdminPath()+"/resour/resources/?repage";
	}
	
	@RequiresPermissions("resour:resources:edit")
	@RequestMapping(value = "delete")
	public String delete(Resources resources, RedirectAttributes redirectAttributes) {
		resourcesService.delete(resources);
		addMessage(redirectAttributes, "删除资源链接成功");
		return "redirect:"+Global.getAdminPath()+"/resour/resources/?repage";
	}

}