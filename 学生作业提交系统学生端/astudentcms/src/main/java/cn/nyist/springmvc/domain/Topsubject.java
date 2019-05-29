package cn.nyist.springmvc.domain;

public class Topsubject {

	private String optop;
	
	private String  subname;
	
	private int rescore;
	
	private String opid;

	public String getOpid() {
		return opid;
	}

	public void setOpid(String opid) {
		this.opid = opid;
	}

	public String getOptop() {
		return optop;
	}

	public void setOptop(String optop) {
		this.optop = optop;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public int getRescore() {
		return rescore;
	}

	public void setRescore(int rescore) {
		this.rescore = rescore;
	}
}
