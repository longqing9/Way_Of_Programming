/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cjob.web;

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
import com.thinkgem.jeesite.modules.cjob.entity.TbCjob;
import com.thinkgem.jeesite.modules.cjob.service.TbCjobService;

/**
 * 招聘信息描述Controller
 * @author a
 * @version 2019-04-17
 */
@Controller
@RequestMapping(value = "${adminPath}/cjob/tbCjob")
public class TbCjobController extends BaseController {

	@Autowired
	private TbCjobService tbCjobService;
	
	@ModelAttribute
	public TbCjob get(@RequestParam(required=false) String id) {
		TbCjob entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbCjobService.get(id);
		}
		if (entity == null){
			entity = new TbCjob();
		}
		return entity;
	}
	
	@RequiresPermissions("cjob:tbCjob:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbCjob tbCjob, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbCjob> page = tbCjobService.findPage(new Page<TbCjob>(request, response), tbCjob); 
		model.addAttribute("page", page);
		return "modules/cjob/tbCjobList";
	}

	@RequiresPermissions("cjob:tbCjob:view")
	@RequestMapping(value = "form")
	public String form(TbCjob tbCjob, Model model) {
		model.addAttribute("tbCjob", tbCjob);
		return "modules/cjob/tbCjobForm";
	}

	@RequiresPermissions("cjob:tbCjob:edit")
	@RequestMapping(value = "save")
	public String save(TbCjob tbCjob, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbCjob)){
			return form(tbCjob, model);
		}
		tbCjobService.save(tbCjob);
		addMessage(redirectAttributes, "保存招聘信息成功");
		return "redirect:"+Global.getAdminPath()+"/cjob/tbCjob/?repage";
	}
	
	@RequiresPermissions("cjob:tbCjob:edit")
	@RequestMapping(value = "delete")
	public String delete(TbCjob tbCjob, RedirectAttributes redirectAttributes) {
		tbCjobService.delete(tbCjob);
		addMessage(redirectAttributes, "删除招聘信息成功");
		return "redirect:"+Global.getAdminPath()+"/cjob/tbCjob/?repage";
	}

}