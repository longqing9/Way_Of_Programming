/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.frontWeb.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 招聘信息描述Entity
 * @author a
 * @version 2019-03-12
 */
public class Cjob extends DataEntity<Cjob> {
	
	private static final long serialVersionUID = 1L;
	private String companyid;		// 公司账号
	private String comname;		// 公司名称
	private String comprofile;		// 公司简介
	private String job;		// 招聘工作名称
	private String department;		// 所属部门
	private String number;		// 招聘人数
	private String emolument;		// 诚招薪水
	private String ptime;		// 发布招聘的时间
	private String place;		// 工作地点
	private String other;		// 职责要求
	private String experience;		// 工作经验
	private String educational;		// 学历要求
	private String undergo;		// 海外经历
	private String language;		// 语种要求
	private String specialty;		// 专业要求
	private String age;		// 要求年龄
	private String fulltime;		// 是否统招全日制
	
	
	private String zht;	//简历的状态
	
	
	public String getZht() {
		return zht;
	}

	public void setZht(String zht) {
		this.zht = zht;
	}
	
	
	private String iid;		// 
	
	public String getIid() {
		return iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public Cjob() {
		super();
	}

	public Cjob(String id){
		super(id);
	}

	@Length(min=0, max=64, message="公司账号长度必须介于 0 和 64 之间")
	public String getCompanyid() {
		return companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}
	
	@Length(min=0, max=30, message="公司名称长度必须介于 0 和 30 之间")
	public String getComname() {
		return comname;
	}

	public void setComname(String comname) {
		this.comname = comname;
	}
	
	public String getComprofile() {
		return comprofile;
	}

	public void setComprofile(String comprofile) {
		this.comprofile = comprofile;
	}
	
	@Length(min=0, max=50, message="招聘工作名称长度必须介于 0 和 50 之间")
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	@Length(min=0, max=50, message="所属部门长度必须介于 0 和 50 之间")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Length(min=0, max=11, message="招聘人数长度必须介于 0 和 11 之间")
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	@Length(min=0, max=50, message="诚招薪水长度必须介于 0 和 50 之间")
	public String getEmolument() {
		return emolument;
	}

	public void setEmolument(String emolument) {
		this.emolument = emolument;
	}
	
	@Length(min=0, max=30, message="发布招聘的时间长度必须介于 0 和 30 之间")
	public String getPtime() {
		return ptime;
	}

	public void setPtime(String ptime) {
		this.ptime = ptime;
	}
	
	@Length(min=0, max=50, message="工作地点长度必须介于 0 和 50 之间")
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	
	@Length(min=0, max=30, message="工作经验长度必须介于 0 和 30 之间")
	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	@Length(min=0, max=30, message="学历要求长度必须介于 0 和 30 之间")
	public String getEducational() {
		return educational;
	}

	public void setEducational(String educational) {
		this.educational = educational;
	}
	
	@Length(min=0, max=30, message="海外经历长度必须介于 0 和 30 之间")
	public String getUndergo() {
		return undergo;
	}

	public void setUndergo(String undergo) {
		this.undergo = undergo;
	}
	
	@Length(min=0, max=20, message="语种要求长度必须介于 0 和 20 之间")
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	@Length(min=0, max=30, message="专业要求长度必须介于 0 和 30 之间")
	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	@Length(min=0, max=50, message="要求年龄长度必须介于 0 和 50 之间")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	@Length(min=0, max=1, message="是否统招全日制长度必须介于 0 和 1 之间")
	public String getFulltime() {
		return fulltime;
	}

	public void setFulltime(String fulltime) {
		this.fulltime = fulltime;
	}
	
}