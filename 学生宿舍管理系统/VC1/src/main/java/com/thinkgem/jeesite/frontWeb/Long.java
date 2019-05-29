package com.thinkgem.jeesite.frontWeb;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.frontWeb.entity.TabAccount;
import com.thinkgem.jeesite.modules.abxiu.entity.Abxiu;
import com.thinkgem.jeesite.modules.abxiu.service.AbxiuService;
import com.thinkgem.jeesite.modules.memorandum.entity.Memorandum;
import com.thinkgem.jeesite.modules.memorandum.service.MemorandumService;
import com.thinkgem.jeesite.modules.resour.entity.Resources;
import com.thinkgem.jeesite.modules.resour.service.ResourcesService;

@Controller
public class Long {

	@Autowired
	private AbxiuService abxiuservice;
	
	@Autowired
	private MemorandumService memorandumservice;
	
	@Autowired
	private ResourcesService resource;
	
	//跳转到添加报修订单页面
	@RequestMapping(value="Addbaoxiu")
	public String Addbaoxiu() {
		return "frontPages/addbxiu";
	}
	
	//报修订单表单的提交
	@RequestMapping(value="Savebaoxiu")
	public String Savebaoxiu(Abxiu bx,HttpServletRequest request) {
		TabAccount stud = (TabAccount)request.getSession().getAttribute("stud");
		Date date = new Date();
		bx.setApplyid(stud.getAccount());
		bx.setTime(date.toString());
		
		System.out.println(bx.toString());
		abxiuservice.save(bx);
		return "frontPages/index";
	}
	
	//报修结束
	@RequestMapping(value="Endbaoxiu")
	public String Endbaoxiu(HttpServletRequest request) {
		TabAccount stud = (TabAccount) request.getSession().getAttribute("stud");
		Abxiu bx = new Abxiu();
		bx.setApplyid(stud.getAccount());
		System.out.println(bx.toString());
		List<Abxiu> findList = abxiuservice.findList(bx);
		if(null==findList || findList.size()==0) {
			request.getSession().removeAttribute("tip");
			request.getSession().setAttribute("tip", "1");
		}else {
			request.getSession().removeAttribute("tip");
			request.getSession().setAttribute("tip", "0");
			request.getSession().setAttribute("bx", findList);
		}
		return "frontPages/bxiuend";
	}
	
	
	//提交结束表单页面进入满意度评价页面
	@RequestMapping(value="Savebxiuend")
	public String Savebxiuend(String id,HttpServletRequest request) {
		Abxiu abxiu = abxiuservice.get(id);
		abxiu.setIsok("ok");
		abxiuservice.save(abxiu);
		request.getSession().setAttribute("id", id);
		return "frontPages/bxiupingjia";
	}
	
	//提交满意度评价表单
	@RequestMapping(value="Savepingjia")
	public String Savepingjia(String id,String score) {
		Abxiu abxiu = abxiuservice.get(id);
		abxiu.setScore(score);
		abxiuservice.save(abxiu);
		return "redirect:/gomain";
	}
	
	
	//备忘录功能
	@RequestMapping(value="ShowallMemorandum")
	public String ShowallMemoran(Model model,HttpServletRequest request) {
		TabAccount stud = (TabAccount) request.getSession().getAttribute("stud");
		Memorandum me = new Memorandum();
		me.setAccount(stud.getAccount());
		List<Memorandum> findList = memorandumservice.findList(me);
		if(null==findList || findList.size()==0) {
			model.addAttribute("tip", "0");
		}else {
			model.addAttribute("tip", "1");
			model.addAttribute("list", findList);
		}
		return "frontPages/ShowAllmemorandum";
		
	}
	
	
	//添加备忘录内容
		@RequestMapping(value="Addmemo")
		public String Addmemo() {
			return "frontPages/Memorandum";
		}
	
	//查看信息备忘录内容
	@RequestMapping(value="detailmemo")
	public String detailmemo(Memorandum bwl,Model model) {
		Memorandum memorandum = memorandumservice.get(bwl);
		model.addAttribute("bwl", memorandum);
		return "frontPages/Memorandum";
	}
	
	//保存备忘信息
	@RequestMapping("SaveMemorandum")
	public String SaveMemorandum(Memorandum memorandum,HttpServletRequest request) {
		TabAccount stud = (TabAccount) request.getSession().getAttribute("stud");
		memorandum.setAccount(stud.getAccount());
		memorandumservice.save(memorandum);
		return "forward:/ShowallMemorandum";
	}
	
	//删除备忘录
	@RequestMapping("Deletebwl")
	public String Deletebwl(Memorandum memorandum) {
		memorandumservice.delete(memorandum);
		return "forward:/ShowallMemorandum";
	}
	
	
	//-----------------资源链接--------------------------------

	//查看
	@RequestMapping("showresource")
	public String ShowResource(Model model) {
		Resources resources = new Resources();
		List<Resources> list = resource.findList(resources);
		for (Resources r : list) {
			System.out.println(r.toString());
		}
		model.addAttribute("list", list);
		
		return "frontPages/resource";
	}
	
	
	
}
