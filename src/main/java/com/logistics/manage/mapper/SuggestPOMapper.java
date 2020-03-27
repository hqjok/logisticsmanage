package com.logistics.manage.mapper;

import com.logistics.manage.entity.po.SuggestPO;
import com.logistics.manage.entity.po.SuggestPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SuggestPOMapper {
    int countByExample(SuggestPOExample example);

    int deleteByExample(SuggestPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SuggestPO record);

    int insertSelective(SuggestPO record);

    List<SuggestPO> selectByExampleWithBLOBs(SuggestPOExample example);

    List<SuggestPO> selectByExample(SuggestPOExample example);

    SuggestPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SuggestPO record, @Param("example") SuggestPOExample example);

    int updateByExampleWithBLOBs(@Param("record") SuggestPO record, @Param("example") SuggestPOExample example);

    int updateByExample(@Param("record") SuggestPO record, @Param("example") SuggestPOExample example);

    int updateByPrimaryKeySelective(SuggestPO record);

    int updateByPrimaryKeyWithBLOBs(SuggestPO record);

    int updateByPrimaryKey(SuggestPO record);

    void batchDelete(List<Integer> idList);
}