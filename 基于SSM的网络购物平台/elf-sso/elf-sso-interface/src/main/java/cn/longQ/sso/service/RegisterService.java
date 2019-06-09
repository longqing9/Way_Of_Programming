package cn.longQ.sso.service;

import cn.longQ.common.utils.ElfResult;
import cn.longQ.pojo.TbUser;

public interface RegisterService {

	ElfResult checkData(String param,int type);
	
	ElfResult Register(TbUser tbUser);
}
