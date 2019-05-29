/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.w.service.w;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.w.entity.w.Wh;
import com.thinkgem.jeesite.modules.w.dao.w.WhDao;

/**
 * wService
 * @author w
 * @version 2018-07-05
 */
@Service
@Transactional(readOnly = true)
public class WhService extends CrudService<WhDao, Wh> {

	public Wh get(String id) {
		return super.get(id);
	}
	
	public List<Wh> findList(Wh wh) {
		return super.findList(wh);
	}
	
	public Page<Wh> findPage(Page<Wh> page, Wh wh) {
		return super.findPage(page, wh);
	}
	
	@Transactional(readOnly = false)
	public void save(Wh wh) {
		super.save(wh);
	}
	
	@Transactional(readOnly = false)
	public void delete(Wh wh) {
		super.delete(wh);
	}
	
}