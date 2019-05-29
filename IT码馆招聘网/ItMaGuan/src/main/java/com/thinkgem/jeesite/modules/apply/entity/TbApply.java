/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.apply.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 我的申请Entity
 * @author a
 * @version 2019-03-12
 */
public class TbApply extends DataEntity<TbApply> {
	
	private static final long serialVersionUID = 1L;
	private String studentid;		// 用户注册ID
	private String companyid;		// 公司注册ID
	private String cjobid;		// 招聘信息ID
	
	public TbApply() {
		super();
	}

	public TbApply(String id){
		super(id);
	}

	@Length(min=1, max=64, message="用户注册ID长度必须介于 1 和 64 之间")
	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	
	@Length(min=0, max=64, message="公司注册ID长度必须介于 0 和 64 之间")
	public String getCompanyid() {
		return companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}
	
	@Length(min=1, max=64, message="招聘信息ID长度必须介于 1 和 64 之间")
	public String getCjobid() {
		return cjobid;
	}

	public void setCjobid(String cjobid) {
		this.cjobid = cjobid;
	}
	
}