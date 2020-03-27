package com.logistics.manage.entity.searchCondition;

/**
 * @Create 2020-03-03 5:36
 */
public class CanteenCondition extends CommonCondition {

    private String director;
    private String address;
    private String company;
    private String telphone;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }
}
