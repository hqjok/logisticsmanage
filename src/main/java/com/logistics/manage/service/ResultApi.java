package com.logistics.manage.service;

import com.github.pagehelper.PageInfo;
import com.logistics.manage.service.result.FrontendResult;

import java.util.List;

/**
 * @Create 2020-03-18 1:58
 */
public interface ResultApi<T> {

    /**
     * 获取数据
     * @return
     * @param pageNumber
     * @param searchName
     */
    PageInfo getInfo(Integer pageNumber, String searchName);

    /**
     * 获取类型
     * @return
     */
    String getType();

    /**
     * 增加信息
     */
    void addInfo();


    /**
     * 获取表头
     */
    List<FrontendResult.TableField> getTableField();
}
