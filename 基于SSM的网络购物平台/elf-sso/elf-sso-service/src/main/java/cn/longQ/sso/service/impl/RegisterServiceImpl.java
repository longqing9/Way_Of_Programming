package cn.longQ.sso.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import cn.longQ.common.utils.ElfResult;
import cn.longQ.mapper.TbUserMapper;
import cn.longQ.pojo.TbUser;
import cn.longQ.pojo.TbUserExample;
import cn.longQ.pojo.TbUserExample.Criteria;
import cn.longQ.sso.service.RegisterService;
/**
 * 用户注册处理
 * @author 龍
 *
 */
@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private TbUserMapper tbUserMapper;
	
	
	@Override
	public ElfResult checkData(String param, int type) {
		//根据不同的类型 执行不同的查询条件
		TbUserExample  tbUserExample = new TbUserExample();
		Criteria criteria = tbUserExample.createCriteria();
		
		//1 用户名  2 手机号  3邮箱
		if(type==1) {
			criteria.andUsernameEqualTo(param);
		}else if(type==2) {
			criteria.andPhoneEqualTo(param);
		}else if(type==3) {
			criteria.andEmailEqualTo(param);
		}else {
			ElfResult.build(400, "数据类型错误");
		}
		//执行查询
		List<TbUser> list = tbUserMapper.selectByExample(tbUserExample);
		//判断是否有返回结果
		if(list!=null && list.size() >0) {
			return ElfResult.ok(false);
		}
		return ElfResult.ok(true);
	}


	@Override
	public ElfResult Register(TbUser tbUser) {
		if(StringUtils.isBlank(tbUser.getUsername())|| StringUtils.isBlank(tbUser.getPassword())||StringUtils.isBlank(tbUser.getPhone())) {
			return ElfResult.build(400, "数据不完成整");
		}
		ElfResult result = checkData(tbUser.getUsername(), 1);
		if(!(boolean) result.getData()) {
			return ElfResult.build(400, "用户名已存在");
		}
		ElfResult result2 = checkData(tbUser.getPhone(), 2);
		if(!(boolean) result2.getData()) {
			return ElfResult.build(400, "手机号已经被占用");
		}
		//不全pojo的属性
		tbUser.setUpdated(new Date());
		tbUser.setCreated(new Date());
		//密码加密
		String md5 = DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes());
		tbUser.setPassword(md5);
		tbUserMapper.insert(tbUser);
		return ElfResult.ok();
	}

}
