package com.thinkgem.jeesite.frontWeb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.frontWeb.Md5.Md5;
import com.thinkgem.jeesite.frontWeb.entity.TabAccount;
import com.thinkgem.jeesite.frontWeb.service.TabAccountService;

@Controller
public class Register {

	@Autowired
	private TabAccountService tabAccountService;
	
	@RequestMapping(value="Registe")
	public String Registe(TabAccount account,Model model) {
		TabAccount accountA = new TabAccount();
		accountA.setAccount(account.getAccount());
		String password = Md5.md5(account.getPassword(), account.getAccount());
		accountA.setPassword(password);
		TabAccount accountb = new TabAccount();
		accountb.setAccount(account.getAccount());
		List<TabAccount> findList = tabAccountService.findList(accountb);
		if(null==findList || findList.size()==0){
			account.setPassword(password);
			account.setGuan("0");
			tabAccountService.save(account);
			return "frontPages/login1";
		}
		model.addAttribute("tip", "改账号已存在");
		
		return "frontPages/login1";
	}
	
}
