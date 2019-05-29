/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.examine.web;

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
import com.thinkgem.jeesite.modules.examine.entity.Examine;
import com.thinkgem.jeesite.modules.examine.service.ExamineService;

/**
 * 宿舍检查情况Controller
 * @author D
 * @version 2019-03-10
 */
@Controller
@RequestMapping(value = "${adminPath}/examine/examine")
public class ExamineController extends BaseController {

	@Autowired
	private ExamineService examineService;
	
	@ModelAttribute
	public Examine get(@RequestParam(required=false) String id) {
		Examine entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = examineService.get(id);
		}
		if (entity == null){
			entity = new Examine();
		}
		return entity;
	}
	
	@RequiresPermissions("examine:examine:view")
	@RequestMapping(value = {"list", ""})
	public String list(Examine examine, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Examine> page = examineService.findPage(new Page<Examine>(request, response), examine); 
		model.addAttribute("page", page);
		return "modules/examine/examineList";
	}

	@RequiresPermissions("examine:examine:view")
	@RequestMapping(value = "form")
	public String form(Examine examine, Model model) {
		model.addAttribute("examine", examine);
		return "modules/examine/examineForm";
	}

	@RequiresPermissions("examine:examine:edit")
	@RequestMapping(value = "save")
	public String save(Examine examine, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, examine)){
			return form(examine, model);
		}
		examineService.save(examine);
		addMessage(redirectAttributes, "保存宿舍检查情况成功");
		return "redirect:"+Global.getAdminPath()+"/examine/examine/?repage";
	}
	
	@RequiresPermissions("examine:examine:edit")
	@RequestMapping(value = "delete")
	public String delete(Examine examine, RedirectAttributes redirectAttributes) {
		examineService.delete(examine);
		addMessage(redirectAttributes, "删除宿舍检查情况成功");
		return "redirect:"+Global.getAdminPath()+"/examine/examine/?repage";
	}

}