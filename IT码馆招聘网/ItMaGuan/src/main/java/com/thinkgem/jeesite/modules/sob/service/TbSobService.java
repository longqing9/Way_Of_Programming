/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sob.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sob.entity.TbSob;
import com.thinkgem.jeesite.modules.sob.dao.TbSobDao;

/**
 * 个人简历的信息Service
 * @author a
 * @version 2019-04-17
 */
@Service
@Transactional(readOnly = true)
public class TbSobService extends CrudService<TbSobDao, TbSob> {

	public TbSob get(String id) {
		return super.get(id);
	}
	
	public List<TbSob> findList(TbSob tbSob) {
		return super.findList(tbSob);
	}
	
	public Page<TbSob> findPage(Page<TbSob> page, TbSob tbSob) {
		return super.findPage(page, tbSob);
	}
	
	@Transactional(readOnly = false)
	public void save(TbSob tbSob) {
		super.save(tbSob);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbSob tbSob) {
		super.delete(tbSob);
	}
	
}