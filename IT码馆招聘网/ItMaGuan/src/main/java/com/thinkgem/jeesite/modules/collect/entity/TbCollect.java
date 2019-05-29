/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.collect.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 收藏的信息Entity
 * @author a
 * @version 2019-03-12
 */
public class TbCollect extends DataEntity<TbCollect> {
	
	private static final long serialVersionUID = 1L;
	private String studentid;		// 用户账号
	private String cjobid;		// 招聘信息的ID
	
	public TbCollect() {
		super();
	}

	public TbCollect(String id){
		super(id);
	}

	@Length(min=1, max=64, message="用户账号长度必须介于 1 和 64 之间")
	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	
	@Length(min=1, max=64, message="招聘信息的ID长度必须介于 1 和 64 之间")
	public String getCjobid() {
		return cjobid;
	}

	public void setCjobid(String cjobid) {
		this.cjobid = cjobid;
	}
	
}