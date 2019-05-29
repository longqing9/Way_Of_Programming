/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.company.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.company.entity.TbCompany;

/**
 * 企业信息表DAO接口
 * @author a
 * @version 2019-04-17
 */
@MyBatisDao
public interface TbCompanyDao extends CrudDao<TbCompany> {
	
}