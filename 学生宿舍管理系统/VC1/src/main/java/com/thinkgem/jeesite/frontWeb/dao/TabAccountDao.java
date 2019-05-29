package com.thinkgem.jeesite.frontWeb.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.frontWeb.entity.TabAccount;

@MyBatisDao
public interface TabAccountDao extends CrudDao<TabAccount>{

	public TabAccount findAccount(TabAccount account);
	
}
