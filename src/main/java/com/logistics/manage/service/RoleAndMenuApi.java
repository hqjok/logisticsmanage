package com.logistics.manage.service;

import com.logistics.manage.service.result.LoginResult;

import java.util.List;

/**
 * @Create 2020-03-18 21:51
 */
public interface RoleAndMenuApi {

    /**
     * 获取用户角色Id
     */
    Integer getRoleId();

    /**
     * 获取用户角色具体名字名
     */
    String getRoleName();

    /**
     * 获取菜单列表
     */
    List<LoginResult.MenuListBean> getMenuList();

}
