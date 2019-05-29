/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.w.dao.w;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.w.entity.w.Wh;

/**
 * wDAO接口
 * @author w
 * @version 2018-07-05
 */
@MyBatisDao
public interface WhDao extends CrudDao<Wh> {
	
}