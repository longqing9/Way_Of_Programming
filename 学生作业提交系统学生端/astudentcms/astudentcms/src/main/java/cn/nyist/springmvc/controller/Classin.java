package cn.nyist.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.nyist.springmvc.domain.ClassteacherAndsubject;
import cn.nyist.springmvc.domain.Pagebean;
import cn.nyist.springmvc.domain.Studentinfor;
import cn.nyist.springmvc.po.Class;
import cn.nyist.springmvc.po.Student;
import cn.nyist.springmvc.po.Teacher;
import cn.nyist.springmvc.service.Userservice;

@Controller
public class Classin {
	
	@Autowired
	private Userservice service;
	
	//查看班级信息
	@RequestMapping(value="clinformation.action")
	public String Getclassinformation(Model model,HttpServletRequest request){
		Student student =(Student)request.getSession().getAttribute("Student");
		Class class1 = service.getClassinformation(student.getSclassid());
		model.addAttribute("class1", class1);
		
		return "detail/Class/clinformation";
	}
	
	//查看班级成员，成员以列表形式展示--同时分页
	@RequestMapping(value="classmember.action")
	public String Getclassmember(Model model,HttpSession session,String pc){
		int ps;
		ps=(pc==null ? 1:Integer.parseInt(pc));
		Student student = (Student)session.getAttribute("Student");
		Pagebean p = new Pagebean();
		Page<Student> startPage = PageHelper.startPage(ps, 12);
		List<Student> liststudent = service.selectByclassid(student.getSclassid());
		p.setCurrentpage(ps);
		p.setRecordcount((int)startPage.getTotal());
		p.setRecordpage(12);
		model.addAttribute("list", liststudent);
		model.addAttribute("page",p);
		return "detail/Class/classmember";
	}
	
	//查看班级内某一成员的详细信息
	@RequestMapping(value="clstudentinformation")
	public String Getuserinformation(Long sno,Model model){
		Studentinfor studentinfor = service.getstudentinfor(sno);
		model.addAttribute("Student", studentinfor);
		return "detail/PIM/information";
	}
	
	//显示班级的科目机器任课教师的信息
	@RequestMapping(value="subject.action")
	public String Getsubject(HttpSession session,Model model,String pc){
		Student student =(Student)session.getAttribute("Student");
		Pagebean page = new Pagebean();
		int ps=0;
		ps=(pc==null ? 1:Integer.parseInt(pc));
		Page<ClassteacherAndsubject> startPage = PageHelper.startPage(ps, 10);
		List<ClassteacherAndsubject> list = service.selectteacherAndsubject(student.getSclassid());
		page.setCurrentpage(ps);
		page.setRecordcount((int)startPage.getTotal());
		page.setRecordpage(startPage.getPageSize());
		model.addAttribute("list",list);
		model.addAttribute("page", page);
		return "detail/Class/subject";
	}
	
	//查看 任课教师的星系信息
	@RequestMapping(value="ttinformation.action")
	public String Gettinformation(Long tno,Model model){
		Teacher teacher = service.Gettinformation(tno);
		model.addAttribute("teacher",teacher);
		return "detail/Class/tinformation";
	}
	
	
	
}
