package cn.nyist.springmvc.dao;

import cn.nyist.springmvc.po.TeaClassExample;
import cn.nyist.springmvc.po.TeaClassKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeaClassMapper {
    int countByExample(TeaClassExample example);

    int deleteByExample(TeaClassExample example);

    int deleteByPrimaryKey(TeaClassKey key);

    int insert(TeaClassKey record);

    int insertSelective(TeaClassKey record);

    List<TeaClassKey> selectByExample(TeaClassExample example);

    int updateByExampleSelective(@Param("record") TeaClassKey record, @Param("example") TeaClassExample example);

    int updateByExample(@Param("record") TeaClassKey record, @Param("example") TeaClassExample example);
}