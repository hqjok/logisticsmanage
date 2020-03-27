package com.logistics.manage.entity.searchCondition;

/**
 * @Create 2020-03-03 5:36
 */
public class ShopCondition extends CommonCondition {

    private String shopTime;
    private String orderNum;
    private String directorName;
    private Integer telphone;
    private String orderContent;
    private Integer typeId;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getShopTime() {
        return shopTime;
    }

    public void setShopTime(String shopTime) {
        this.shopTime = shopTime;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public Integer getTelphone() {
        return telphone;
    }

    public void setTelphone(Integer telphone) {
        this.telphone = telphone;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }


}
