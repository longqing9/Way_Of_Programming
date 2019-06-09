package cn.longQ.sso.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import cn.longQ.common.jedis.JedisClient;
import cn.longQ.common.utils.ElfResult;
import cn.longQ.common.utils.JsonUtils;
import cn.longQ.mapper.TbUserMapper;
import cn.longQ.pojo.TbUser;
import cn.longQ.pojo.TbUserExample;
import cn.longQ.pojo.TbUserExample.Criteria;
import cn.longQ.sso.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private TbUserMapper tbUserMapper;
	@Autowired
	private JedisClient jedisClient;
	@Value("${SESSION_EXPIRE}")
	private Integer sessiontime;
	
	@Override
	public ElfResult UserLogin(String username, String password) {
		//判断用户密码是否正确
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<TbUser> list = tbUserMapper.selectByExample(example);
		if(list==null && list.size()==0) {
			ElfResult.build(400, "账号或密码错误");
		}
		TbUser user = list.get(0);
		if(!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
			ElfResult.build(400, "账号或密码错误");
		}
		String token =UUID.randomUUID().toString();
		user.setPassword(null);
		jedisClient.set("SESSION:"+token, JsonUtils.objectToJson(user));
		jedisClient.expire("SESSION:"+token,sessiontime );
		
		return ElfResult.ok(token);
	}

}
