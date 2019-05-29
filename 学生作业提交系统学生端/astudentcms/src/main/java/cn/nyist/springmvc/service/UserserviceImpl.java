package cn.nyist.springmvc.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.nyist.springmvc.dao.ClassMapper;
import cn.nyist.springmvc.dao.OperationMapper;
import cn.nyist.springmvc.dao.ResultMapper;
import cn.nyist.springmvc.dao.StudentAccountMapper;
import cn.nyist.springmvc.dao.StudentMapper;
import cn.nyist.springmvc.dao.SubjectMapper;
import cn.nyist.springmvc.dao.TeacherMapper;
import cn.nyist.springmvc.domain.ClassteacherAndsubject;
import cn.nyist.springmvc.domain.Operationinformation;
import cn.nyist.springmvc.domain.Opersub;
import cn.nyist.springmvc.domain.Studentinfor;
import cn.nyist.springmvc.domain.SubjecteacherName;
import cn.nyist.springmvc.domain.Subjectoptop;
import cn.nyist.springmvc.domain.Topsubject;
import cn.nyist.springmvc.po.Class;
import cn.nyist.springmvc.po.Operation;
import cn.nyist.springmvc.po.Result;
import cn.nyist.springmvc.po.Student;
import cn.nyist.springmvc.po.StudentAccount;
import cn.nyist.springmvc.po.Subject;
import cn.nyist.springmvc.po.Teacher;

@Service
public class UserserviceImpl implements Userservice {

	@Autowired
	private StudentAccountMapper studentaccountmapper;
	
	@Autowired
	private ClassMapper classmapper;
	
	@Autowired
	private StudentMapper studentmapper;
	
	@Autowired
	private TeacherMapper teachermapper;
	
	@Autowired
	private OperationMapper operationmapper;
	
	@Autowired
	private ResultMapper resultmapper;
	
	@Autowired
	private SubjectMapper subjectmapper;
	
	private Operationinformation opinformation = new Operationinformation();
	
	public List<StudentAccount> selectuser(){
		List<StudentAccount> list = studentaccountmapper.selectByExample(null);
		return list;
	}

	public StudentAccount finduser(StudentAccount user) {
		return (StudentAccount) studentaccountmapper.selectByStudent(user);
	
	}
	
	
	//ͨ�����ݵ�ѧ����ѧ�Ž��л��ѧ��������
	public Student Getuser(String sno){
		return studentmapper.selectByPrimaryKey(Long.valueOf(sno));
		 
	}
	
	public Studentinfor getstudentinfor(Long sno){
		return studentmapper.selectstudentinforBysno(sno);
	}
	
	public String getClassname(Long classid){
		Class class1 = classmapper.selectByPrimaryKey(classid);
		return class1.getClassname();
	}
	
	public void updateinformation(Student student){
		studentmapper.updateByPrimaryKey(student);
	}
	
	public Class getClassinformation(Long classid){
		Class class1 = classmapper.selectByPrimaryKey(classid);
		return class1;
	}
	
	public List<Student> selectByclassid(Long classid){
		List<Student> list = studentmapper.selectByclassid(classid);
		return list;
	}
	
	public List<ClassteacherAndsubject> selectteacherAndsubject(Long classid){
		 List<ClassteacherAndsubject> list = classmapper.selectteachersubjectByclassid(classid);
		return list;
	}
	
	public Teacher Gettinformation(Long tno){
		return teachermapper.selectByPrimaryKey(tno);
	}
	
	public List<Opersub> SelectAlloperation(Long classid){
		return operationmapper.SelectAlloperationByclassid(classid);
	}
	
	public Operationinformation Selectoperinformation(String opid,Student student){
		opinformation.setOpid(opid);
		opinformation.setSno(student.getSno());
		opinformation.setSname(student.getSname());
		Class class1 = classmapper.selectByPrimaryKey(student.getSclassid());
		opinformation.setClassname(class1.getClassname());
		Operation operation = operationmapper.selectByPrimaryKey(opid);
		opinformation.setOpstoptime(operation.getOpstoptime());
		opinformation.setOptext(operation.getOptext());
		opinformation.setOptop(operation.getOptop());
		Result result = resultmapper.selectBysnoAndopid(student.getSno(),operation.getOpid());
		if(result==null){
			opinformation.setRetext(null);
		}else{
			opinformation.setRetext(result.getRetext());
			opinformation.setRescore(result.getRescore());
			System.out.println(result.getRescore());
		}
		Subject subject = subjectmapper.selectByPrimaryKey(operation.getOpsubid());
		opinformation.setSubname(subject.getSubname());
		return opinformation;
	}
	
	public List<SubjecteacherName> Selectsubject(Long classid,Long sno){
		List<SubjecteacherName> stlist = operationmapper.SelectsubjectTeachernameByclassid(classid,sno);
		return stlist;
	}
	
	public List<Topsubject> Showsubject(String opsubid,Long sno){
		return operationmapper.ShowsubnameAndtopMap(opsubid,sno);
	}
	
	public List<SubjecteacherName> SelectUnsubject(Long classid,Long sno){
		return operationmapper.SelectUnsubjectTeachernameByclassid(classid,sno);
		
	}
	
	public List<Topsubject>ShowUnsubject(Long classid,String opsubid,Long sno){
		return operationmapper.ShowUnsubnameAndtopMap(classid, opsubid, sno);
	}
	
	public List<Subjectoptop> ShowScore(Long sno){
		return resultmapper.SelectRescoreBysno(sno);
	}
	
	public int toUpdateinformation(Student student){
		int key = studentmapper.updateByPrimaryKeySelective(student);
		return key;
	}
	
	public List<Student> SelectinformationByname(String name,Long classid){
		List<Student> list = studentmapper.SelectinformationByname(name, classid);
		return list;
	}
	
	public List<ClassteacherAndsubject> SelectTeacherBysubname(Long classid,String subname){
		return classmapper.SelectTeacherBysubname(classid, subname);
	}
	
	public List<Opersub> SelectoperationByoptop(Long classid,String optop){
		return operationmapper.SelectoperationByoptop(classid, optop);
	}
	
	public String Playadvieo(String opid){
		return operationmapper.Playvideo(opid);
	}
	
	public int Insertresult(Result result){
		String uid =UUID.randomUUID().toString().replace("-", "");
		result.setReid(uid);
		int i = resultmapper.insertSelective(result);
		return i;
	}
	
	public int Deleteoperation(String opid,Long sno){
		int n = resultmapper.DeleteresultByopidsno(opid, sno);
		return n;
	}
	
	public int resubmitByopidsnoWithBLOBs(String opid,Long sno,String retext){
		int n = resultmapper.resubmitByopidsnoWithBLOBs(opid, sno,retext);
		return n;
	}
	
	public int resetpsd(StudentAccount stu){
		int i = studentaccountmapper.updateByPrimaryKey(stu);
		return i;
	}
	
	public List<SubjecteacherName> SelectUnsubjectTeacherBysubname(Long classid,Long sno,String subname){
		return operationmapper.FindsubjectTeachernameByclassid(classid, sno, subname);
	}
}
