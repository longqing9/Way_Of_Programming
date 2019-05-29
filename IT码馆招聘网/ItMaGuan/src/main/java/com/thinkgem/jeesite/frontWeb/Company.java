package com.thinkgem.jeesite.frontWeb;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.modules.company.entity.TbCompany;
import com.thinkgem.jeesite.modules.company.service.TbCompanyService;
import com.thinkgem.jeesite.modules.sobz.entity.TbSobz;
import com.thinkgem.jeesite.modules.sobz.service.TbSobzService;

@Controller
public class Company {
	
	@Autowired
	private TbCompanyService tbCompanyService;
	
	@Autowired
	private TbSobzService tbsobzservice;

	
	
	//企业用户注册
	@RequestMapping(value="firmregister")
	public String firmregister(TbCompany company,Model model) {
		TbCompany comup = new TbCompany();
		comup.setCompanyid(company.getCompanyid());
		List<TbCompany> findList = tbCompanyService.findList(comup);
		if(null==findList || findList.size()==0) {
			tbCompanyService.save(company);
			return "frontPages/firmlogin";
		}else {
			model.addAttribute("tip", "该账号ID已存在，请重新注册");
			return "frontPages/firmregister";
		}
	}
	
	
	
	//登录
	@RequestMapping(value="comlogin")
	public String Login(String username,String password,HttpServletRequest request,Model model) {
		TbCompany tbCompany = new TbCompany();
		tbCompany.setCompanyid(username);
		tbCompany.setPassword(password);
		List<TbCompany> findList = tbCompanyService.findList(tbCompany);
		if(null==findList || findList.size()==0) {
			model.addAttribute("tips", "账号或密码输入错误");
			return "forward:/Company_login.action";
		}else {
			request.getSession().setAttribute("mycompany", findList.get(0));
			return "forward:/Com_firmHomepage.action";
		}
	}
	
	
	//查看公司信息
	@RequestMapping(value="Show_companyinformation")
	public String ShowCompanyinformation(HttpServletRequest request,Model model) {
		TbCompany company = (TbCompany) request.getSession().getAttribute("mycompany");
		TbCompany tbCompany = tbCompanyService.get(company.getId());
		model.addAttribute("company", tbCompany);
		return "frontPages/company_information";
	}
	
	//修改公司信息---跳转到信息修改页面
	@RequestMapping(value="Change_companyinformation")
	public String ChangeCompanyInformation(HttpServletRequest request,Model model) {
		TbCompany company = (TbCompany) request.getSession().getAttribute("mycompany");
		TbCompany tbCompany = tbCompanyService.get(company.getId());
		model.addAttribute("company", tbCompany);
		return "frontPages/changeCominformation";
	}
	
	//修改公司信息--提交表单，保存数据
	@RequestMapping(value="Save_companyinformation")
	public String SaveCompanyinformation(TbCompany tbCompany,HttpServletRequest request) {
		TbCompany company = (TbCompany) request.getSession().getAttribute("mycompany");
		tbCompany.setId(company.getId());
		tbCompany.setCompanyid(company.getCompanyid());
		tbCompany.setPassword(company.getPassword());
		tbCompanyService.save(tbCompany);
		return "forward:/Show_companyinformation";
	}
	
	
	//表单异步提交---简历状态
	@RequestMapping(value="Saveresumeother")
	@ResponseBody
	public String Saveresumeother(String id,String other) {
		TbSobz sobz =new TbSobz();
		sobz.setId(id);
		sobz.setOther(other);
		tbsobzservice.updateother(sobz);
		return "保存成功";
	}
	
	
	
}
