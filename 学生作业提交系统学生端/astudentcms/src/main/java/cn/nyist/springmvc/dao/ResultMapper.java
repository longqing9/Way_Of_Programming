package cn.nyist.springmvc.dao;

import cn.nyist.springmvc.domain.Subjectoptop;
import cn.nyist.springmvc.po.Result;
import cn.nyist.springmvc.po.ResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResultMapper {
    int countByExample(ResultExample example);

    int deleteByExample(ResultExample example);

    int deleteByPrimaryKey(String reid);

    int insert(Result record);

    int insertSelective(Result record);

    List<Result> selectByExampleWithBLOBs(ResultExample example);

    List<Result> selectByExample(ResultExample example);

    Result selectByPrimaryKey(String reid);

    int updateByExampleSelective(@Param("record") Result record, @Param("example") ResultExample example);

    int updateByExampleWithBLOBs(@Param("record") Result record, @Param("example") ResultExample example);

    int updateByExample(@Param("record") Result record, @Param("example") ResultExample example);

    int updateByPrimaryKeySelective(Result record);

    int updateByPrimaryKeyWithBLOBs(Result record);

    int updateByPrimaryKey(Result record);
    
    Result selectBysnoAndopid(Long rsno,String opid);
    
    List<Subjectoptop> SelectRescoreBysno(Long sno);
        
    int DeleteresultByopidsno(String opid,Long rsno);
    
    int resubmitByopidsnoWithBLOBs(String opid,Long sno,String retext);
}