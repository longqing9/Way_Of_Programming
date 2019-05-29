/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.abxiu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.abxiu.entity.Abxiu;
import com.thinkgem.jeesite.modules.abxiu.dao.AbxiuDao;

/**
 * 报修登记表Service
 * @author a
 * @version 2019-03-11
 */
@Service
@Transactional(readOnly = true)
public class AbxiuService extends CrudService<AbxiuDao, Abxiu> {

	public Abxiu get(String id) {
		return super.get(id);
	}
	
	public List<Abxiu> findList(Abxiu abxiu) {
		return super.findList(abxiu);
	}
	
	public Page<Abxiu> findPage(Page<Abxiu> page, Abxiu abxiu) {
		return super.findPage(page, abxiu);
	}
	
	@Transactional(readOnly = false)
	public void save(Abxiu abxiu) {
		super.save(abxiu);
	}
	
	@Transactional(readOnly = false)
	public void delete(Abxiu abxiu) {
		super.delete(abxiu);
	}
	
}