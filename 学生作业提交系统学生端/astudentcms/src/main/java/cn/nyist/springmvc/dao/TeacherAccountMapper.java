package cn.nyist.springmvc.dao;

import cn.nyist.springmvc.po.TeacherAccount;
import cn.nyist.springmvc.po.TeacherAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherAccountMapper {
    int countByExample(TeacherAccountExample example);

    int deleteByExample(TeacherAccountExample example);

    int deleteByPrimaryKey(Long tno);

    int insert(TeacherAccount record);

    int insertSelective(TeacherAccount record);

    List<TeacherAccount> selectByExample(TeacherAccountExample example);

    TeacherAccount selectByPrimaryKey(Long tno);

    int updateByExampleSelective(@Param("record") TeacherAccount record, @Param("example") TeacherAccountExample example);

    int updateByExample(@Param("record") TeacherAccount record, @Param("example") TeacherAccountExample example);

    int updateByPrimaryKeySelective(TeacherAccount record);

    int updateByPrimaryKey(TeacherAccount record);
}