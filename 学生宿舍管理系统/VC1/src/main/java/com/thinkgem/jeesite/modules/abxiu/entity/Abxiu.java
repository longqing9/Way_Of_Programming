/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.abxiu.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 报修登记表Entity
 * @author a
 * @version 2019-03-11
 */
public class Abxiu extends DataEntity<Abxiu> {
	
	private static final long serialVersionUID = 1L;
	private String applyid;		// applyid
	private String acceptid;		// acceptid
	private String content;		// content
	private String time;		// time
	private String numb;		// numb
	private String ishow;		// ishow
	private String score;		// score
	private String isok;		// isok
	
	public Abxiu() {
		super();
	}

	public Abxiu(String id){
		super(id);
	}

	@Length(min=0, max=64, message="applyid长度必须介于 0 和 64 之间")
	public String getApplyid() {
		return applyid;
	}

	public void setApplyid(String applyid) {
		this.applyid = applyid;
	}
	
	@Length(min=0, max=64, message="acceptid长度必须介于 0 和 64 之间")
	public String getAcceptid() {
		return acceptid;
	}

	public void setAcceptid(String acceptid) {
		this.acceptid = acceptid;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=0, max=30, message="time长度必须介于 0 和 30 之间")
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	@Length(min=0, max=10, message="numb长度必须介于 0 和 10 之间")
	public String getNumb() {
		return numb;
	}

	public void setNumb(String numb) {
		this.numb = numb;
	}
	
	@Length(min=0, max=5, message="ishow长度必须介于 0 和 5 之间")
	public String getIshow() {
		return ishow;
	}

	public void setIshow(String ishow) {
		this.ishow = ishow;
	}
	
	@Length(min=0, max=10, message="score长度必须介于 0 和 10 之间")
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	@Length(min=0, max=10, message="isok长度必须介于 0 和 10 之间")
	public String getIsok() {
		return isok;
	}

	public void setIsok(String isok) {
		this.isok = isok;
	}
	
}