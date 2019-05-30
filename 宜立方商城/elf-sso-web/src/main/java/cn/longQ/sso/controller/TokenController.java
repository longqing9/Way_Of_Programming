package cn.longQ.sso.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.longQ.common.utils.ElfResult;
import cn.longQ.common.utils.JsonUtils;
import cn.longQ.sso.service.TokenService;

@Controller
public class TokenController {
	@Autowired
	private TokenService tokenService;
	
	@RequestMapping(value="/user/token/{token}",produces="application/json;charset=utf-8")
	@ResponseBody
	public String getUserByToken(@PathVariable String token,String callback) {
		ElfResult result = tokenService.getUserByToken(token);
		if(StringUtils.isNotBlank(callback)) {
			return callback+"("+JsonUtils.objectToJson(result)+");";
		}
		
		return JsonUtils.objectToJson(result);
	}
}
