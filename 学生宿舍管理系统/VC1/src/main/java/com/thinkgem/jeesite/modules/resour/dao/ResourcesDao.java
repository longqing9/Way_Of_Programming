/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.resour.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.resour.entity.Resources;

/**
 * 资源链接DAO接口
 * @author a
 * @version 2019-04-16
 */
@MyBatisDao
public interface ResourcesDao extends CrudDao<Resources> {
	
}