/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.inform.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.inform.entity.Inform;

/**
 * 消息通知表DAO接口
 * @author Y
 * @version 2019-03-10
 */
@MyBatisDao
public interface InformDao extends CrudDao<Inform> {
	
}