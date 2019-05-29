package cn.nyist.springmvc.dao;

import cn.nyist.springmvc.po.StudentAccount;
import cn.nyist.springmvc.po.StudentAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentAccountMapper {
    int countByExample(StudentAccountExample example);

    int deleteByExample(StudentAccountExample example);

    int deleteByPrimaryKey(Long sno);

    int insert(StudentAccount record);

    int insertSelective(StudentAccount record);

    List<StudentAccount> selectByExample(StudentAccount user);

    StudentAccount selectByPrimaryKey(Long sno);

    int updateByExampleSelective(@Param("record") StudentAccount record, @Param("example") StudentAccountExample example);

    int updateByExample(@Param("record") StudentAccount record, @Param("example") StudentAccountExample example);

    int updateByPrimaryKeySelective(StudentAccount record);

    int updateByPrimaryKey(StudentAccount record);

	StudentAccount selectByStudent(StudentAccount user);
}