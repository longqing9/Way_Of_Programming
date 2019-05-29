package com.thinkgem.jeesite.frontWeb.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.frontWeb.Md5.Md5;
import com.thinkgem.jeesite.frontWeb.entity.TabAccount;
import com.thinkgem.jeesite.frontWeb.service.TabAccountService;

@Controller
public class TabAccountController extends BaseController {
	
	@Autowired
	private TabAccountService tabAccountService;
	
	//登录
	@RequestMapping(value="/denglu")        	
	public String whh(TabAccount account, Model model,HttpServletRequest request, HttpServletResponse response){		
		TabAccount accountA = new TabAccount();
		accountA.setAccount(account.getAccount());
		String password = Md5.md5(account.getPassword(), account.getAccount());
		accountA.setPassword(password);
		TabAccount findAccount = tabAccountService.findAccount(accountA);
		if(findAccount == null){
			return "frontPages/login1";
		}
		request.getSession().setAttribute("stud", findAccount);
		model.addAttribute("account", findAccount);
		return "frontPages/index1";
	}
	
	//跳转到修改个人信息页面
	@RequestMapping(value="/xg")
	public String xg(HttpServletRequest request, HttpServletResponse response, Model model){			
		TabAccount account=(TabAccount)request.getSession().getAttribute("stud");
		TabAccount accountA = new TabAccount();
		accountA.setAccount(account.getAccount());
		accountA.setPassword(account.getPassword());
		TabAccount findAccount = tabAccountService.findAccount(accountA);
		if(findAccount == null){
			return "frontPages/login1";
		}
		model.addAttribute("tabAccount", findAccount);
		return "frontPages/xg";
	}
	
	//保存修改信息
	@RequestMapping(value="/xuigai")
	public String xuigai(TabAccount account, Model model){
	
		String id = account.getId();
		System.out.println(id);
		TabAccount tabAccount = tabAccountService.get(id);
		account.setAccount(tabAccount.getAccount());
		account.setGuan(tabAccount.getGuan());
		account.setUpdateBy(tabAccount.getUpdateBy());
		account.setUpdateDate(new Date());
		account.setRemarks(tabAccount.getRemarks());
		tabAccountService.save(account);		
		return "frontPages/xg";
	}
	
}
