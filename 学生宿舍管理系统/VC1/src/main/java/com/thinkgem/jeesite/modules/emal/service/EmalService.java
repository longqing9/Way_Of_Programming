/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.emal.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.emal.entity.Emal;
import com.thinkgem.jeesite.modules.emal.dao.EmalDao;

/**
 * 信箱表Service
 * @author WH
 * @version 2019-03-11
 */
@Service
@Transactional(readOnly = true)
public class EmalService extends CrudService<EmalDao, Emal> {

	public Emal get(String id) {
		return super.get(id);
	}
	
	public List<Emal> findList(Emal emal) {
		return super.findList(emal);
	}
	
	public Page<Emal> findPage(Page<Emal> page, Emal emal) {
		return super.findPage(page, emal);
	}
	
	@Transactional(readOnly = false)
	public void save(Emal emal) {
		super.save(emal);
	}
	
	@Transactional(readOnly = false)
	public void delete(Emal emal) {
		super.delete(emal);
	}
	
}