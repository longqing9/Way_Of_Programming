/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.admin.web;

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
import com.thinkgem.jeesite.modules.admin.entity.TbAdmin;
import com.thinkgem.jeesite.modules.admin.service.TbAdminService;

/**
 * 管理员信息表Controller
 * @author a
 * @version 2019-03-12
 */
@Controller
@RequestMapping(value = "${adminPath}/admin/tbAdmin")
public class TbAdminController extends BaseController {

	@Autowired
	private TbAdminService tbAdminService;
	
	@ModelAttribute
	public TbAdmin get(@RequestParam(required=false) String id) {
		TbAdmin entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbAdminService.get(id);
		}
		if (entity == null){
			entity = new TbAdmin();
		}
		return entity;
	}
	
	@RequiresPermissions("admin:tbAdmin:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbAdmin tbAdmin, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbAdmin> page = tbAdminService.findPage(new Page<TbAdmin>(request, response), tbAdmin); 
		model.addAttribute("page", page);
		return "modules/admin/tbAdminList";
	}

	@RequiresPermissions("admin:tbAdmin:view")
	@RequestMapping(value = "form")
	public String form(TbAdmin tbAdmin, Model model) {
		model.addAttribute("tbAdmin", tbAdmin);
		return "modules/admin/tbAdminForm";
	}

	@RequiresPermissions("admin:tbAdmin:edit")
	@RequestMapping(value = "save")
	public String save(TbAdmin tbAdmin, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbAdmin)){
			return form(tbAdmin, model);
		}
		tbAdminService.save(tbAdmin);
		addMessage(redirectAttributes, "保存管理员信息成功");
		return "redirect:"+Global.getAdminPath()+"/admin/tbAdmin/?repage";
	}
	
	@RequiresPermissions("admin:tbAdmin:edit")
	@RequestMapping(value = "delete")
	public String delete(TbAdmin tbAdmin, RedirectAttributes redirectAttributes) {
		tbAdminService.delete(tbAdmin);
		addMessage(redirectAttributes, "删除管理员信息成功");
		return "redirect:"+Global.getAdminPath()+"/admin/tbAdmin/?repage";
	}

}