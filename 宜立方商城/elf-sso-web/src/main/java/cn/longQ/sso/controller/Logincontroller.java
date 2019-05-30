package cn.longQ.sso.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.longQ.common.utils.CookieUtils;
import cn.longQ.common.utils.ElfResult;
import cn.longQ.sso.service.LoginService;

@Controller
public class Logincontroller {

	@Autowired
	private LoginService loginService;
	
	@Value("${COOKIE_KEY}")
	private String COOKIE_KEY;
	
	@RequestMapping("/page/login")
	public String Showlogin() {
		return "login";
	}
	
	@RequestMapping(value="/user/login",method=RequestMethod.POST)
	@ResponseBody
	public ElfResult Userlogin(String username,String password,
		HttpServletRequest request,HttpServletResponse response) {
		ElfResult elfResult = loginService.UserLogin(username, password);
		if(elfResult.getStatus()==200) {
			String token=elfResult.getData().toString();
			CookieUtils.setCookie(request, response, COOKIE_KEY, token);
		}
		return elfResult;
	}
	
	
}
