/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.collect.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.collect.entity.TbCollect;
import com.thinkgem.jeesite.modules.collect.dao.TbCollectDao;

/**
 * 收藏的信息Service
 * @author a
 * @version 2019-03-12
 */
@Service
@Transactional(readOnly = true)
public class TbCollectService extends CrudService<TbCollectDao, TbCollect> {

	public TbCollect get(String id) {
		return super.get(id);
	}
	
	public List<TbCollect> findList(TbCollect tbCollect) {
		return super.findList(tbCollect);
	}
	
	public Page<TbCollect> findPage(Page<TbCollect> page, TbCollect tbCollect) {
		return super.findPage(page, tbCollect);
	}
	
	@Transactional(readOnly = false)
	public void save(TbCollect tbCollect) {
		super.save(tbCollect);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbCollect tbCollect) {
		super.delete(tbCollect);
	}
	
}