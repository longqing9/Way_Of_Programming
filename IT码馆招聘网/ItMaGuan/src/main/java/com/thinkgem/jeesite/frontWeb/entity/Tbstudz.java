package com.thinkgem.jeesite.frontWeb.entity;

public class Tbstudz {
	
	private static final long serialVersionUID = 1L;
	private String studentid;		// studentid
	private String password;		// password
	private String name;		// name
	private String age;		// age
	private String sex;		// sex
	private String birthday;		// birthday
	private String worktime;		// worktime
	private String huji;		// huji
	private String knowledge;		// knowledge
	private String email;		// email
	private String tell;		// tell
	private String nowadress;		// nowadress
	
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getWorktime() {
		return worktime;
	}
	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}
	public String getHuji() {
		return huji;
	}
	public void setHuji(String huji) {
		this.huji = huji;
	}
	public String getKnowledge() {
		return knowledge;
	}
	public void setKnowledge(String knowledge) {
		this.knowledge = knowledge;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTell() {
		return tell;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}
	public String getNowadress() {
		return nowadress;
	}
	public void setNowadress(String nowadress) {
		this.nowadress = nowadress;
	}
	public String getIsok() {
		return isok;
	}
	public void setIsok(String isok) {
		this.isok = isok;
	}
	private String isok;		// 个人信息是否完善

}
