package cn.longQ.sso.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.longQ.common.jedis.JedisClient;
import cn.longQ.common.utils.ElfResult;
import cn.longQ.common.utils.JsonUtils;
import cn.longQ.pojo.TbUser;
import cn.longQ.sso.service.TokenService;
/**
 * 根据token获取用户信息
 * @author 龍
 *
 */
@Service
public class TokenServiceImpl implements TokenService {

	@Autowired
	private JedisClient jedisClient;
	@Value("${SESSION_EXPIRE}")
	private Integer sessiontime;
	
	@Override
	public ElfResult getUserByToken(String token) {
		//根据token在redis中获取信息
		String json = jedisClient.get("SESSION:"+token);
		//获取不到信息，返回登录过期
		if(StringUtils.isBlank(json)) {
			return ElfResult.build(201, "用户登录过期");
		}
		//获取后跟新过期时间
		jedisClient.expire("SESSION:"+token, sessiontime);
		TbUser tbUser = JsonUtils.jsonToPojo(json, TbUser.class);
		//返回查询结果
		return ElfResult.ok(tbUser);
	}

}
