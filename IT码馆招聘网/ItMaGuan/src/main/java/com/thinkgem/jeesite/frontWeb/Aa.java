package com.thinkgem.jeesite.frontWeb;


import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.modules.cjob.entity.TbCjob;
import com.thinkgem.jeesite.modules.cjob.service.TbCjobService;

@Controller
public class Aa {
	
	
	@Autowired
	private TbCjobService tbcjobservice;
	
	
	/**
	 * 用户进入如到系统首页首先是显示部分招聘的数据
	 * @param request
	 * @return
	 */
	@RequestMapping(value="${frontPath}")
	public String XX(Model model){
		TbCjob tbCjob = new TbCjob();
		List<TbCjob> findList = tbcjobservice.findList(tbCjob );
		model.addAttribute("cjob", findList);
		return "frontPages/login";
	}
	
	//页面进行跳转到首页
	@RequestMapping(value="Toindex")
	public String Toindex(Model model) {
		TbCjob tbCjob = new TbCjob();
		List<TbCjob> findList = tbcjobservice.findList(tbCjob );
		model.addAttribute("cjob", findList);
		return "frontPages/login";
	}
	
	
	
	//企业登录
	@RequestMapping(value="Company_login.action")
	public String Company_login() {
		return "frontPages/firmlogin";
	}
	
	//企业注册
	@RequestMapping(value="Company_register.action")
	public String Company_register() {
		return "frontPages/firmregister";
	}
	
	
	//进去企业主界面
	@RequestMapping(value="Com_firmHomepage.action")
	public String Com_firmHomepage() {
		return "frontPages/firmhomepage";
	}
	
	//退出
	@RequestMapping(value="com_logout")
	public String Com_logout(HttpServletRequest request) {
		request.getSession().removeAttribute("mycompany");
		return "forward:/Toindex";
	}
	
	


}
