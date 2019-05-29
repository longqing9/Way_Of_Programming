/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.mess.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 留言板Entity
 * @author WH
 * @version 2019-03-31
 */
public class Mess extends DataEntity<Mess> {
	
	private static final long serialVersionUID = 1L;
	private String neir;		// 内容
	private String xinx;		// 发送者信息
	
	public Mess() {
		super();
	}

	public Mess(String id){
		super(id);
	}

	@Length(min=1, max=200, message="内容长度必须介于 1 和 200 之间")
	public String getNeir() {
		return neir;
	}

	public void setNeir(String neir) {
		this.neir = neir;
	}
	
	@Length(min=1, max=64, message="发送者信息长度必须介于 1 和 64 之间")
	public String getXinx() {
		return xinx;
	}

	public void setXinx(String xinx) {
		this.xinx = xinx;
	}
	
}