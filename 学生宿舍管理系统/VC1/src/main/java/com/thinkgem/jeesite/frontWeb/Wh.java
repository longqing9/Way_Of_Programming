package com.thinkgem.jeesite.frontWeb;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.frontWeb.entity.TabAccount;
import com.thinkgem.jeesite.frontWeb.service.TabAccountService;
import com.thinkgem.jeesite.modules.emal.entity.Emal;
import com.thinkgem.jeesite.modules.emal.service.EmalService;
import com.thinkgem.jeesite.modules.examine.entity.Examine;
import com.thinkgem.jeesite.modules.examine.service.ExamineService;
import com.thinkgem.jeesite.modules.inform.entity.Inform;
import com.thinkgem.jeesite.modules.inform.service.InformService;
import com.thinkgem.jeesite.modules.mess.entity.Mess;
import com.thinkgem.jeesite.modules.mess.service.MessService;

@Controller
public class Wh {
	
	@Autowired
	private InformService informService;
	
	@Autowired
	private ExamineService examineService;
	
	@Autowired
	private TabAccountService tabAccountService;
	
	@Autowired
	private EmalService emalService;
	
	@Autowired
	private MessService messService;
	
	//跳转到登录页面
	@RequestMapping(value="${frontPath}")
	public String wh(){
		return "frontPages/login1";
	}
	
	@RequestMapping(value="Logout")
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute("stud");
		return "frontPages/login1";
	}
	
	@RequestMapping(value="gomain")
	public String Main() {
		return "frontPages/index1";
	}
	
	
	
	//跳转到消息通知页面
	@RequestMapping(value="/tz")
	public String tz(Model model){
		Inform inform = new Inform();
		List<Inform> findList = informService.findList(inform);
		model.addAttribute("findList", findList);
		return "frontPages/tongzhi";
	}
	
	//跳转到消息通知页面
	@RequestMapping(value="/qk")
	public String qk(Model model){
		Examine examine = new Examine();
		List<Examine> findList = examineService.findList(examine);
		model.addAttribute("findList", findList);
		return "frontPages/qingkuang";
	}
	
	//跳转到写邮件页面
	@RequestMapping(value="/yj")
	public String yj(Model model,HttpServletRequest request){
		TabAccount stud = (TabAccount)request.getSession().getAttribute("stud");
		model.addAttribute("account", stud.getAccount());
		model.addAttribute("password", stud.getPassword());
		return "frontPages/youjian";
	}
	
	//保存邮件，并跳回首页
	@RequestMapping(value="/youjian")
	public String youjian(HttpServletRequest request,String title,String nr,Model model){	
		TabAccount stud = (TabAccount)request.getSession().getAttribute("stud");
		TabAccount accountA = new TabAccount();
		accountA.setAccount(stud.getAccount());
		accountA.setPassword(stud.getPassword());
		TabAccount findAccount = tabAccountService.findAccount(accountA);
		if(findAccount == null){
			return "frontPages/login1";
		}
		Emal emal = new Emal();
		emal.setTitle(title);
		emal.setNr(nr);
		emal.setTime(new Date());
		emal.setXx(findAccount.getDurmnumber()+"/"+findAccount.getName());
		emalService.save(emal);	
		model.addAttribute("account", findAccount);
		return "redirect:/gomain";
	}
	
	//跳转到留言板
	@RequestMapping(value="/ShowallMess")
	public String ShowallMess(Model model){
		List<Mess> findList = messService.findList(new Mess());
		model.addAttribute("findList", findList);
		return "frontPages/allMess";
	}
	
	//跳转到添加留言
	@RequestMapping(value="/AddMess")
	public String AddMess(Model model){
		return "frontPages/addMess";
	}
	
	//添加留言
	@RequestMapping(value="/SaveMess")
	public String SaveMess(Model model,String neir,HttpServletRequest request){
		TabAccount stud = (TabAccount)request.getSession().getAttribute("stud");
		Mess mess = new Mess();
		mess.setNeir(neir);
		mess.setXinx(stud.getAccount()+","+stud.getDurmnumber());
		messService.save(mess);
		return "redirect:/ShowallMess";
	}
	
}
