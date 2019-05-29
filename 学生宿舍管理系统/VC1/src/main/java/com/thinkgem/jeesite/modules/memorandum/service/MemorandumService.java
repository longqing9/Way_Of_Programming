/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.memorandum.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.memorandum.entity.Memorandum;
import com.thinkgem.jeesite.modules.memorandum.dao.MemorandumDao;

/**
 * 备忘录Service
 * @author a
 * @version 2019-03-22
 */
@Service
@Transactional(readOnly = true)
public class MemorandumService extends CrudService<MemorandumDao, Memorandum> {

	public Memorandum get(String id) {
		return super.get(id);
	}
	
	public List<Memorandum> findList(Memorandum memorandum) {
		return super.findList(memorandum);
	}
	
	public Page<Memorandum> findPage(Page<Memorandum> page, Memorandum memorandum) {
		return super.findPage(page, memorandum);
	}
	
	@Transactional(readOnly = false)
	public void save(Memorandum memorandum) {
		super.save(memorandum);
	}
	
	@Transactional(readOnly = false)
	public void delete(Memorandum memorandum) {
		super.delete(memorandum);
	}
	
}