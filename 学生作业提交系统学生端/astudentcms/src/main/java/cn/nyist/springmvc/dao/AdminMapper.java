package cn.nyist.springmvc.dao;

import cn.nyist.springmvc.po.Admin;
import cn.nyist.springmvc.po.AdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    int countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Long adminid);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Long adminid);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}