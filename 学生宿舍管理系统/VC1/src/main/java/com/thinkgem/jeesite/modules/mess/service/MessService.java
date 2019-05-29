/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.mess.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.mess.entity.Mess;
import com.thinkgem.jeesite.modules.mess.dao.MessDao;

/**
 * 留言板Service
 * @author WH
 * @version 2019-03-31
 */
@Service
@Transactional(readOnly = true)
public class MessService extends CrudService<MessDao, Mess> {

	public Mess get(String id) {
		return super.get(id);
	}
	
	public List<Mess> findList(Mess mess) {
		return super.findList(mess);
	}
	
	public Page<Mess> findPage(Page<Mess> page, Mess mess) {
		return super.findPage(page, mess);
	}
	
	@Transactional(readOnly = false)
	public void save(Mess mess) {
		super.save(mess);
	}
	
	@Transactional(readOnly = false)
	public void delete(Mess mess) {
		super.delete(mess);
	}
	
}