package cn.nyist.springmvc.dao;

import cn.nyist.springmvc.po.StuClass;
import cn.nyist.springmvc.po.StuClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StuClassMapper {
    int countByExample(StuClassExample example);

    int deleteByExample(StuClassExample example);

    int deleteByPrimaryKey(Long sno);

    int insert(StuClass record);

    int insertSelective(StuClass record);

    List<StuClass> selectByExample(StuClassExample example);

    StuClass selectByPrimaryKey(Long sno);

    int updateByExampleSelective(@Param("record") StuClass record, @Param("example") StuClassExample example);

    int updateByExample(@Param("record") StuClass record, @Param("example") StuClassExample example);

    int updateByPrimaryKeySelective(StuClass record);

    int updateByPrimaryKey(StuClass record);
}