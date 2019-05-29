package com.thinkgem.jeesite.frontWeb;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.frontWeb.entity.ShowTow;
import com.thinkgem.jeesite.frontWeb.entity.TableCompany;
import com.thinkgem.jeesite.frontWeb.service.Tableservice;
import com.thinkgem.jeesite.modules.cjob.entity.TbCjob;
import com.thinkgem.jeesite.modules.cjob.service.TbCjobService;
import com.thinkgem.jeesite.modules.company.entity.TbCompany;
import com.thinkgem.jeesite.modules.company.service.TbCompanyService;
import com.thinkgem.jeesite.modules.sobz.entity.TbSobz;
import com.thinkgem.jeesite.modules.sobz.service.TbSobzService;
import com.thinkgem.jeesite.modules.stud.entity.TbStudent;
import com.thinkgem.jeesite.modules.stud.service.TbStudentService;

@Controller
public class Tbcjob {
	
	@Autowired
	private TbCjobService tbCjobService;
	
	@Autowired
	private Tableservice tableservice;
	
	@Autowired
	private TbCompanyService tbCompanyService;
	
	@Autowired
	private TbSobzService tbSobzService;
	@Autowired
	private TbStudentService tbStudentService;
	
	//填写招聘信息---跳转到填写招聘信息页面
	@RequestMapping(value="AddRecruitmentInformation")
	public String AddRecruitmentInformation() {
		return "frontPages/recruitmentinformation";
	}
	
	//填写招聘信息---表单提交
	@RequestMapping(value="SaveRecruitmentInformation")
	public String SaveRecruitmentInformation(TbCjob tbCjob,HttpServletRequest request) {
		TbCompany company = (TbCompany) request.getSession().getAttribute("mycompany");
		tbCjob.setCompanyid(company.getCompanyid());
		tbCjob.setComname(company.getName());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = dateFormat.format(new Date());
		tbCjob.setPtime(time);
		tbCjobService.save(tbCjob);
		return "forward:/Allcompanyrecruitment";
	}
	
	//查看本公司发布的所有的招聘信息
	@RequestMapping(value="Allcompanyrecruitment")
	public String Allcompanyrecruitment(TbCjob tbCjob, HttpServletRequest request, HttpServletResponse response, Model model) {
		/*TbCjob job =new TbCjob();*/
		TbCompany company= (TbCompany) request.getSession().getAttribute("mycompany");
		tbCjob.setCompanyid(company.getCompanyid());
		Page<TbCjob> page = tbCjobService.findPage(new Page<TbCjob>(request, response), tbCjob); 
		model.addAttribute("job", page);
		return "frontPages/allcompanyrecruitment";
	}
	
	
	/*
	 * 
	 * <-----------------
	 * 
	 * 当公司删除招聘信息时，会在Tb_sobz中顺便删除所有有关该条招聘信息的申请
	 * ---未实现顺便删除申请信息
	 * ----测试过程--删除以实现
	 * ----------------->
	 */
	//删除发布的招聘
	@RequestMapping(value="Deletecompanyrecryitment")
	public String Deletecompanyrecryitment(String id) {
		TbCjob tbCjob = new TbCjob();
		TbSobz tbsobz = new TbSobz();
		tbCjob.setId(id);
		tbsobz.setJobid(id);
		List<TbSobz> list = tbSobzService.findList(tbsobz);
		for (TbSobz Sobz : list) {
			tbSobzService.delete(Sobz);
		}
		tbCjobService.delete(tbCjob);
		return "forward:/Allcompanyrecruitment";
	}
	
	
	//查看招聘的详细信息
	@RequestMapping(value="Showdetailedresume")
	public String Showdetailedresume(String id,HttpServletRequest request,Model model) {
		TbCjob tbCjob = tbCjobService.get(id);
		model.addAttribute("cjob", tbCjob);
		return "frontPages/detailedresume";
	}
	
	
	//修改发布的招聘信息--跳转到招聘信息修改页面
	@RequestMapping(value="Changerecruitment")
	public String Changerecruitment(String id,HttpServletRequest request,Model model) {
		TbCjob tbCjob = tbCjobService.get(id);
		model.addAttribute("cjob", tbCjob);
		return "frontPages/changerecruitment";
	}
	
	//某一公司查看所有公司发布的招聘信息
	@RequestMapping(value="ShowAllrecruitment")
	public String ShowAllrecruitment(TbCjob tbCjob, HttpServletRequest request, HttpServletResponse response, Model model) {
		
		Page<TbCjob> page = tbCjobService.findPage(new Page<TbCjob>(request, response), tbCjob); 
		model.addAttribute("job", page);
		return "frontPages/checkrecruitment";
	}
	
	
	//查看所有发布招聘信息的公司
	@RequestMapping(value="ShowOthercompanyInformation")
	public String ShowOthercompanyInformation(TableCompany tbCompany, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TableCompany> findPage = tableservice.findPage(new Page<TableCompany>(request, response), tbCompany);
		model.addAttribute("company", findPage);
		return "frontPages/allcompanyinformation";
	}
	
	//查看某一公司内的详细信息
	@RequestMapping(value="Showdetailcompanyinformation")
	public String Showdetailcompanyinformation(String id,Model model) {
		TbCompany tbCompany = tbCompanyService.get(id);
		model.addAttribute("company", tbCompany);
		return "frontPages/company_information";
	}
	
	@RequestMapping(value="ShowComcompanyinformation")
	public String ShowComcompanyinformation(String companyid,HttpServletRequest request,Model model) {
		TbCompany tbcompany = new TbCompany();
		tbcompany.setCompanyid(companyid);
		List<TbCompany> findList = tbCompanyService.findList(tbcompany);
		model.addAttribute("company", findList.get(0));
		return "frontPages/company_information";
	}
	
	//查看申请人信息
	@RequestMapping(value="Show")
	public String Show(TbSobz tbSobz, HttpServletRequest request, HttpServletResponse response, Model model) {
		TbCompany company= (TbCompany) request.getSession().getAttribute("mycompany");
		tbSobz.setCompanyid(company.getCompanyid());		
		Page<TbSobz> findPage = tbSobzService.findPage(new Page<TbSobz>(request, response), tbSobz);
		List<TbStudent> fingListT = new ArrayList<TbStudent>();
		List<TbSobz> list = findPage.getList();
		for(int i=0;i<list.size();i++){
			String studentid = list.get(i).getStudentid();
			TbStudent tbStudent = new TbStudent();
			tbStudent.setStudentid(studentid);
			TbStudent studentId2 = tbStudentService.getStudentId(tbStudent);
			fingListT.add(i, studentId2);
		}
		//第二个查询手动加上分页的内容（limit 开始行  查询数）
		//然后遍历将值存入下面的list集合
		//查看一下两个SQL语句是否对应，不对应的话在想解决分页的办法
		List<ShowTow> showList = new ArrayList<ShowTow>();
		ShowTow e = new ShowTow();
		for(int i=0;i<list.size();i++){
			e.setTbSobz(list.get(i));
			e.setTbStudent(fingListT.get(i));
			showList.add(e);
		}
		model.addAttribute("shpwList", showList);
		model.addAttribute("findPage", findPage);
		return "frontPages/showapplicant";
	}
	
	//查看职位申请人的详细信息，包括个人基本信息以及申请人的简历信息
	@RequestMapping(value="ComShowstuinformation")
	public String ComShowstuinformation(String studid,String sobzid,Model model) {
		TbStudent tbStudent = tbStudentService.get(studid);
		TbSobz tbSobz = tbSobzService.get(sobzid);
		model.addAttribute("stud", tbStudent);
		model.addAttribute("sobz", tbSobz);
		return "frontPages/resume";
	}
	
	
	
}
