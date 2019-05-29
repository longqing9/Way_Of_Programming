package cn.nyist.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.nyist.springmvc.domain.ClassteacherAndsubject;
import cn.nyist.springmvc.domain.Opersub;
import cn.nyist.springmvc.domain.Pagebean;
import cn.nyist.springmvc.domain.SubjecteacherName;
import cn.nyist.springmvc.domain.Subjectoptop;
import cn.nyist.springmvc.po.Student;
import cn.nyist.springmvc.service.Userservice;

@Controller
public class Search {
	
	@Autowired
	private Userservice service;

	//查看班级成员信息同多姓名查找
	@RequestMapping(value="SelectinformationByname.action")
	public String SelectinformationByname(String name,Model model,HttpSession session){
		Student student = (Student)session.getAttribute("Student");
		List<Student> list = service.SelectinformationByname(name, student.getSclassid());
		model.addAttribute("list", list);
		return "detail/Class/classmember";
	}
	
	
	//根据科目名称查询教师
	@RequestMapping(value="SelectTeacherBysubname.action")
	public String SelectTeacherBysubname(String subname,Model model,HttpSession session){
		Student student= (Student)session.getAttribute("Student");
		List<ClassteacherAndsubject> list = service.SelectTeacherBysubname(student.getSclassid(), subname);
		model.addAttribute("list", list);
		System.out.println(subname);
		return "detail/Class/subject";
	}
	
	
	//搜索作业根据作业的题目
	@RequestMapping(value="SelectoperationByoptop.action")
	public String SelectoperationByoptop(String optop,Model model,HttpSession session){
		Student student=(Student)session.getAttribute("Student");
		List<Opersub> list = service.SelectoperationByoptop(student.getSclassid(), optop);
		model.addAttribute("list",list);
		return "detail/Operation/alloperation";
	}

	//很酷科目搜索未完成的作业的科目
	@RequestMapping(value="findUnsubjectTeacherbysubname.action")
	public String SelectUnsubjectTeacherbysubname(String subname,Model model,HttpSession session){
		Student student=(Student)session.getAttribute("Student");
		List<SubjecteacherName> list = service.SelectUnsubjectTeacherBysubname(student.getSclassid(), student.getSno(), subname);
		model.addAttribute("list",list);
		return "detail/Operation/unsubject";
	}
	
	
}
