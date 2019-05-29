/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.frontWeb.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 账号表Entity
 * @author WH
 * @version 2019-03-05
 */
public class TabAccount extends DataEntity<TabAccount> {
	
	private static final long serialVersionUID = 1L;
	private String account;		// 账号
	private String password;		// 密码
	private String guan;		// 是否为管理员
	private String name;		// 姓名
	private String sex;		// 性别
	private String durmnumber;		// 宿舍号
	private String bednumber;		// 床号
	private String age;		// 年龄
	private String birthday;		// 生日
	private String constellation;		// 星座
	private String hometown;		// 家乡
	private String signature;		// 个性签名
	
	public TabAccount() {
		super();
	}

	public TabAccount(String id){
		super(id);
	}

	@Length(min=1, max=10, message="账号长度必须介于 1 和 10 之间")
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	@Length(min=1, max=32, message="密码长度必须介于 1 和 32 之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Length(min=1, max=1, message="是否为管理员长度必须介于 1 和 1 之间")
	public String getGuan() {
		return guan;
	}

	public void setGuan(String guan) {
		this.guan = guan;
	}
	
	@Length(min=1, max=32, message="姓名长度必须介于 1 和 32 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=1, message="性别长度必须介于 0 和 1 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=1, max=11, message="宿舍号长度必须介于 1 和 11 之间")
	public String getDurmnumber() {
		return durmnumber;
	}

	public void setDurmnumber(String durmnumber) {
		this.durmnumber = durmnumber;
	}
	
	@Length(min=0, max=11, message="床号长度必须介于 0 和 11 之间")
	public String getBednumber() {
		return bednumber;
	}

	public void setBednumber(String bednumber) {
		this.bednumber = bednumber;
	}
	
	@Length(min=0, max=11, message="年龄长度必须介于 0 和 11 之间")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	@Length(min=0, max=32, message="生日长度必须介于 0 和 32 之间")
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	@Length(min=0, max=32, message="星座长度必须介于 0 和 32 之间")
	public String getConstellation() {
		return constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}
	
	@Length(min=0, max=32, message="家乡长度必须介于 0 和 32 之间")
	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	
	@Length(min=0, max=64, message="个性签名长度必须介于 0 和 64 之间")
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	
}