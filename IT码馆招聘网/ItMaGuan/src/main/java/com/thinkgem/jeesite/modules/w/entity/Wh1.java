/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.w.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 功能描述Entity
 * @author w
 * @version 2018-07-06
 */
public class Wh1 extends DataEntity<Wh1> {
	
	private static final long serialVersionUID = 1L;
	private String whNumber;		// wh_number
	
	public Wh1() {
		super();
	}

	public Wh1(String id){
		super(id);
	}

	@Length(min=1, max=11, message="wh_number长度必须介于 1 和 11 之间")
	public String getWhNumber() {
		return whNumber;
	}

	public void setWhNumber(String whNumber) {
		this.whNumber = whNumber;
	}
	
}