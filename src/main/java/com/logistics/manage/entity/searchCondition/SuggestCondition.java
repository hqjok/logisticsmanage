package com.logistics.manage.entity.searchCondition;

/**
 * @Create 2020-03-03 5:36
 */
public class SuggestCondition extends CommonCondition {

    private String username;
    private Integer typeId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
