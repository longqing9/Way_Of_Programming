/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.collect.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.collect.entity.TbCollect;

/**
 * 收藏的信息DAO接口
 * @author a
 * @version 2019-03-12
 */
@MyBatisDao
public interface TbCollectDao extends CrudDao<TbCollect> {
	
}