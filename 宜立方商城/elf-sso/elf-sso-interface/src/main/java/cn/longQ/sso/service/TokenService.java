package cn.longQ.sso.service;

import cn.longQ.common.utils.ElfResult;

/*
 * 根据token响应用户信息，当用户的登录后显示用户的名字
 */

public interface TokenService {

	ElfResult getUserByToken(String token);
}
