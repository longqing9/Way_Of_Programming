/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.apply.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.apply.entity.TbApply;
import com.thinkgem.jeesite.modules.apply.dao.TbApplyDao;

/**
 * 我的申请Service
 * @author a
 * @version 2019-03-12
 */
@Service
@Transactional(readOnly = true)
public class TbApplyService extends CrudService<TbApplyDao, TbApply> {

	public TbApply get(String id) {
		return super.get(id);
	}
	
	public List<TbApply> findList(TbApply tbApply) {
		return super.findList(tbApply);
	}
	
	public Page<TbApply> findPage(Page<TbApply> page, TbApply tbApply) {
		return super.findPage(page, tbApply);
	}
	
	@Transactional(readOnly = false)
	public void save(TbApply tbApply) {
		super.save(tbApply);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbApply tbApply) {
		super.delete(tbApply);
	}
	
}