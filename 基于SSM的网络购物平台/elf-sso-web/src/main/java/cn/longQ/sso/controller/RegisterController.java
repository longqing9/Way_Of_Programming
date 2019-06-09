package cn.longQ.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.longQ.common.utils.ElfResult;
import cn.longQ.pojo.TbUser;
import cn.longQ.sso.service.RegisterService;

@Controller
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	
	@RequestMapping("/page/regisetr")
	public String showRegietsrt() {
		return "register";
	}
	
	@RequestMapping("/user/check/{param}/{type}")
	@ResponseBody
	public ElfResult CheckData(@PathVariable String param,@PathVariable Integer type) {
		System.out.println("---------------------------------------------------------------------------");
		ElfResult result = registerService.checkData(param, type);
		System.out.println(result.toString());
		return result;
	}
	
	@RequestMapping(value="/user/register",method=RequestMethod.POST)
	@ResponseBody
	public ElfResult Register(TbUser tbUser) {
		ElfResult result = registerService.Register(tbUser);
		return result;
	}

}
