package com.thinkgem.jeesite.frontWeb.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.frontWeb.dao.CjobDao;
import com.thinkgem.jeesite.frontWeb.entity.Cjob;

@Service
@Transactional(readOnly = true)
public class CjobService extends CrudService<CjobDao, Cjob> {

	public Page<Cjob> findPage(Page<Cjob> page, Cjob cjob) {
		return super.findPage(page, cjob);
	}
	
}
