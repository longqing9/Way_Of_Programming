/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tt.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.tt.entity.Account;

/**
 * 账号表DAO接口
 * @author WH
 * @version 2019-03-05
 */
@MyBatisDao
public interface AccountDao extends CrudDao<Account> {
	
}