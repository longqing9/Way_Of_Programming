package com.thinkgem.jeesite.frontWeb.Md5;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5 {
	
	public static String md5(String password, String salt){
		return new Md5Hash(password,salt+"fjc",2).toString();
	}

}
