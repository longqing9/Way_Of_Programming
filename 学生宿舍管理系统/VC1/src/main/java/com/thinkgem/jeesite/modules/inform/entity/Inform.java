/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.inform.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 消息通知表Entity
 * @author Y
 * @version 2019-03-10
 */
public class Inform extends DataEntity<Inform> {
	
	private static final long serialVersionUID = 1L;
	private String title;		// 标题
	private String nr;		// 内容
	private Date time;		// 发布时间
	
	public Inform() {
		super();
	}

	public Inform(String id){
		super(id);
	}

	@Length(min=1, max=32, message="标题长度必须介于 1 和 32 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=1, max=1000, message="内容长度必须介于 1 和 1000 之间")
	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="发布时间不能为空")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
}