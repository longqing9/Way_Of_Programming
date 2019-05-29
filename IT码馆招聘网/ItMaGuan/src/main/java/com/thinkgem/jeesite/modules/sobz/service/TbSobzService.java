/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sobz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sobz.entity.TbSobz;
import com.thinkgem.jeesite.modules.sobz.dao.TbSobzDao;

/**
 * 简历信息的转储表Service
 * @author a
 * @version 2019-03-12
 */
@Service
@Transactional(readOnly = true)
public class TbSobzService extends CrudService<TbSobzDao, TbSobz> {

	@Autowired
	private TbSobzDao dao;
	
	
	public TbSobz get(String id) {
		return super.get(id);
	}
	
	public List<TbSobz> findList(TbSobz tbSobz) {
		return super.findList(tbSobz);
	}
	
	public Page<TbSobz> findPage(Page<TbSobz> page, TbSobz tbSobz) {
		return super.findPage(page, tbSobz);
	}
	
	@Transactional(readOnly = false)
	public void save(TbSobz tbSobz) {
		super.save(tbSobz);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbSobz tbSobz) {
		super.delete(tbSobz);
	}
	
	@Transactional(readOnly = false)
	public void updateother(TbSobz tbSobz) {
		dao.updateother(tbSobz);
	}
	
	
}