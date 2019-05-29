/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.mess.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.mess.entity.Mess;

/**
 * 留言板DAO接口
 * @author WH
 * @version 2019-03-31
 */
@MyBatisDao
public interface MessDao extends CrudDao<Mess> {
	
}