package com.thinkgem.jeesite.frontWeb;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.frontWeb.entity.Cjob;
import com.thinkgem.jeesite.frontWeb.entity.TbsobtoSobz;
import com.thinkgem.jeesite.frontWeb.entity.Tbstudz;
import com.thinkgem.jeesite.frontWeb.entity.Transformation;
import com.thinkgem.jeesite.frontWeb.service.CjobService;
import com.thinkgem.jeesite.modules.apply.entity.TbApply;
import com.thinkgem.jeesite.modules.apply.service.TbApplyService;
import com.thinkgem.jeesite.modules.cjob.entity.TbCjob;
import com.thinkgem.jeesite.modules.cjob.service.TbCjobService;
import com.thinkgem.jeesite.modules.collect.entity.TbCollect;
import com.thinkgem.jeesite.modules.collect.service.TbCollectService;
import com.thinkgem.jeesite.modules.company.entity.TbCompany;
import com.thinkgem.jeesite.modules.company.service.TbCompanyService;
import com.thinkgem.jeesite.modules.sob.entity.TbSob;
import com.thinkgem.jeesite.modules.sob.service.TbSobService;
import com.thinkgem.jeesite.modules.sobz.entity.TbSobz;
import com.thinkgem.jeesite.modules.sobz.service.TbSobzService;
import com.thinkgem.jeesite.modules.stud.entity.TbStudent;
import com.thinkgem.jeesite.modules.stud.service.TbStudentService;




/*
 * controller层为用户的控制层
 */
@Controller
public class StuController {
	
	@Autowired
	private TbStudentService tbstudentService;
	
	@Autowired
	private TbSobService tbsobService;
	
	@Autowired
	private TbCjobService tbcjobservice;
	
	@Autowired
	private TbCompanyService tbcompanyservice;
	
	@Autowired
	private TbApplyService tbapplyservice;
	
	@Autowired
	private TbCollectService tbcollectservice;
	
	@Autowired
	private TbSobzService tbsobzservice;
	
	@Autowired
	private CjobService cjobservice;
	
	
	//个人进入用户注册页面
	@RequestMapping(value="Gostudregister")
	public String Gostudregister() {
		return "frontPages/p_register";
	}
	
	
	//保存注册页面提交的数据并进行已存在校验
	@RequestMapping(value="SaveStudregister")
	public String SaveStudregister(TbStudent student,Model model) {
		TbStudent stud1 = new TbStudent();
		stud1.setStudentid(student.getStudentid());
		List<TbStudent> findList = tbstudentService.findList(stud1);
		if (null==findList || findList.size()==0) {
			tbstudentService.save(student);
			return "forward:/Toindex";
		} else {
			model.addAttribute("stip", "该账号已存在，请重新注册！");
			return "frontPages/p_register";
		}
	}
	
	
	
	
	//用户登录校验
	@RequestMapping(value="Stulogin")
	public String Stulogin(String username,String password,HttpServletRequest request,Model model) {
			if(username!=null&&password!=null) {
				TbStudent tbstudent = new TbStudent();
				tbstudent.setStudentid(username);
				tbstudent.setPassword(password);
				List<TbStudent> findList = tbstudentService.findList(tbstudent);
				if(null==findList || findList.size()==0) {
					model.addAttribute("tips", "账号或密码输入错误");
					return "forward:/Toindex";
				}else {
					request.getSession().setAttribute("user", findList.get(0));
					return "frontPages/p_index";
				}
			}else {
				model.addAttribute("tips", "请输入账号或密码");
				return "forward:/Toindex";
			}
	}
	
	
	//退出
	@RequestMapping(value="Stulogout")
	public String Stulogout(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "forward:/Toindex";
	}
	
	//查看个人信息
	@RequestMapping(value="ShowStuinformation")
	public String ShowStuinformation(HttpServletRequest request,Model model) {
		TbStudent student = (TbStudent)request.getSession().getAttribute("user");
		TbStudent tbStudent = tbstudentService.get(student.getId());
		model.addAttribute("stud", tbStudent);
		return "frontPages/p_information";
	}
	
	//修改个人信息---跳转到修改页面并在修改页面显示原有数据
	@RequestMapping(value="ToStuP_reviseinformation")
	public String ToStuP_reviseinformation(HttpServletRequest request,Model model) {
		TbStudent stud = (TbStudent)request.getSession().getAttribute("user");
		TbStudent tbStudent = tbstudentService.get(stud.getId());
		model.addAttribute("stud", tbStudent);
		return "frontPages/p_reviseinformation";
	}
	
	//修个人信息---提交表单
	@RequestMapping(value="SaveStuinformation")
	public String SaveStuinformation(Tbstudz st,HttpServletRequest request) {
		Transformation transformation = new Transformation();
		TbStudent stud = transformation.getTbStudent(st);
		TbStudent student = (TbStudent)request.getSession().getAttribute("user");
		stud.setId(student.getId());
		stud.setStudentid(student.getStudentid());
		stud.setPassword(student.getPassword());
		tbstudentService.save(stud);
		return "forward:/ShowStuinformation";
	}
	
	
	//修改个人简历---跳转到修改简历页面
	@RequestMapping(value="AddSturesume")
	public String AddSturesume(HttpServletRequest request,Model model) {
		TbStudent stud = (TbStudent) request.getSession().getAttribute("user");
		TbStudent stud1=tbstudentService.get(stud.getId());
		TbSob tbsob = new TbSob();
		tbsob.setStudentid(stud.getStudentid());
		List<TbSob> findList = tbsobService.findList(tbsob);
		if(null!=findList && findList.size()!=0) {
			model.addAttribute("sob", findList.get(0));
		}
		model.addAttribute("stud", stud1);
		return "frontPages/p_myresume";
		
	}
	
	
	//修改完善个人简历---表单的提交页面
	@RequestMapping(value="saveStudresume")
	public String SaveStudresume(TbSob sob,HttpServletRequest request,Model model) {
		System.out.println(sob.toString());
		TbSob tbsob = new TbSob();
		TbStudent stud = (TbStudent) request.getSession().getAttribute("user");
		tbsob.setStudentid(stud.getStudentid());
		List<TbSob> findList = tbsobService.findList(tbsob);
		sob.setStudentid(stud.getStudentid());
		if(null==findList || findList.size()==0) {
			tbsobService.save(sob);
		}else {
			sob.setId(findList.get(0).getId());
			tbsobService.save(sob);
		}
		TbStudent tbStudent = tbstudentService.get(stud.getId());
		List<TbSob> list = tbsobService.findList(tbsob);
		model.addAttribute("stud", tbStudent);
		model.addAttribute("sob", list.get(0));
		return "frontPages/p_showmyresume";
	}
	
	//查看个人简历
	@RequestMapping(value="Showstudresume")
	public String Showstudresume(HttpServletRequest request,Model model) {
		TbStudent student = (TbStudent) request.getSession().getAttribute("user");
		TbSob sob = new TbSob();
		sob.setStudentid(student.getStudentid());
		TbStudent tbStudent = tbstudentService.get(student.getId());
		request.getSession().setAttribute("stud", tbStudent);
		List<TbSob> findList = tbsobService.findList(sob);
		if(null==findList || findList.size()==0) {
			return "frontPages/p_showmyresume";
		}
		model.addAttribute("sob", findList.get(0));
		return "frontPages/p_showmyresume";
	}
	
	//浏览招聘信息
	@RequestMapping(value="ShowStudrecruit")
	public String ShowStudrecruit(TbCjob tbCjob,HttpServletRequest request, HttpServletResponse response, Model model) {
		
		Page<TbCjob> findPage = tbcjobservice.findPage(new Page<TbCjob>(request, response), tbCjob);
		model.addAttribute("findPage", findPage);
		return "frontPages/p_showrecruit";
	}
	
	//查看公司详细信息
	@RequestMapping(value="ShowStudcompanyinformation")
	public String ShowStudcompanyinformation(String companyid,HttpServletRequest request,Model model) {
		TbCompany tbcompany = new TbCompany();
		tbcompany.setCompanyid(companyid);
		List<TbCompany> findList = tbcompanyservice.findList(tbcompany);
		model.addAttribute("company", findList.get(0));
		return "frontPages/p_companyinformation";
	}
	
	
	/**
	 * 用户申请工作职位---判断简历是否完善---->该职位是否已经申请---->是否保存
	 * 
	 * @param id
	 * @param companyid
	 * @param request
	 * @return 提示信息
	 */
	@RequestMapping(value="StudmyApply")
	@ResponseBody
	public String StudmyApply(String id,String companyid,HttpServletRequest request) {
		TbStudent stud = (TbStudent) request.getSession().getAttribute("user");
		TbSob sob = new TbSob();
		sob.setStudentid(stud.getStudentid());
		List<TbSob> findList2 = tbsobService.findList(sob);
		if(findList2 == null || findList2.size()==0){
			return "请先完善简历信息";
		}
		TbSobz sobz = new TbSobz();
		sobz.setCompanyid(companyid);
		sobz.setJobid(id);
		sobz.setStudentid(stud.getStudentid());
		List<TbSobz> findList = tbsobzservice.findList(sobz);
		if(findList == null || !(findList.size()>0)){
			TbApply apply = new TbApply();
			apply.setCjobid(id);
			apply.setCompanyid(companyid);
			apply.setStudentid(companyid);
			tbapplyservice.save(apply);
			TbsobtoSobz tss = new TbsobtoSobz();
			TbSobz sobz2 = tss.getTbsobz(findList2.get(0));
			sobz2.setCompanyid(companyid);
			sobz2.setJobid(id);
			sobz2.setStudentid(stud.getStudentid());
			tbsobzservice.save(sobz2);
			return "申请成功";
		}
		return "已申请";
	}
	
	
	//用户职位收藏功能
	@RequestMapping(value="Studmycollect")
	@ResponseBody
	public String Studmycollect(String id,HttpServletRequest request) {
		TbStudent stud = (TbStudent)request.getSession().getAttribute("user");
		TbCollect collect = new TbCollect();
		collect.setCjobid(id);
		collect.setStudentid(stud.getStudentid());
		List<TbCollect> findList = tbcollectservice.findList(collect);
		if(findList == null || !(findList.size()>0)){
			tbcollectservice.save(collect);
			return "收藏成功";
		}	
		return "已收藏";
	}
	
	//浏览招聘的详细信息
	@RequestMapping(value="Showstudrecruit")
	public String Showstudrecruit(String id,HttpServletRequest request,Model model) {
		request.getSession().removeAttribute("cjob");
		TbCjob tbCjob = tbcjobservice.get(id);
		model.addAttribute("cjob", tbCjob);
		return "frontPages/p_deresume";
	}
	
	//我的申请 子菜单-------------前台显示的数据是：Tbcjob中的数据
	@RequestMapping(value="MyApply")
	public String MyApply(TbStudent tbStudent, HttpServletRequest request, HttpServletResponse response, Model model) {
		TbStudent student = (TbStudent) request.getSession().getAttribute("user");
		String studentid = student.getStudentid();
		Cjob cjob = new Cjob();
		cjob.setIid(studentid);
		Page<Cjob> findPage = cjobservice.findPage(new Page<Cjob>(request, response), cjob);
		model.addAttribute("findPage", findPage);		
		return "frontPages/p_myapply";
	}
	
	//我的收藏 子菜单
	@RequestMapping(value="Mycollection")
	public String Mycollection(TbCjob tbCjob, HttpServletRequest request, HttpServletResponse response, Model model) {	
		TbStudent student = (TbStudent) request.getSession().getAttribute("user");
		String studentid = student.getStudentid();
		tbCjob = new TbCjob();
		tbCjob.setIid(studentid);
		Page<TbCjob> findPageT = tbcjobservice.findPageT(new Page<TbCjob>(request, response), tbCjob);
		model.addAttribute("findPageT", findPageT);	
		return "frontPages/p_mycollect";
	}
	
	
	//取消收藏
	@RequestMapping(value="Deletecollect")
	@ResponseBody
	public String Deletecollect(String id,HttpServletRequest request) {
		TbStudent student = (TbStudent) request.getSession().getAttribute("user");
		TbCollect tbCollect = new TbCollect();
		tbCollect.setCjobid(id);
		tbCollect.setStudentid(student.getStudentid());
		List<TbCollect> findList = tbcollectservice.findList(tbCollect);
		tbcollectservice.delete(findList.get(0));
		return "取消成功";
	}
	
	
	
}
