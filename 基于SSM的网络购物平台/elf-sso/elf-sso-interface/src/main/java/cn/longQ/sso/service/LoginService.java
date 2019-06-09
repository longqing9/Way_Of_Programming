package cn.longQ.sso.service;

import cn.longQ.common.utils.ElfResult;

public interface LoginService {
	
	ElfResult UserLogin(String username,String password);

}
