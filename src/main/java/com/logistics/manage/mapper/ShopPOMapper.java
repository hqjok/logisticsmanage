package com.logistics.manage.mapper;

import com.logistics.manage.entity.po.ShopPO;
import com.logistics.manage.entity.po.ShopPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopPOMapper {
    int countByExample(ShopPOExample example);

    int deleteByExample(ShopPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopPO record);

    int insertSelective(ShopPO record);

    List<ShopPO> selectByExample(ShopPOExample example);

    ShopPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopPO record, @Param("example") ShopPOExample example);

    int updateByExample(@Param("record") ShopPO record, @Param("example") ShopPOExample example);

    int updateByPrimaryKeySelective(ShopPO record);

    int updateByPrimaryKey(ShopPO record);

    void batchDelete(List<Integer> idList);
}