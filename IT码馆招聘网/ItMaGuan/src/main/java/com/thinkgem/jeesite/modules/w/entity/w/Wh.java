/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.w.entity.w;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * wEntity
 * @author w
 * @version 2018-07-05
 */
public class Wh extends DataEntity<Wh> {
	
	private static final long serialVersionUID = 1L;
	private String s;		// s
	
	public Wh() {
		super();
	}

	public Wh(String id){
		super(id);
	}

	@Length(min=1, max=11, message="s长度必须介于 1 和 11 之间")
	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
	
}