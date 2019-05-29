/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.apply.web;

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
import com.thinkgem.jeesite.modules.apply.entity.TbApply;
import com.thinkgem.jeesite.modules.apply.service.TbApplyService;

/**
 * 我的申请Controller
 * @author a
 * @version 2019-03-12
 */
@Controller
@RequestMapping(value = "${adminPath}/apply/tbApply")
public class TbApplyController extends BaseController {

	@Autowired
	private TbApplyService tbApplyService;
	
	@ModelAttribute
	public TbApply get(@RequestParam(required=false) String id) {
		TbApply entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbApplyService.get(id);
		}
		if (entity == null){
			entity = new TbApply();
		}
		return entity;
	}
	
	@RequiresPermissions("apply:tbApply:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbApply tbApply, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbApply> page = tbApplyService.findPage(new Page<TbApply>(request, response), tbApply); 
		model.addAttribute("page", page);
		return "modules/apply/tbApplyList";
	}

	@RequiresPermissions("apply:tbApply:view")
	@RequestMapping(value = "form")
	public String form(TbApply tbApply, Model model) {
		model.addAttribute("tbApply", tbApply);
		return "modules/apply/tbApplyForm";
	}

	@RequiresPermissions("apply:tbApply:edit")
	@RequestMapping(value = "save")
	public String save(TbApply tbApply, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbApply)){
			return form(tbApply, model);
		}
		tbApplyService.save(tbApply);
		addMessage(redirectAttributes, "保存申请成功");
		return "redirect:"+Global.getAdminPath()+"/apply/tbApply/?repage";
	}
	
	@RequiresPermissions("apply:tbApply:edit")
	@RequestMapping(value = "delete")
	public String delete(TbApply tbApply, RedirectAttributes redirectAttributes) {
		tbApplyService.delete(tbApply);
		addMessage(redirectAttributes, "删除申请成功");
		return "redirect:"+Global.getAdminPath()+"/apply/tbApply/?repage";
	}

}