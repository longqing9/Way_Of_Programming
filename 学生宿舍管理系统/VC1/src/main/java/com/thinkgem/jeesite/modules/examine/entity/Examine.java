/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.examine.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 宿舍检查情况Entity
 * @author D
 * @version 2019-03-10
 */
public class Examine extends DataEntity<Examine> {
	
	private static final long serialVersionUID = 1L;
	private String dormNumber;		// 宿舍号
	private String qk;		// 检查情况
	private Date time;		// 检查日期
	
	public Examine() {
		super();
	}

	public Examine(String id){
		super(id);
	}

	@Length(min=1, max=32, message="宿舍号长度必须介于 1 和 32 之间")
	public String getDormNumber() {
		return dormNumber;
	}

	public void setDormNumber(String dormNumber) {
		this.dormNumber = dormNumber;
	}
	
	@Length(min=1, max=100, message="检查情况长度必须介于 1 和 100 之间")
	public String getQk() {
		return qk;
	}

	public void setQk(String qk) {
		this.qk = qk;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="检查日期不能为空")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
}