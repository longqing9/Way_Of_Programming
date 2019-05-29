/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.resour.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 资源链接Entity
 * @author a
 * @version 2019-04-16
 */
public class Resources extends DataEntity<Resources> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 资源名
	private String sexplain;		// 简介
	private String slink;		// 链接
	
	public Resources() {
		super();
	}

	public Resources(String id){
		super(id);
	}

	@Length(min=1, max=255, message="资源名长度必须介于 1 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=64, message="简介长度必须介于 1 和 64 之间")
	public String getSexplain() {
		return sexplain;
	}

	public void setSexplain(String sexplain) {
		this.sexplain = sexplain;
	}
	
	@Length(min=1, max=150, message="链接长度必须介于 1 和 150 之间")
	public String getSlink() {
		return slink;
	}

	public void setSlink(String slink) {
		this.slink = slink;
	}
	
}