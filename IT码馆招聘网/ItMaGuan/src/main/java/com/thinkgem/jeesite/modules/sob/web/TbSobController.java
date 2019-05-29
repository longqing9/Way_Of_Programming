/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sob.web;

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
import com.thinkgem.jeesite.modules.sob.entity.TbSob;
import com.thinkgem.jeesite.modules.sob.service.TbSobService;

/**
 * 个人简历的信息Controller
 * @author a
 * @version 2019-04-17
 */
@Controller
@RequestMapping(value = "${adminPath}/sob/tbSob")
public class TbSobController extends BaseController {

	@Autowired
	private TbSobService tbSobService;
	
	@ModelAttribute
	public TbSob get(@RequestParam(required=false) String id) {
		TbSob entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbSobService.get(id);
		}
		if (entity == null){
			entity = new TbSob();
		}
		return entity;
	}
	
	@RequiresPermissions("sob:tbSob:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbSob tbSob, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbSob> page = tbSobService.findPage(new Page<TbSob>(request, response), tbSob); 
		model.addAttribute("page", page);
		return "modules/sob/tbSobList";
	}

	@RequiresPermissions("sob:tbSob:view")
	@RequestMapping(value = "form")
	public String form(TbSob tbSob, Model model) {
		model.addAttribute("tbSob", tbSob);
		return "modules/sob/tbSobForm";
	}

	@RequiresPermissions("sob:tbSob:edit")
	@RequestMapping(value = "save")
	public String save(TbSob tbSob, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbSob)){
			return form(tbSob, model);
		}
		tbSobService.save(tbSob);
		addMessage(redirectAttributes, "保存个人简历成功");
		return "redirect:"+Global.getAdminPath()+"/sob/tbSob/?repage";
	}
	
	@RequiresPermissions("sob:tbSob:edit")
	@RequestMapping(value = "delete")
	public String delete(TbSob tbSob, RedirectAttributes redirectAttributes) {
		tbSobService.delete(tbSob);
		addMessage(redirectAttributes, "删除个人简历成功");
		return "redirect:"+Global.getAdminPath()+"/sob/tbSob/?repage";
	}

}