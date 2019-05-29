/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.emal.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.emal.entity.Emal;

/**
 * 信箱表DAO接口
 * @author WH
 * @version 2019-03-11
 */
@MyBatisDao
public interface EmalDao extends CrudDao<Emal> {
	
}