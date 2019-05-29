/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.collect.web;

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
import com.thinkgem.jeesite.modules.collect.entity.TbCollect;
import com.thinkgem.jeesite.modules.collect.service.TbCollectService;

/**
 * 收藏的信息Controller
 * @author a
 * @version 2019-03-12
 */
@Controller
@RequestMapping(value = "${adminPath}/collect/tbCollect")
public class TbCollectController extends BaseController {

	@Autowired
	private TbCollectService tbCollectService;
	
	@ModelAttribute
	public TbCollect get(@RequestParam(required=false) String id) {
		TbCollect entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbCollectService.get(id);
		}
		if (entity == null){
			entity = new TbCollect();
		}
		return entity;
	}
	
	@RequiresPermissions("collect:tbCollect:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbCollect tbCollect, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbCollect> page = tbCollectService.findPage(new Page<TbCollect>(request, response), tbCollect); 
		model.addAttribute("page", page);
		return "modules/collect/tbCollectList";
	}

	@RequiresPermissions("collect:tbCollect:view")
	@RequestMapping(value = "form")
	public String form(TbCollect tbCollect, Model model) {
		model.addAttribute("tbCollect", tbCollect);
		return "modules/collect/tbCollectForm";
	}

	@RequiresPermissions("collect:tbCollect:edit")
	@RequestMapping(value = "save")
	public String save(TbCollect tbCollect, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbCollect)){
			return form(tbCollect, model);
		}
		tbCollectService.save(tbCollect);
		addMessage(redirectAttributes, "保存收藏成功");
		return "redirect:"+Global.getAdminPath()+"/collect/tbCollect/?repage";
	}
	
	@RequiresPermissions("collect:tbCollect:edit")
	@RequestMapping(value = "delete")
	public String delete(TbCollect tbCollect, RedirectAttributes redirectAttributes) {
		tbCollectService.delete(tbCollect);
		addMessage(redirectAttributes, "删除收藏成功");
		return "redirect:"+Global.getAdminPath()+"/collect/tbCollect/?repage";
	}

}