/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.admin.entity.TbAdmin;
import com.thinkgem.jeesite.modules.admin.dao.TbAdminDao;

/**
 * 管理员信息表Service
 * @author a
 * @version 2019-03-12
 */
@Service
@Transactional(readOnly = true)
public class TbAdminService extends CrudService<TbAdminDao, TbAdmin> {

	public TbAdmin get(String id) {
		return super.get(id);
	}
	
	public List<TbAdmin> findList(TbAdmin tbAdmin) {
		return super.findList(tbAdmin);
	}
	
	public Page<TbAdmin> findPage(Page<TbAdmin> page, TbAdmin tbAdmin) {
		return super.findPage(page, tbAdmin);
	}
	
	@Transactional(readOnly = false)
	public void save(TbAdmin tbAdmin) {
		super.save(tbAdmin);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbAdmin tbAdmin) {
		super.delete(tbAdmin);
	}
	
}