package cn.nyist.springmvc.domain;

public class ClassteacherAndsubject {
	//select t.Tno,t.Tname,s.subname from teacher t,tea_class tc,subject s where tc.classid='3' and tc.Tid = t.Tno and t.tsubject = s.subid;
	
	private Long tno;
	
	private String tname;
	
	private String subname;

	public Long getTno() {
		return tno;
	}

	public void setTno(Long tno) {
		this.tno = tno;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}


	

}
