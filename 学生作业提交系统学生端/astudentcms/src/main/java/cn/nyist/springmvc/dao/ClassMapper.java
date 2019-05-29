package cn.nyist.springmvc.dao;

import cn.nyist.springmvc.domain.ClassteacherAndsubject;
import cn.nyist.springmvc.po.Class;
import cn.nyist.springmvc.po.ClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassMapper {
    int countByExample(ClassExample example);

    int deleteByExample(ClassExample example);

    int deleteByPrimaryKey(Long classid);

    int insert(Class record);

    int insertSelective(Class record);

    List<Class> selectByExample(ClassExample example);

    Class selectByPrimaryKey(Long classid);

    int updateByExampleSelective(@Param("record") Class record, @Param("example") ClassExample example);

    int updateByExample(@Param("record") Class record, @Param("example") ClassExample example);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);
    
    List<ClassteacherAndsubject> selectteachersubjectByclassid(Long classid);
    
    List<ClassteacherAndsubject> SelectTeacherBysubname(Long classid,String subname);
}