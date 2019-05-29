/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.admin.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 管理员信息表Entity
 * @author a
 * @version 2019-03-12
 */
public class TbAdmin extends DataEntity<TbAdmin> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 管理员ID
	private String password;		// 管理员注册密码
	
	public TbAdmin() {
		super();
	}

	public TbAdmin(String id){
		super(id);
	}

	@Length(min=1, max=64, message="管理员ID长度必须介于 1 和 64 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=64, message="管理员注册密码长度必须介于 1 和 64 之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}