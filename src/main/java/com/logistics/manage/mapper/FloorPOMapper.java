package com.logistics.manage.mapper;

import com.logistics.manage.entity.po.FloorPO;
import com.logistics.manage.entity.po.FloorPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FloorPOMapper {
    int countByExample(FloorPOExample example);

    int deleteByExample(FloorPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FloorPO record);

    int insertSelective(FloorPO record);

    List<FloorPO> selectByExample(FloorPOExample example);

    FloorPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FloorPO record, @Param("example") FloorPOExample example);

    int updateByExample(@Param("record") FloorPO record, @Param("example") FloorPOExample example);

    int updateByPrimaryKeySelective(FloorPO record);

    int updateByPrimaryKey(FloorPO record);

    void batchDelete(List<Integer> idList);
}