/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.memorandum.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.memorandum.entity.Memorandum;

/**
 * 备忘录DAO接口
 * @author a
 * @version 2019-03-22
 */
@MyBatisDao
public interface MemorandumDao extends CrudDao<Memorandum> {
	
}