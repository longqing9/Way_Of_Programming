/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.company.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.company.entity.TbCompany;
import com.thinkgem.jeesite.modules.company.dao.TbCompanyDao;

/**
 * 企业信息表Service
 * @author a
 * @version 2019-04-17
 */
@Service
@Transactional(readOnly = true)
public class TbCompanyService extends CrudService<TbCompanyDao, TbCompany> {

	public TbCompany get(String id) {
		return super.get(id);
	}
	
	public List<TbCompany> findList(TbCompany tbCompany) {
		return super.findList(tbCompany);
	}
	
	public Page<TbCompany> findPage(Page<TbCompany> page, TbCompany tbCompany) {
		return super.findPage(page, tbCompany);
	}
	
	@Transactional(readOnly = false)
	public void save(TbCompany tbCompany) {
		super.save(tbCompany);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbCompany tbCompany) {
		super.delete(tbCompany);
	}
	
}