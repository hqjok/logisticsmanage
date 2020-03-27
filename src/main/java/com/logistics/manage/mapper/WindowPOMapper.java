package com.logistics.manage.mapper;

import com.logistics.manage.entity.po.WindowPO;
import com.logistics.manage.entity.po.WindowPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WindowPOMapper {
    int countByExample(WindowPOExample example);

    int deleteByExample(WindowPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WindowPO record);

    int insertSelective(WindowPO record);

    List<WindowPO> selectByExample(WindowPOExample example);

    WindowPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WindowPO record, @Param("example") WindowPOExample example);

    int updateByExample(@Param("record") WindowPO record, @Param("example") WindowPOExample example);

    int updateByPrimaryKeySelective(WindowPO record);

    int updateByPrimaryKey(WindowPO record);

    void batchDelete(List<Integer> idList);
}