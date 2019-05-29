package cn.nyist.springmvc.dao;

import cn.nyist.springmvc.po.TeaOpeExample;
import cn.nyist.springmvc.po.TeaOpeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeaOpeMapper {
    int countByExample(TeaOpeExample example);

    int deleteByExample(TeaOpeExample example);

    int deleteByPrimaryKey(TeaOpeKey key);

    int insert(TeaOpeKey record);

    int insertSelective(TeaOpeKey record);

    List<TeaOpeKey> selectByExample(TeaOpeExample example);

    int updateByExampleSelective(@Param("record") TeaOpeKey record, @Param("example") TeaOpeExample example);

    int updateByExample(@Param("record") TeaOpeKey record, @Param("example") TeaOpeExample example);
}