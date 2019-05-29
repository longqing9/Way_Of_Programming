/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.abxiu.web;

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
import com.thinkgem.jeesite.modules.abxiu.entity.Abxiu;
import com.thinkgem.jeesite.modules.abxiu.service.AbxiuService;

/**
 * 报修登记表Controller
 * @author a
 * @version 2019-03-11
 */
@Controller
@RequestMapping(value = "${adminPath}/abxiu/abxiu")
public class AbxiuController extends BaseController {

	@Autowired
	private AbxiuService abxiuService;
	
	@ModelAttribute
	public Abxiu get(@RequestParam(required=false) String id) {
		Abxiu entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = abxiuService.get(id);
		}
		if (entity == null){
			entity = new Abxiu();
		}
		return entity;
	}
	
	@RequiresPermissions("abxiu:abxiu:view")
	@RequestMapping(value = {"list", ""})
	public String list(Abxiu abxiu, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Abxiu> page = abxiuService.findPage(new Page<Abxiu>(request, response), abxiu); 
		model.addAttribute("page", page);
		return "modules/abxiu/abxiuList";
	}

	@RequiresPermissions("abxiu:abxiu:view")
	@RequestMapping(value = "form")
	public String form(Abxiu abxiu, Model model) {
		model.addAttribute("abxiu", abxiu);
		return "modules/abxiu/abxiuForm";
	}

	@RequiresPermissions("abxiu:abxiu:edit")
	@RequestMapping(value = "save")
	public String save(Abxiu abxiu, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, abxiu)){
			return form(abxiu, model);
		}
		abxiuService.save(abxiu);
		addMessage(redirectAttributes, "保存报修订单成功");
		return "redirect:"+Global.getAdminPath()+"/abxiu/abxiu/?repage";
	}
	
	@RequiresPermissions("abxiu:abxiu:edit")
	@RequestMapping(value = "delete")
	public String delete(Abxiu abxiu, RedirectAttributes redirectAttributes) {
		abxiuService.delete(abxiu);
		addMessage(redirectAttributes, "删除报修订单成功");
		return "redirect:"+Global.getAdminPath()+"/abxiu/abxiu/?repage";
	}

}