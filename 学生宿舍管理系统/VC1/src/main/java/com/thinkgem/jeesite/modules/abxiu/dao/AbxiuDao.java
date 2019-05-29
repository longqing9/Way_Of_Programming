/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.abxiu.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.abxiu.entity.Abxiu;

/**
 * 报修登记表DAO接口
 * @author a
 * @version 2019-03-11
 */
@MyBatisDao
public interface AbxiuDao extends CrudDao<Abxiu> {
	
}