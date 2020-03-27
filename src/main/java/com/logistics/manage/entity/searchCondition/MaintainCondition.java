package com.logistics.manage.entity.searchCondition;

/**
 * @Create 2020-03-03 5:36
 */
public class MaintainCondition extends CommonCondition {

    private String appointTime;
    private String address;
    private String submitUsername;
    private Integer typeId;
    private Integer status;

    public String getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(String appointTime) {
        this.appointTime = appointTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubmitUsername() {
        return submitUsername;
    }

    public void setSubmitUsername(String submitUsername) {
        this.submitUsername = submitUsername;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
