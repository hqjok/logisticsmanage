package com.logistics.manage.mapper;

import com.logistics.manage.entity.po.CanteenPO;
import com.logistics.manage.entity.po.CanteenPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CanteenPOMapper {
    int countByExample(CanteenPOExample example);

    int deleteByExample(CanteenPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CanteenPO record);

    int insertSelective(CanteenPO record);

    List<CanteenPO> selectByExample(CanteenPOExample example);

    CanteenPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CanteenPO record, @Param("example") CanteenPOExample example);

    int updateByExample(@Param("record") CanteenPO record, @Param("example") CanteenPOExample example);

    int updateByPrimaryKeySelective(CanteenPO record);

    int updateByPrimaryKey(CanteenPO record);

    void batchDelete(List<Integer> idList);
}