package com.logistics.manage.entity.searchCondition;

/**
 * @Create 2020-03-03 5:36
 */
public class PermissionCondition extends CommonCondition {

    private String loginacct;
    private String permission;

    public String getLoginacct() {
        return loginacct;
    }

    public void setLoginacct(String loginacct) {
        this.loginacct = loginacct;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
