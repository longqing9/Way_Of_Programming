package com.thinkgem.jeesite.frontWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.frontWeb.dao.TabAccountDao;
import com.thinkgem.jeesite.frontWeb.entity.TabAccount;

@Service
public class TabAccountService extends CrudService<TabAccountDao, TabAccount> {
	
	@Autowired
	private TabAccountDao tabAccountDao;
	
	public TabAccount findAccount(TabAccount account){
		return tabAccountDao.findAccount(account);
	}

}
