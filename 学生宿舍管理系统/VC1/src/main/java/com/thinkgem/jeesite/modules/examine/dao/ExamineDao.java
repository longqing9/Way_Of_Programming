/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.examine.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.examine.entity.Examine;

/**
 * 宿舍检查情况DAO接口
 * @author D
 * @version 2019-03-10
 */
@MyBatisDao
public interface ExamineDao extends CrudDao<Examine> {
	
}