package cn.nyist.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.nyist.springmvc.domain.Studentinfor;
import cn.nyist.springmvc.po.Student;
import cn.nyist.springmvc.po.StudentAccount;
import cn.nyist.springmvc.service.Userservice;

@Controller
public class PIM {
	
	@Autowired
	private Userservice service;
	

	//查看用户自己的基本信息
	@RequestMapping(value="/selectinformation.action")
	public String selectinformation(Model model,HttpServletRequest request){	
		HttpSession session = request.getSession();
		Student student= (Student)session.getAttribute("Student");
		Studentinfor studentinfor = service.getstudentinfor(student.getSno());
		model.addAttribute("Student",studentinfor);
		
		return "detail/PIM/information";
		
		
	}
	
	//进入到个人信息修改页面
	@RequestMapping(value="updateinformation.action")
	public String updateinformation(HttpServletRequest request,Model model){
		HttpSession session = request.getSession();
		Student student= (Student)session.getAttribute("Student");
		Student getuser = service.Getuser(student.getSno().toString());
		getuser.setClassname(service.getClassname(student.getSclassid()));
		model.addAttribute("user",getuser);
		return "detail/PIM/updateinformation";
	}
	
	//将修改后的数据信息进行保存
	@RequestMapping(value="toupdateinformation.action")
	public String Submitupdateinformation(Student student,@RequestParam MultipartFile pictureFile,HttpSession session) throws Exception{
		Student st = (Student)session.getAttribute("Student");
		if(pictureFile.isEmpty()) {
			Student getuser = service.Getuser(st.getSno().toString());
			student.setSpic(getuser.getSpic());
		}else {
			String name = UUID.randomUUID().toString().replace("-","");
			String ext =FilenameUtils.getExtension(pictureFile.getOriginalFilename());
			pictureFile.transferTo(new File("F:\\pic\\"+name+"."+ext));
			student.setSpic(name+"."+ext);
		}
		student.setSno(st.getSno());
		int i = service.toUpdateinformation(student);
		if(i==1)
			return "redirect:/clstudentinformation.action?sno="+st.getSno();
		else{
			return "redirect:/error.jsp";
		}
	}
	
	//用户修改密码
	@RequestMapping(value="resetpsd.action")
	public void Resetpsd(StudentAccount stu,String newpassword,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8;");
		StudentAccount user = service.finduser(stu);
		if(stu!=null){
			user.setPassword(newpassword);
			 service.resetpsd(user);
			response.getWriter().write("<script language='javascript' type='text/javascript'>alert('密码修改成功，请牢记新密码');window.location.href= 'StudentCMSpage/detail/PIM/resetpsd.jsp'</script>");
		}else{
			response.getWriter().write("<script language='javascript' type='text/javascript'>alert('请输入账号');window.location.href= 'history.back()'</script>");
		}
	}
	
	//将页面跳转到修改密码页面
	@RequestMapping(value="toresetpage.action")
	public String toResetpsdpage(){
		return "detail/PIM/resetpsd";
	}
	
	

}
