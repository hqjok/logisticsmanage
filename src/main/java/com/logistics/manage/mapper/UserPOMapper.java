package com.logistics.manage.mapper;

import com.logistics.manage.entity.po.UserPO;
import com.logistics.manage.entity.po.UserPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserPOMapper {
    int countByExample(UserPOExample example);

    int deleteByExample(UserPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserPO record);

    int insertSelective(UserPO record);

    List<UserPO> selectByExample(UserPOExample example);

    UserPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserPO record, @Param("example") UserPOExample example);

    int updateByExample(@Param("record") UserPO record, @Param("example") UserPOExample example);

    int updateByPrimaryKeySelective(UserPO record);

    int updateByPrimaryKey(UserPO record);

    void batchDelete(List<Integer> idList);
}