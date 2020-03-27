package com.logistics.manage.mapper;

import com.logistics.manage.entity.po.DomitoryPO;
import com.logistics.manage.entity.po.DomitoryPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DomitoryPOMapper {
    int countByExample(DomitoryPOExample example);

    int deleteByExample(DomitoryPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DomitoryPO record);

    int insertSelective(DomitoryPO record);

    List<DomitoryPO> selectByExample(DomitoryPOExample example);

    DomitoryPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DomitoryPO record, @Param("example") DomitoryPOExample example);

    int updateByExample(@Param("record") DomitoryPO record, @Param("example") DomitoryPOExample example);

    int updateByPrimaryKeySelective(DomitoryPO record);

    int updateByPrimaryKey(DomitoryPO record);

    void batchDelete(List<Integer> idList);
}