package com.thinkgem.jeesite.frontWeb.entity;

import com.thinkgem.jeesite.modules.sob.entity.TbSob;
import com.thinkgem.jeesite.modules.sobz.entity.TbSobz;

public class TbsobtoSobz {
	
	
	public TbSobz getTbsobz(TbSob sob) {
		TbSobz sobz = new TbSobz();
		sobz.setCname(sob.getCname());
		sobz.setSpecialty(sob.getSpecialty());
		sobz.setJob(sob.getJob());
		sobz.setEmolument(sob.getEmolument());
		sobz.setWorkaddress(sob.getWorkaddress());
		sobz.setWorknow(sob.getWorknow());
		sobz.setJobnature(sob.getJobnature());
		sobz.setAppendixid(sob.getAppendixid());
		sobz.setManage(sob.getManage());
		sobz.setSpecialtyago(sob.getSpecialtyago());
		sobz.setSalary(sob.getSalary());
		sobz.setZwClass(sob.getZwClass());
		sobz.setJobmiaoshu(sob.getJobmiaoshu());
		sobz.setWorktime(sob.getWorktime());
		sobz.setProCompany(sob.getProCompany());
		sobz.setProDescripe(sob.getProDescripe());
		sobz.setProDuty(sob.getProDuty());
		sobz.setProName(sob.getProName());
		sobz.setProTime(sob.getProTime());
		sobz.setSchName(sob.getSchName());
		sobz.setSchProfe(sob.getSchProfe());
		sobz.setSchTime(sob.getSchTime());
		sobz.setIstzhao(sob.getIstzhao());
		sobz.setDegree(sob.getDegree());
		sobz.setPxTime(sob.getPxTime());
		sobz.setPxClass(sob.getPxClass());
		sobz.setPxJigou(sob.getPxJigou());
		sobz.setYyYuzhong(sob.getYyYuzhong());
		sobz.setYyTs(sob.getYyTs());
		sobz.setYyDx(sob.getYyDx());
		sobz.setZsName(sob.getZsName());
		sobz.setZsTime(sob.getZsTime());
		sobz.setSelfassess(sob.getSelfassess());
		return sobz;
	}

}
