package cn.nyist.springmvc.dao;

import cn.nyist.springmvc.po.Teacher;
import cn.nyist.springmvc.po.TeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    int countByExample(TeacherExample example);

    int deleteByExample(TeacherExample example);

    int deleteByPrimaryKey(Long tno);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    List<Teacher> selectByExample(TeacherExample example);

    Teacher selectByPrimaryKey(Long tno);

    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}