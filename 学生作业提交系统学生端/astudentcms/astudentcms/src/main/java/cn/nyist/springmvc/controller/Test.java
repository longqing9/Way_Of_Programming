package cn.nyist.springmvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.nyist.springmvc.po.Student;
import cn.nyist.springmvc.po.StudentAccount;
import cn.nyist.springmvc.service.Userservice;



@Controller
public class Test {
	
	@Autowired
	private Userservice userservice;
	
	@RequestMapping(value="/submit/user.action")
	public ModelAndView User(){
		List<StudentAccount> list = userservice.selectuser();
		ModelAndView mav = new ModelAndView();
		mav.addObject("userlist",list);
		mav.setViewName("index");
		return mav;
	}
	
	
	//用户登录
	@RequestMapping(value="/finduser.action")
	public String Login(StudentAccount studentaccount,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		StudentAccount  s;
		s=userservice.finduser(studentaccount);
		if(s!=null){
			return "redirect:/getusername.action?sno="+s.getSno();
		}
		else {
			request.setAttribute("ts", "账号或密码错误，请重新登录");	
			return "forward:/login.jsp";
		}
	}
	
	//登录成功进入到首页
	@RequestMapping(value="/getusername.action")
	public String GetName(String sno,HttpServletRequest request){
		Student student= userservice.Getuser(sno);
		request.getSession().setAttribute("Student", student);
		return "index";
	}
	
	/*
	 * 退出
	 */
	@RequestMapping(value="logout.action")
	public void Logout(HttpSession session,HttpServletResponse resp) throws IOException{
		session.removeAttribute("Student");
		resp.sendRedirect("login.jsp");
	}
}
