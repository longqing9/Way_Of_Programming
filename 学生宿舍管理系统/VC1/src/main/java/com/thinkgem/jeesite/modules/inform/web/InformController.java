/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.inform.web;

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
import com.thinkgem.jeesite.modules.inform.entity.Inform;
import com.thinkgem.jeesite.modules.inform.service.InformService;

/**
 * 消息通知表Controller
 * @author Y
 * @version 2019-03-10
 */
@Controller
@RequestMapping(value = "${adminPath}/inform/inform")
public class InformController extends BaseController {

	@Autowired
	private InformService informService;
	
	@ModelAttribute
	public Inform get(@RequestParam(required=false) String id) {
		Inform entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = informService.get(id);
		}
		if (entity == null){
			entity = new Inform();
		}
		return entity;
	}
	
	@RequiresPermissions("inform:inform:view")
	@RequestMapping(value = {"list", ""})
	public String list(Inform inform, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Inform> page = informService.findPage(new Page<Inform>(request, response), inform); 
		model.addAttribute("page", page);
		return "modules/inform/informList";
	}

	@RequiresPermissions("inform:inform:view")
	@RequestMapping(value = "form")
	public String form(Inform inform, Model model) {
		model.addAttribute("inform", inform);
		return "modules/inform/informForm";
	}

	@RequiresPermissions("inform:inform:edit")
	@RequestMapping(value = "save")
	public String save(Inform inform, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, inform)){
			return form(inform, model);
		}
		informService.save(inform);
		addMessage(redirectAttributes, "保存消息通知表成功");
		return "redirect:"+Global.getAdminPath()+"/inform/inform/?repage";
	}
	
	@RequiresPermissions("inform:inform:edit")
	@RequestMapping(value = "delete")
	public String delete(Inform inform, RedirectAttributes redirectAttributes) {
		informService.delete(inform);
		addMessage(redirectAttributes, "删除消息通知表成功");
		return "redirect:"+Global.getAdminPath()+"/inform/inform/?repage";
	}

}