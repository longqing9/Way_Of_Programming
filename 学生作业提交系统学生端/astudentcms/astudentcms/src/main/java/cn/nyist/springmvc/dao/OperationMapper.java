package cn.nyist.springmvc.dao;

import cn.nyist.springmvc.domain.Opersub;
import cn.nyist.springmvc.domain.SubjecteacherName;
import cn.nyist.springmvc.domain.Topsubject;
import cn.nyist.springmvc.po.Operation;
import cn.nyist.springmvc.po.OperationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationMapper {
    int countByExample(OperationExample example);

    int deleteByExample(OperationExample example);

    int deleteByPrimaryKey(String opid);

    int insert(Operation record);

    int insertSelective(Operation record);

    List<Operation> selectByExampleWithBLOBs(OperationExample example);

    List<Operation> selectByExample(OperationExample example);

    Operation selectByPrimaryKey(String opid);

    int updateByExampleSelective(@Param("record") Operation record, @Param("example") OperationExample example);

    int updateByExampleWithBLOBs(@Param("record") Operation record, @Param("example") OperationExample example);

    int updateByExample(@Param("record") Operation record, @Param("example") OperationExample example);

    int updateByPrimaryKeySelective(Operation record);

    int updateByPrimaryKeyWithBLOBs(Operation record);

    int updateByPrimaryKey(Operation record);
    
    List<Opersub> SelectAlloperationByclassid(Long classid);
    
    List<SubjecteacherName> SelectsubjectTeachernameByclassid(Long classid,Long sno);
    
    List<Topsubject> ShowsubnameAndtopMap(String opsubid,Long rsno);
    
    List<SubjecteacherName> SelectUnsubjectTeachernameByclassid(Long classid,Long sno);
    
    List<Topsubject> ShowUnsubnameAndtopMap(Long classid,String opsubid,Long sno);
    
    List<Opersub> SelectoperationByoptop(Long classid,String optop);
    
    List<SubjecteacherName> FindsubjectTeachernameByclassid(Long classid,Long sno,String subname);
    
    String Playvideo(String opid);
    
}