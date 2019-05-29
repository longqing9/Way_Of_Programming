/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.stud.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 应聘者基本信息Entity
 * @author a
 * @version 2019-04-17
 */
public class TbStudent extends DataEntity<TbStudent> {
	
	private static final long serialVersionUID = 1L;
	private String studentid;		// 用户注册ID
	private String password;		// 用户注册密码
	private String name;		// 用户姓名
	private String age;		// 年龄
	private String sex;		// 性别
	private Date birthday;		// 出生日期
	private Date worktime;		// 参加工作时间
	private String huji;		// 户籍所在地
	private String knowledge;		// 学历
	private String email;		// 邮箱
	private String tell;		// 联系电话
	private String nowadress;		// 现居住地
	private String isok;		// 个人信息是否完善
	
	public TbStudent() {
		super();
	}

	public TbStudent(String id){
		super(id);
	}

	@Length(min=1, max=64, message="用户注册ID长度必须介于 1 和 64 之间")
	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	
	@Length(min=1, max=64, message="用户注册密码长度必须介于 1 和 64 之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Length(min=0, max=20, message="用户姓名长度必须介于 0 和 20 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=11, message="年龄长度必须介于 0 和 11 之间")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	@Length(min=0, max=4, message="性别长度必须介于 0 和 4 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getWorktime() {
		return worktime;
	}

	public void setWorktime(Date worktime) {
		this.worktime = worktime;
	}
	
	@Length(min=0, max=50, message="户籍所在地长度必须介于 0 和 50 之间")
	public String getHuji() {
		return huji;
	}

	public void setHuji(String huji) {
		this.huji = huji;
	}
	
	@Length(min=0, max=20, message="学历长度必须介于 0 和 20 之间")
	public String getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(String knowledge) {
		this.knowledge = knowledge;
	}
	
	@Length(min=0, max=20, message="邮箱长度必须介于 0 和 20 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Length(min=0, max=11, message="联系电话长度必须介于 0 和 11 之间")
	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}
	
	@Length(min=0, max=50, message="现居住地长度必须介于 0 和 50 之间")
	public String getNowadress() {
		return nowadress;
	}

	public void setNowadress(String nowadress) {
		this.nowadress = nowadress;
	}
	
	@Length(min=0, max=10, message="个人信息是否完善长度必须介于 0 和 10 之间")
	public String getIsok() {
		return isok;
	}

	public void setIsok(String isok) {
		this.isok = isok;
	}
	
}