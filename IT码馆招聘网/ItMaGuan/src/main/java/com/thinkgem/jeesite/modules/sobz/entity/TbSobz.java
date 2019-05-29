/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sobz.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 简历信息的转储表Entity
 * @author a
 * @version 2019-03-12
 */
public class TbSobz extends DataEntity<TbSobz> {
	
	private static final long serialVersionUID = 1L;
	private String studentid;		// 用户注册ID
	private String companyid;		// 公司注册|ID
	private String jobid;		// 招聘的ID
	private String specialty;		// 期望行业
	private String job;		// 期望职业
	private String emolument;		// 所求薪水
	private String workaddress;		// 期望工地点
	private String worknow;		// 求职状态
	private String jobnature;		// 工作性质
	private String appendixid;		// 上传附件
	private String other;		// 简历状态
	private String cname;		// 前公司名称
	private String manage;		// 所属行业
	private String specialtyago;		// 前职业名称
	private String zwClass;		// 职位类别
	private String salary;		// 前月薪
	private String jobmiaoshu;		// 工作描述
	private String worktime;		// 在职时间
	private String proName;		// 项目名称
	private String proTime;		// 项目时间
	private String proDescripe;		// 项目描述
	private String proDuty;		// 个人职责
	private String proCompany;		// 所属公司
	private String schName;		// 学校名称
	private String schTime;		// 就读时间
	private String schProfe;		// 所学时间
	private String istzhao;		// 是否统招
	private String degree;		// 学位学历
	private String pxTime;		// 培训时间
	private String pxJigou;		// 培训机构名称
	private String pxClass;		// 培训课程
	private String yyYuzhong;		// 语种
	private String yyTs;		// 听说能力
	private String yyDx;		// 读写能力
	private String zsName;		// 证书名称
	private String zsTime;		// 获得时间
	private String selfassess;		// 自我评价
	/*
	private int pageNo = 0; // 当前页码
	private int pageSize = 5; // 页面大小
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}*/
	
	

	public TbSobz() {
		super();
	}

	public TbSobz(String id){
		super(id);
	}

	@Length(min=0, max=64, message="用户注册ID长度必须介于 0 和 64 之间")
	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	
	@Length(min=0, max=64, message="公司注册|ID长度必须介于 0 和 64 之间")
	public String getCompanyid() {
		return companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}
	
	@Length(min=0, max=64, message="招聘的ID长度必须介于 0 和 64 之间")
	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	
	@Length(min=0, max=50, message="期望行业长度必须介于 0 和 50 之间")
	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	@Length(min=0, max=50, message="期望职业长度必须介于 0 和 50 之间")
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	@Length(min=0, max=50, message="所求薪水长度必须介于 0 和 50 之间")
	public String getEmolument() {
		return emolument;
	}

	public void setEmolument(String emolument) {
		this.emolument = emolument;
	}
	
	@Length(min=0, max=50, message="期望工地点长度必须介于 0 和 50 之间")
	public String getWorkaddress() {
		return workaddress;
	}

	public void setWorkaddress(String workaddress) {
		this.workaddress = workaddress;
	}
	
	@Length(min=0, max=50, message="求职状态长度必须介于 0 和 50 之间")
	public String getWorknow() {
		return worknow;
	}

	public void setWorknow(String worknow) {
		this.worknow = worknow;
	}
	
	@Length(min=0, max=50, message="工作性质长度必须介于 0 和 50 之间")
	public String getJobnature() {
		return jobnature;
	}

	public void setJobnature(String jobnature) {
		this.jobnature = jobnature;
	}
	
	@Length(min=0, max=64, message="上传附件长度必须介于 0 和 64 之间")
	public String getAppendixid() {
		return appendixid;
	}

	public void setAppendixid(String appendixid) {
		this.appendixid = appendixid;
	}
	
	@Length(min=0, max=20, message="简历状态长度必须介于 0 和 20 之间")
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	
	@Length(min=0, max=50, message="前公司名称长度必须介于 0 和 50 之间")
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
	@Length(min=0, max=50, message="所属行业长度必须介于 0 和 50 之间")
	public String getManage() {
		return manage;
	}

	public void setManage(String manage) {
		this.manage = manage;
	}
	
	@Length(min=0, max=50, message="前职业名称长度必须介于 0 和 50 之间")
	public String getSpecialtyago() {
		return specialtyago;
	}

	public void setSpecialtyago(String specialtyago) {
		this.specialtyago = specialtyago;
	}
	
	@Length(min=0, max=30, message="职位类别长度必须介于 0 和 30 之间")
	public String getZwClass() {
		return zwClass;
	}

	public void setZwClass(String zwClass) {
		this.zwClass = zwClass;
	}
	
	@Length(min=0, max=50, message="前月薪长度必须介于 0 和 50 之间")
	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public String getJobmiaoshu() {
		return jobmiaoshu;
	}

	public void setJobmiaoshu(String jobmiaoshu) {
		this.jobmiaoshu = jobmiaoshu;
	}
	
	@Length(min=0, max=50, message="在职时间长度必须介于 0 和 50 之间")
	public String getWorktime() {
		return worktime;
	}

	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}
	
	@Length(min=0, max=50, message="项目名称长度必须介于 0 和 50 之间")
	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}
	
	@Length(min=0, max=50, message="项目时间长度必须介于 0 和 50 之间")
	public String getProTime() {
		return proTime;
	}

	public void setProTime(String proTime) {
		this.proTime = proTime;
	}
	
	public String getProDescripe() {
		return proDescripe;
	}

	public void setProDescripe(String proDescripe) {
		this.proDescripe = proDescripe;
	}
	
	public String getProDuty() {
		return proDuty;
	}

	public void setProDuty(String proDuty) {
		this.proDuty = proDuty;
	}
	
	@Length(min=0, max=50, message="所属公司长度必须介于 0 和 50 之间")
	public String getProCompany() {
		return proCompany;
	}

	public void setProCompany(String proCompany) {
		this.proCompany = proCompany;
	}
	
	@Length(min=0, max=30, message="学校名称长度必须介于 0 和 30 之间")
	public String getSchName() {
		return schName;
	}

	public void setSchName(String schName) {
		this.schName = schName;
	}
	
	@Length(min=0, max=50, message="就读时间长度必须介于 0 和 50 之间")
	public String getSchTime() {
		return schTime;
	}

	public void setSchTime(String schTime) {
		this.schTime = schTime;
	}
	
	@Length(min=0, max=30, message="所学时间长度必须介于 0 和 30 之间")
	public String getSchProfe() {
		return schProfe;
	}

	public void setSchProfe(String schProfe) {
		this.schProfe = schProfe;
	}
	
	@Length(min=0, max=4, message="是否统招长度必须介于 0 和 4 之间")
	public String getIstzhao() {
		return istzhao;
	}

	public void setIstzhao(String istzhao) {
		this.istzhao = istzhao;
	}
	
	@Length(min=0, max=20, message="学位学历长度必须介于 0 和 20 之间")
	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	@Length(min=0, max=50, message="培训时间长度必须介于 0 和 50 之间")
	public String getPxTime() {
		return pxTime;
	}

	public void setPxTime(String pxTime) {
		this.pxTime = pxTime;
	}
	
	@Length(min=0, max=30, message="培训机构名称长度必须介于 0 和 30 之间")
	public String getPxJigou() {
		return pxJigou;
	}

	public void setPxJigou(String pxJigou) {
		this.pxJigou = pxJigou;
	}
	
	@Length(min=0, max=30, message="培训课程长度必须介于 0 和 30 之间")
	public String getPxClass() {
		return pxClass;
	}

	public void setPxClass(String pxClass) {
		this.pxClass = pxClass;
	}
	
	@Length(min=0, max=30, message="语种长度必须介于 0 和 30 之间")
	public String getYyYuzhong() {
		return yyYuzhong;
	}

	public void setYyYuzhong(String yyYuzhong) {
		this.yyYuzhong = yyYuzhong;
	}
	
	@Length(min=0, max=10, message="听说能力长度必须介于 0 和 10 之间")
	public String getYyTs() {
		return yyTs;
	}

	public void setYyTs(String yyTs) {
		this.yyTs = yyTs;
	}
	
	@Length(min=0, max=10, message="读写能力长度必须介于 0 和 10 之间")
	public String getYyDx() {
		return yyDx;
	}

	public void setYyDx(String yyDx) {
		this.yyDx = yyDx;
	}
	
	@Length(min=0, max=30, message="证书名称长度必须介于 0 和 30 之间")
	public String getZsName() {
		return zsName;
	}

	public void setZsName(String zsName) {
		this.zsName = zsName;
	}
	
	@Length(min=0, max=50, message="获得时间长度必须介于 0 和 50 之间")
	public String getZsTime() {
		return zsTime;
	}

	public void setZsTime(String zsTime) {
		this.zsTime = zsTime;
	}
	
	public String getSelfassess() {
		return selfassess;
	}

	public void setSelfassess(String selfassess) {
		this.selfassess = selfassess;
	}
	
}