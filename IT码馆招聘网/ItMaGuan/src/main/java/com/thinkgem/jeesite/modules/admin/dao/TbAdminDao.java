/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.admin.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.admin.entity.TbAdmin;

/**
 * 管理员信息表DAO接口
 * @author a
 * @version 2019-03-12
 */
@MyBatisDao
public interface TbAdminDao extends CrudDao<TbAdmin> {
	
}