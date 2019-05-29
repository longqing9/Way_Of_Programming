package com.thinkgem.jeesite.frontWeb.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sobz.entity.TbSobz;
import com.thinkgem.jeesite.modules.stud.entity.TbStudent;

@MyBatisDao
public interface ShowDao extends CrudDao<TbStudent> {
	
}
