/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.w.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.w.entity.Wh1;
import com.thinkgem.jeesite.modules.w.dao.Wh1Dao;

/**
 * 功能描述Service
 * @author w
 * @version 2018-07-06
 */
@Service
@Transactional(readOnly = true)
public class Wh1Service extends CrudService<Wh1Dao, Wh1> {

	public Wh1 get(String id) {
		return super.get(id);
	}
	
	public List<Wh1> findList(Wh1 wh1) {
		return super.findList(wh1);
	}
	
	public Page<Wh1> findPage(Page<Wh1> page, Wh1 wh1) {
		return super.findPage(page, wh1);
	}
	
	@Transactional(readOnly = false)
	public void save(Wh1 wh1) {
		super.save(wh1);
	}
	
	@Transactional(readOnly = false)
	public void delete(Wh1 wh1) {
		super.delete(wh1);
	}
	
}