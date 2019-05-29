package com.thinkgem.jeesite.frontWeb;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.cjob.entity.TbCjob;
import com.thinkgem.jeesite.modules.cjob.service.TbCjobService;

@Controller
public class Tourist {

	@Autowired
	private TbCjobService tbcjobservice;
	
	
	
	//游客登录页面
	@RequestMapping(value="Yklogin")
	public String Yklogin() {
		return "frontPages/y_index";
	}
	
	//游客退出功能 去登陆
	@RequestMapping(value="Yklogout")
	public String Yklogout() {
		return "forward:/Toindex";
	}
	
	//浏览招聘信息
	@RequestMapping(value="ShowYkrecruit")
	public String ShowYkrecruit(TbCjob tbCjob, HttpServletRequest request, HttpServletResponse response, Model model) {
		request.getSession().removeAttribute("cjob");
		Page<TbCjob> findPage = tbcjobservice.findPage(new Page<TbCjob>(request, response), tbCjob);
		model.addAttribute("cjob", findPage);
		return "frontPages/y_showrecruit";
	}
	
	
	
}
