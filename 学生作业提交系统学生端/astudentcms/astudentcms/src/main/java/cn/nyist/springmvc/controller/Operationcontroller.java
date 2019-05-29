package cn.nyist.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.nyist.springmvc.domain.Operationinformation;
import cn.nyist.springmvc.domain.Opersub;
import cn.nyist.springmvc.domain.Pagebean;
import cn.nyist.springmvc.domain.SubjecteacherName;
import cn.nyist.springmvc.domain.Subjectoptop;
import cn.nyist.springmvc.domain.Topsubject;
import cn.nyist.springmvc.po.Result;
import cn.nyist.springmvc.po.Student;
import cn.nyist.springmvc.service.Userservice;

@Controller
public class Operationcontroller {

	@Autowired
	private Userservice service;
	
	
	//显示所有的作业 --已经完成的和未完成的
	@RequestMapping(value="alloperation.action")
	public String selectAlloperation(Model model,HttpSession session,String pc){
		Student student =(Student)session.getAttribute("Student");
		Pagebean page = new Pagebean();
		int ps=0;
		ps=(pc==null ? 1:Integer.parseInt(pc));
		Page<Opersub> page2 = PageHelper.startPage(ps, 10);
		List<Opersub> alloperation = service.SelectAlloperation(student.getSclassid());
		page.setCurrentpage(ps);
		page.setRecordcount((int)page2.getTotal());
		page.setRecordpage(page2.getPageSize());
		model.addAttribute("list",alloperation);
		model.addAttribute("page",page);
		return "detail/Operation/alloperation";
	}
	
	/*
	 * 1.具体作业任务页面，在该页面中显示作业的具体信息。
	 * 2.在进入页面后当时间超出作业的限定时间会自动隐藏提交按钮
	 */
	@RequestMapping(value="selectoinformation.action")
	public String Selectoinformation(String opid,Model model,HttpSession session){
		Student student=(Student)session.getAttribute("Student");
		Operationinformation selectoperinformation = service.Selectoperinformation(opid, student);
		model.addAttribute("operinfor",selectoperinformation);
		return "detail/Operation/oinformation";
	}
	
	/*
	 * 1.显示已经完成的作业科目
	 * 2.数据分页显示
	 */
	@RequestMapping(value="showsubject.action")
	public String Selectsubject(Model model,HttpSession session,String pc){
		Student student = (Student)session.getAttribute("Student");
		Pagebean page = new Pagebean();
		int ps;
		ps = (pc==null ? 1:Integer.parseInt(pc));
		Page<SubjecteacherName> page2 = PageHelper.startPage(ps,10);
		List<SubjecteacherName> list = service.Selectsubject(student.getSclassid(),student.getSno());
		page.setCurrentpage(ps);
		page.setRecordcount((int)page2.getTotal());
		page.setRecordpage(page2.getPageSize());
		model.addAttribute("list",list );
		model.addAttribute("page", page);
		return "detail/Operation/subject";
	}
	
	/*
	 * 显示已经完成的科目下的题目
	 * 数据分页显示
	 */
	
	@RequestMapping(value="finishsubject.action")
	public String Showsubject(String subid,String url,String pc,Model model,HttpSession session){
		Student student = (Student)session.getAttribute("Student");
		Pagebean page = new  Pagebean();
		int ps =0;
		ps = (pc==null? 1:Integer.parseInt(pc));
		Page<Topsubject> page2 = PageHelper.startPage(ps, 10);
		List<Topsubject> list = service.Showsubject(subid,student.getSno());
		page.setCurrentpage(ps);
		page.setRecordcount((int)page2.getTotal());
		page.setRecordpage(page2.getPageSize());
		page.setUrl(url);
		model.addAttribute("list",list);
		model.addAttribute("page", page);
		return "detail/Operation/finishsubject";
	}
	
	/*
	 * 1.显示没有完成的作业的科目
	 * 2.数据分页显示
	 */
	@RequestMapping(value="unsubject.action")
	public String SelectUnsubject(String pc,Model model,HttpSession session){
		Student student = (Student)session.getAttribute("Student");
		Pagebean page  = new Pagebean();
		int ps=0;
		ps= (pc==null ? 1: Integer.parseInt(pc));
		Page<SubjecteacherName> page2 = PageHelper.startPage(ps, 10);
		List<SubjecteacherName> list = service.SelectUnsubject(student.getSclassid(),student.getSno());
		page.setCurrentpage(ps);
		page.setRecordcount((int)page2.getTotal());
		page.setRecordpage(page2.getPageSize());
		model.addAttribute("list",list);
		model.addAttribute("page", page);
		return "detail/Operation/unsubject";
	}
	
	/*
	 * 1.显示未完成的科目 下的题目
	 * 2.数据分页显示
	 */
	@RequestMapping(value="unoperation.action")
	public String ShowUnsubject(String subid,String url,String pc,Model model,HttpSession session){
		Student student= (Student)session.getAttribute("Student");
		Pagebean page = new Pagebean();
		int ps =0;
		ps = (pc==null? 1 : Integer.parseInt(pc));
		Page<Topsubject> page2 = PageHelper.startPage(ps, 10);
		List<Topsubject> list = service.ShowUnsubject(student.getSclassid(), subid,student.getSno());
		page.setCurrentpage(ps);
		page.setRecordcount((int)page2.getTotal());
		page.setRecordpage(page2.getPageSize());
		page.setUrl(url);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "detail/Operation/unoperation";
	}
	
	/*
	 * 1.显示成绩
	 * 2.分页显示
	 */
	@RequestMapping(value="showscore.action")
	public String ShoeScore(String pc,Model model,HttpSession session){
		Student student=(Student)session.getAttribute("Student");
		Pagebean page = new Pagebean();
		int ps=0;
		ps=(pc==null? 1:Integer.parseInt(pc));
		Page<Subjectoptop> page2 = PageHelper.startPage(ps, 10);
		List<Subjectoptop> list = service.ShowScore(student.getSno());
		page.setCurrentpage(ps);
		page.setRecordcount((int)page2.getTotal());
		page.setRecordpage(page2.getPageSize());
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "detail/Score/showscore";
	}
	
	/*
	 * 视频播放
	 */
	@RequestMapping(value="playvideo.action")
	public String Playvideo(String opid,Model model){
		String src = service.Playadvieo(opid);
		model.addAttribute("src",src);
		return "forward:/WEB-INF/StudentCMSpage/detail/Operation/video.jsp";
	}
	
	
	//填写完答案进行提交保存
	@RequestMapping(value="insertresult.action")
	public String Insertresult(Result result,String re,HttpSession session){
		System.out.println(result.getRetext());
		if(re.equals("0")){
			int i = service.Insertresult(result);
			if(i==0)
				return "redirect:/error.jsp";
			else
				return "forward:/showsubject.action";
		}else{
			Student student = (Student)session.getAttribute("Student");
			int n = service.resubmitByopidsnoWithBLOBs(result.getOpid(), student.getSno(),result.getRetext());
			if(n==0){
				return "";
			}else{
				return "forward:/showsubject.action";
			}
		}
	}

	// 作业已经完成但并为进行打分，可以惊醒删除
	@RequestMapping(value="deleteoperation.action")
	public String Deleteresult(String opid,HttpSession session){
		Student student = (Student)session.getAttribute("Student");
		int n = service.Deleteoperation(opid, student.getSno());
		if(n==0)
			return "redirect:/error.jsp";
		else
			return "forward:/showsubject.action";
	}
	
}
