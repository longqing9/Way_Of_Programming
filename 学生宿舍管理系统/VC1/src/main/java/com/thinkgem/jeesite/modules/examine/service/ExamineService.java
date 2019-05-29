/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.examine.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.examine.entity.Examine;
import com.thinkgem.jeesite.modules.examine.dao.ExamineDao;

/**
 * 宿舍检查情况Service
 * @author D
 * @version 2019-03-10
 */
@Service
@Transactional(readOnly = true)
public class ExamineService extends CrudService<ExamineDao, Examine> {

	public Examine get(String id) {
		return super.get(id);
	}
	
	public List<Examine> findList(Examine examine) {
		return super.findList(examine);
	}
	
	public Page<Examine> findPage(Page<Examine> page, Examine examine) {
		return super.findPage(page, examine);
	}
	
	@Transactional(readOnly = false)
	public void save(Examine examine) {
		super.save(examine);
	}
	
	@Transactional(readOnly = false)
	public void delete(Examine examine) {
		super.delete(examine);
	}
	
}