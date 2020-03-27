package com.logistics.manage.mapper;

import com.logistics.manage.entity.po.MaintainPO;
import com.logistics.manage.entity.po.MaintainPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaintainPOMapper {
    int countByExample(MaintainPOExample example);

    int deleteByExample(MaintainPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MaintainPO record);

    int insertSelective(MaintainPO record);

    List<MaintainPO> selectByExampleWithBLOBs(MaintainPOExample example);

    List<MaintainPO> selectByExample(MaintainPOExample example);

    MaintainPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MaintainPO record, @Param("example") MaintainPOExample example);

    int updateByExampleWithBLOBs(@Param("record") MaintainPO record, @Param("example") MaintainPOExample example);

    int updateByExample(@Param("record") MaintainPO record, @Param("example") MaintainPOExample example);

    int updateByPrimaryKeySelective(MaintainPO record);

    int updateByPrimaryKeyWithBLOBs(MaintainPO record);

    int updateByPrimaryKey(MaintainPO record);

    void batchDelete(List<Integer> idList);
}