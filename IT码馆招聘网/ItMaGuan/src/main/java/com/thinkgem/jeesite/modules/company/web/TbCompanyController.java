/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.company.web;

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
import com.thinkgem.jeesite.modules.company.entity.TbCompany;
import com.thinkgem.jeesite.modules.company.service.TbCompanyService;

/**
 * 企业信息表Controller
 * @author a
 * @version 2019-04-17
 */
@Controller
@RequestMapping(value = "${adminPath}/company/tbCompany")
public class TbCompanyController extends BaseController {

	@Autowired
	private TbCompanyService tbCompanyService;
	
	@ModelAttribute
	public TbCompany get(@RequestParam(required=false) String id) {
		TbCompany entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbCompanyService.get(id);
		}
		if (entity == null){
			entity = new TbCompany();
		}
		return entity;
	}
	
	@RequiresPermissions("company:tbCompany:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbCompany tbCompany, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbCompany> page = tbCompanyService.findPage(new Page<TbCompany>(request, response), tbCompany); 
		model.addAttribute("page", page);
		return "modules/company/tbCompanyList";
	}

	@RequiresPermissions("company:tbCompany:view")
	@RequestMapping(value = "form")
	public String form(TbCompany tbCompany, Model model) {
		model.addAttribute("tbCompany", tbCompany);
		return "modules/company/tbCompanyForm";
	}

	@RequiresPermissions("company:tbCompany:edit")
	@RequestMapping(value = "save")
	public String save(TbCompany tbCompany, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbCompany)){
			return form(tbCompany, model);
		}
		tbCompanyService.save(tbCompany);
		addMessage(redirectAttributes, "保存企业信息成功");
		return "redirect:"+Global.getAdminPath()+"/company/tbCompany/?repage";
	}
	
	@RequiresPermissions("company:tbCompany:edit")
	@RequestMapping(value = "delete")
	public String delete(TbCompany tbCompany, RedirectAttributes redirectAttributes) {
		tbCompanyService.delete(tbCompany);
		addMessage(redirectAttributes, "删除企业信息成功");
		return "redirect:"+Global.getAdminPath()+"/company/tbCompany/?repage";
	}

}