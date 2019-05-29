package com.thinkgem.jeesite.frontWeb.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.thinkgem.jeesite.modules.stud.entity.TbStudent;

public class Transformation {
	
	public TbStudent getTbStudent(Tbstudz tbs) {
		TbStudent stud =new TbStudent();
		stud.setName(tbs.getName());
		stud.setSex(tbs.getSex());
		stud.setAge(tbs.getAge());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
        	System.out.println("----------------------------------");
        	System.out.println(tbs.getBirthday());
        	stud.setBirthday(sdf.parse(tbs.getBirthday()));
        	stud.setWorktime(sdf.parse(tbs.getWorktime()));
        	stud.setHuji(tbs.getHuji());
        	stud.setNowadress(tbs.getNowadress());
        	stud.setKnowledge(tbs.getKnowledge());
        	stud.setTell(tbs.getTell());
        	stud.setEmail(tbs.getEmail());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return stud;
	}
	

}
