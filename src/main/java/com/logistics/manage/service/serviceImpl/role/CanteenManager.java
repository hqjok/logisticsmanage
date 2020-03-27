package com.logistics.manage.service.serviceImpl.role;

import com.logistics.manage.entity.po.*;
import com.logistics.manage.mapper.CanteenPOMapper;
import com.logistics.manage.mapper.MaintainPOMapper;
import com.logistics.manage.mapper.WindowPOMapper;
import com.logistics.manage.service.RoleAndMenuApi;
import com.logistics.manage.service.result.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Create 2020-03-18 22:26
 */

@Component("role2")
public class CanteenManager implements RoleAndMenuApi {

    @Autowired
    private CanteenPOMapper canteenPOMapper;

    @Autowired
    private WindowPOMapper windowPOMapper;

    @Autowired
    private MaintainPOMapper maintainPOMapper;

    @Override
    public Integer getRoleId() {
        return 2;
    }

    @Override
    public String getRoleName() {
        return "食堂管理员";
    }

    @Override
    public List<LoginResult.MenuListBean> getMenuList() {

        ArrayList<LoginResult.MenuListBean> menuListBeans = new ArrayList<>();
        //食堂管理员应有的操作
        menuListBeans.add(LoginResult.MenuListBean.menuWithNoDialog("食堂楼栋", canteenPOMapper.countByExample(new CanteenPOExample()), "4"));
        menuListBeans.add(LoginResult.MenuListBean.menuWithNoDialog("食堂窗口", windowPOMapper.countByExample(new WindowPOExample()), "5"));

        //维修
        RoleUtil.addCommonRole(menuListBeans, maintainPOMapper.countByExample(new MaintainPOExample()));


        return menuListBeans;
    }
}
