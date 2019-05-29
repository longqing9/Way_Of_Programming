/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.memorandum.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 备忘录Entity
 * @author a
 * @version 2019-03-22
 */
public class Memorandum extends DataEntity<Memorandum> {
	
	private static final long serialVersionUID = 1L;
	private String account;		// 账号
	private String title;		// 题目
	private String content;		// 备忘录内容
	
	public Memorandum() {
		super();
	}

	public Memorandum(String id){
		super(id);
	}

	@Length(min=1, max=10, message="账号长度必须介于 1 和 10 之间")
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	@Length(min=0, max=200, message="题目长度必须介于 0 和 200 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}