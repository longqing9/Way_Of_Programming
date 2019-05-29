package cn.nyist.springmvc.domain;

import java.util.Date;

public class Operationinformation {

	private Long sno;
	
	private String  sname;
	
	private String classname;
	
	private String subname;
	
	private Date opstoptime;
	
	private String optext;
	
	private String optop;
	
	private String retext;
	
	private Integer rescore;

	private String opid;
	
	public String getOpid() {
		return opid;
	}

	public void setOpid(String opid) {
		this.opid = opid;
	}

	public Integer getRescore() {
		return rescore;
	}

	public void setRescore(Integer rescore) {
		this.rescore = rescore;
	}

	public Long getSno() {
		return sno;
	}

	public void setSno(Long sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public Date getOpstoptime() {
		return opstoptime;
	}

	public void setOpstoptime(Date opstoptime) {
		this.opstoptime = opstoptime;
	}

	public String getOptext() {
		return optext;
	}

	public void setOptext(String optext) {
		this.optext = optext;
	}

	public String getOptop() {
		return optop;
	}

	public void setOptop(String optop) {
		this.optop = optop;
	}

	public String getRetext() {
		return retext;
	}

	public void setRetext(String retext) {
		this.retext = retext;
	}
	
	
}
