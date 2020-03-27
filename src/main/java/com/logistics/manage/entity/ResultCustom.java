package com.logistics.manage.entity;

import com.github.pagehelper.PageInfo;
import com.logistics.manage.entity.searchCondition.CommonCondition;


/**
 * @Create 2020-03-03 6:25
 */
public class ResultCustom<T> {

    private PageInfo<T> returnList;
    private Integer count;
    private CommonCondition condition;
    private Integer activeId;

    public ResultCustom(PageInfo<T> returnList, Integer count, CommonCondition condition, Integer activeId) {
        this.returnList = returnList;
        this.count = count;
        this.condition = condition;
        this.activeId = activeId;
    }

    public PageInfo<T> getReturnList() {
        return returnList;
    }

    public void setReturnList(PageInfo<T> returnList) {
        this.returnList = returnList;
    }

    public Integer getActiveId() {
        return activeId;
    }

    public void setActiveId(Integer activeId) {
        this.activeId = activeId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public CommonCondition getCondition() {
        return condition;
    }

    public void setCondition(CommonCondition condition) {
        this.condition = condition;
    }

}
