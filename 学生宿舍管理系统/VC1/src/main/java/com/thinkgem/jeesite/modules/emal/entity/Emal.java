/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.emal.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 信箱表Entity
 * @author WH
 * @version 2019-03-11
 */
public class Emal extends DataEntity<Emal> {
	
	private static final long serialVersionUID = 1L;
	private String title;		// 标题
	private String nr;		// 内容
	private Date time;		// 发送时间
	private String xx;		// 发送人信息
	
	public Emal() {
		super();
	}

	public Emal(String id){
		super(id);
	}

	@Length(min=1, max=32, message="标题长度必须介于 1 和 32 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=1, max=500, message="内容长度必须介于 1 和 500 之间")
	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="发送时间不能为空")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	@Length(min=1, max=32, message="发送人信息长度必须介于 1 和 32 之间")
	public String getXx() {
		return xx;
	}

	public void setXx(String xx) {
		this.xx = xx;
	}
	
}