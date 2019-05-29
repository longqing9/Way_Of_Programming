/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.inform.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.inform.entity.Inform;
import com.thinkgem.jeesite.modules.inform.dao.InformDao;

/**
 * 消息通知表Service
 * @author Y
 * @version 2019-03-10
 */
@Service
@Transactional(readOnly = true)
public class InformService extends CrudService<InformDao, Inform> {

	public Inform get(String id) {
		return super.get(id);
	}
	
	public List<Inform> findList(Inform inform) {
		return super.findList(inform);
	}
	
	public Page<Inform> findPage(Page<Inform> page, Inform inform) {
		return super.findPage(page, inform);
	}
	
	@Transactional(readOnly = false)
	public void save(Inform inform) {
		super.save(inform);
	}
	
	@Transactional(readOnly = false)
	public void delete(Inform inform) {
		super.delete(inform);
	}
	
}