package com.thinkgem.jeesite.frontWeb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.frontWeb.dao.TablesMapper;
import com.thinkgem.jeesite.frontWeb.entity.TableCompany;

@Service
@Transactional(readOnly = true)
public class Tableservice extends CrudService<TablesMapper, TableCompany> {
	
	public Page<TableCompany> findPage(Page<TableCompany> page, TableCompany tbCompany) {
		return super.findPage(page, tbCompany);
	}
	
	public TableCompany get(String id) {
		return super.get(id);
	}
	
	public List<TableCompany> findList(TableCompany tableCompany) {
		return super.findList(tableCompany);
	}
	
	
	@Transactional(readOnly = false)
	public void save(TableCompany tableCompany) {
		super.save(tableCompany);
	}
	
	@Transactional(readOnly = false)
	public void delete(TableCompany tableCompany) {
		super.delete(tableCompany);
	}
}
