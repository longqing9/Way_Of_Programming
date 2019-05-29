/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sobz.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sobz.entity.TbSobz;

/**
 * 简历信息的转储表DAO接口
 * @author a
 * @version 2019-03-12
 */
@MyBatisDao
public interface TbSobzDao extends CrudDao<TbSobz> {
	
	public int updateother(TbSobz tbSobz);
	
}