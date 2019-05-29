package com.thinkgem.jeesite.frontWeb.entity;

import java.io.Serializable;

import com.thinkgem.jeesite.modules.sobz.entity.TbSobz;
import com.thinkgem.jeesite.modules.stud.entity.TbStudent;

public class ShowTow implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private TbSobz tbSobz;
	private TbStudent tbStudent;
	public TbSobz getTbSobz() {
		return tbSobz;
	}
	public void setTbSobz(TbSobz tbSobz) {
		this.tbSobz = tbSobz;
	}
	public TbStudent getTbStudent() {
		return tbStudent;
	}
	public void setTbStudent(TbStudent tbStudent) {
		this.tbStudent = tbStudent;
	}

}
