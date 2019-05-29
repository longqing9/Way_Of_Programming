/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.resour.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.resour.entity.Resources;
import com.thinkgem.jeesite.modules.resour.dao.ResourcesDao;

/**
 * 资源链接Service
 * @author a
 * @version 2019-04-16
 */
@Service
@Transactional(readOnly = true)
public class ResourcesService extends CrudService<ResourcesDao, Resources> {

	public Resources get(String id) {
		return super.get(id);
	}
	
	public List<Resources> findList(Resources resources) {
		return super.findList(resources);
	}
	
	public Page<Resources> findPage(Page<Resources> page, Resources resources) {
		return super.findPage(page, resources);
	}
	
	@Transactional(readOnly = false)
	public void save(Resources resources) {
		super.save(resources);
	}
	
	@Transactional(readOnly = false)
	public void delete(Resources resources) {
		super.delete(resources);
	}
	
}