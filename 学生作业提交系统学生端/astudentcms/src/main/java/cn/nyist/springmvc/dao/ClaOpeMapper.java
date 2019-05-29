package cn.nyist.springmvc.dao;

import cn.nyist.springmvc.po.ClaOpeExample;
import cn.nyist.springmvc.po.ClaOpeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClaOpeMapper {
    int countByExample(ClaOpeExample example);

    int deleteByExample(ClaOpeExample example);

    int deleteByPrimaryKey(ClaOpeKey key);

    int insert(ClaOpeKey record);

    int insertSelective(ClaOpeKey record);

    List<ClaOpeKey> selectByExample(ClaOpeExample example);

    int updateByExampleSelective(@Param("record") ClaOpeKey record, @Param("example") ClaOpeExample example);

    int updateByExample(@Param("record") ClaOpeKey record, @Param("example") ClaOpeExample example);
}