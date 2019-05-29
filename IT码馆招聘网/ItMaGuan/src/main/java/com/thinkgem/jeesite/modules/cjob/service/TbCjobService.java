/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cjob.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.cjob.entity.TbCjob;
import com.thinkgem.jeesite.modules.cjob.dao.TbCjobDao;

/**
 * 招聘信息描述Service
 * @author a
 * @version 2019-04-17
 */
@Service
@Transactional(readOnly = true)
public class TbCjobService extends CrudService<TbCjobDao, TbCjob> {

	public TbCjob get(String id) {
		return super.get(id);
	}
	
	public List<TbCjob> findList(TbCjob tbCjob) {
		return super.findList(tbCjob);
	}
	
	public Page<TbCjob> findPage(Page<TbCjob> page, TbCjob tbCjob) {
		return super.findPage(page, tbCjob);
	}
	
	@Transactional(readOnly = false)
	public void save(TbCjob tbCjob) {
		super.save(tbCjob);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbCjob tbCjob) {
		super.delete(tbCjob);
	}
	
	public Page<TbCjob> findPageT(Page<TbCjob> page, TbCjob tbCjob) {
		return super.findPageT(page, tbCjob);
	}
	
}