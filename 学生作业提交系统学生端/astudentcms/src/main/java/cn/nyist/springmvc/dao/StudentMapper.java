package cn.nyist.springmvc.dao;

import cn.nyist.springmvc.domain.Studentinfor;
import cn.nyist.springmvc.po.Student;
import cn.nyist.springmvc.po.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    int countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Long sno);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Long sno);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    List<Student> selectByclassid(Long sclassid);
    
    Studentinfor selectstudentinforBysno(Long sno);
    
    List<Student> SelectinformationByname(String name,Long classid);
}