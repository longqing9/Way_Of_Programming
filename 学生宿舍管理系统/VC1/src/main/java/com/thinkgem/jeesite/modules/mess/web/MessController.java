/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.mess.web;

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
import com.thinkgem.jeesite.modules.mess.entity.Mess;
import com.thinkgem.jeesite.modules.mess.service.MessService;

/**
 * 留言板Controller
 * @author WH
 * @version 2019-03-31
 */
@Controller
@RequestMapping(value = "${adminPath}/mess/mess")
public class MessController extends BaseController {

	@Autowired
	private MessService messService;
	
	@ModelAttribute
	public Mess get(@RequestParam(required=false) String id) {
		Mess entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = messService.get(id);
		}
		if (entity == null){
			entity = new Mess();
		}
		return entity;
	}
	
	@RequiresPermissions("mess:mess:view")
	@RequestMapping(value = {"list", ""})
	public String list(Mess mess, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Mess> page = messService.findPage(new Page<Mess>(request, response), mess); 
		model.addAttribute("page", page);
		return "modules/mess/messList";
	}

	@RequiresPermissions("mess:mess:view")
	@RequestMapping(value = "form")
	public String form(Mess mess, Model model) {
		model.addAttribute("mess", mess);
		return "modules/mess/messForm";
	}

	@RequiresPermissions("mess:mess:edit")
	@RequestMapping(value = "save")
	public String save(Mess mess, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, mess)){
			return form(mess, model);
		}
		messService.save(mess);
		addMessage(redirectAttributes, "保存留言板成功");
		return "redirect:"+Global.getAdminPath()+"/mess/mess/?repage";
	}
	
	@RequiresPermissions("mess:mess:edit")
	@RequestMapping(value = "delete")
	public String delete(Mess mess, RedirectAttributes redirectAttributes) {
		messService.delete(mess);
		addMessage(redirectAttributes, "删除留言板成功");
		return "redirect:"+Global.getAdminPath()+"/mess/mess/?repage";
	}

}