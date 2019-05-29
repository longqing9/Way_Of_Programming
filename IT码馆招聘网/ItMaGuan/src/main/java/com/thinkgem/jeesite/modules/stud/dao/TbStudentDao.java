/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.stud.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.stud.entity.TbStudent;

/**
 * 应聘者基本信息DAO接口
 * @author a
 * @version 2019-04-17
 */
@MyBatisDao
public interface TbStudentDao extends CrudDao<TbStudent> {
	TbStudent getStudentId(TbStudent tbStudent);
	
}