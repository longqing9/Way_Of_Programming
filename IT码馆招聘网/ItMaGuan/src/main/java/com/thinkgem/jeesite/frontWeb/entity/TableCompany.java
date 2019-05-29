package com.thinkgem.jeesite.frontWeb.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

public class TableCompany extends DataEntity<TableCompany> {

	private static final long serialVersionUID = 1L;
	private String companyid;		// 注册名称id
	private String password;		// 注册密码
	private String name;		// 公司名称
	private String email;		// 公司email
	private String tel;		// 公司电话
	private String manage;		// 所属行业
	private String property;		// 公司性质
	private String scale;		// 公司规模
	private String address;		// 公司地址
	private String resume;		// 公司基本介绍
	
	public TableCompany() {
		super();
	}

	public TableCompany(String id){
		super(id);
	}

	@Length(min=1, max=64, message="注册名称id长度必须介于 1 和 64 之间")
	public String getCompanyid() {
		return companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}
	
	@Length(min=1, max=64, message="注册密码长度必须介于 1 和 64 之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Length(min=0, max=50, message="公司名称长度必须介于 0 和 50 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=20, message="公司email长度必须介于 0 和 20 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Length(min=0, max=20, message="公司电话长度必须介于 0 和 20 之间")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Length(min=0, max=20, message="所属行业长度必须介于 0 和 20 之间")
	public String getManage() {
		return manage;
	}

	public void setManage(String manage) {
		this.manage = manage;
	}
	
	@Length(min=0, max=50, message="公司性质长度必须介于 0 和 50 之间")
	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
	
	@Length(min=0, max=20, message="公司规模长度必须介于 0 和 20 之间")
	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}
	
	@Length(min=0, max=100, message="公司地址长度必须介于 0 和 100 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	
}
