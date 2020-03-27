package com.logistics.manage.mapper;

import com.logistics.manage.entity.po.VisitPO;
import com.logistics.manage.entity.po.VisitPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VisitPOMapper {
    int countByExample(VisitPOExample example);

    int deleteByExample(VisitPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VisitPO record);

    int insertSelective(VisitPO record);

    List<VisitPO> selectByExample(VisitPOExample example);

    VisitPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VisitPO record, @Param("example") VisitPOExample example);

    int updateByExample(@Param("record") VisitPO record, @Param("example") VisitPOExample example);

    int updateByPrimaryKeySelective(VisitPO record);

    int updateByPrimaryKey(VisitPO record);

    void batchDelete(List<Integer> idList);
}