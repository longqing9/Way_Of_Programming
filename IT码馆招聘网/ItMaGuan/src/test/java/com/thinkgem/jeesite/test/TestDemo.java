package com.thinkgem.jeesite.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thinkgem.jeesite.modules.sys.entity.Area;
import com.thinkgem.jeesite.modules.sys.entity.VoArea;
import com.thinkgem.jeesite.modules.sys.service.AreaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = { "classpath:spring-context.xml" })
public class TestDemo {

	@Autowired
	private AreaService areaService;
	
	@Test
	public void test(){
		//{"updateDate":"2013-05-27 08:00:00","parentIds":"0,","sort":10,"type":"1","parentId":"0"}
		Area area=areaService.get("1");
		VoArea voarea=new VoArea();
		voarea.setId(area.getId());
		voarea.setCode(area.getCode());
		voarea.setCreateBy(area.getCreateBy());
		voarea.setCreateDate(area.getCreateDate());
		voarea.setCurrentUser(area.getCurrentUser());
		voarea.setDelFlag(area.getDelFlag());
		voarea.setIsNewRecord(area.getIsNewRecord());
		voarea.setName(area.getName());
		voarea.setUpdateDate(area.getUpdateDate());
		voarea.setParentIds(area.getParentIds());
		voarea.setSort(area.getSort());
		voarea.setType(area.getType());
		System.out.println(area.getParent());
	}
}
