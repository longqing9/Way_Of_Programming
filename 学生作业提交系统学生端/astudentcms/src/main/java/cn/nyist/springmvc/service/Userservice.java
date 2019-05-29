package cn.nyist.springmvc.service;

import java.util.List;

import cn.nyist.springmvc.domain.ClassteacherAndsubject;
import cn.nyist.springmvc.domain.Operationinformation;
import cn.nyist.springmvc.domain.Opersub;
import cn.nyist.springmvc.domain.Studentinfor;
import cn.nyist.springmvc.domain.SubjecteacherName;
import cn.nyist.springmvc.domain.Subjectoptop;
import cn.nyist.springmvc.domain.Topsubject;
import cn.nyist.springmvc.po.Class;
import cn.nyist.springmvc.po.Result;
import cn.nyist.springmvc.po.Student;
import cn.nyist.springmvc.po.StudentAccount;
import cn.nyist.springmvc.po.Teacher;

public interface Userservice {

	public List<StudentAccount> selectuser();

	public StudentAccount finduser(StudentAccount user);
	
	public Student Getuser(String sno);
	
	public String getClassname(Long classid);
	
	public void updateinformation(Student student);
	
	public Class getClassinformation(Long classid);
	
	public List<Student> selectByclassid(Long classid);
	
	public Studentinfor getstudentinfor(Long sno);
	
	public List<ClassteacherAndsubject> selectteacherAndsubject(Long classid);
	
	public Teacher Gettinformation(Long tno);
	
	public List<Opersub> SelectAlloperation(Long classid);
	
	public Operationinformation Selectoperinformation(String opid,Student student);
	
	public List<SubjecteacherName> Selectsubject(Long classid,Long sno);
	
	public List<Topsubject> Showsubject(String opsubid,Long sno);
	
	public List<SubjecteacherName> SelectUnsubject(Long classid,Long sno);
	
	public List<Topsubject>ShowUnsubject(Long classid,String opsubid,Long sno);
	
	public List<Subjectoptop> ShowScore(Long sno);
	
	public int toUpdateinformation(Student student);
	
	public List<Student> SelectinformationByname(String name,Long classid);
	
	public List<ClassteacherAndsubject> SelectTeacherBysubname(Long classid,String subname);
	
	public List<Opersub> SelectoperationByoptop(Long classid,String optop);
	
	public String Playadvieo(String opid);
	
	public int Insertresult(Result result);
	
	public int Deleteoperation(String opid,Long sno);
	
	public int resubmitByopidsnoWithBLOBs(String opid,Long sno,String retext);
	
	public int resetpsd(StudentAccount stu);
	
	public List<SubjecteacherName> SelectUnsubjectTeacherBysubname(Long classid,Long sno,String subname);
}
