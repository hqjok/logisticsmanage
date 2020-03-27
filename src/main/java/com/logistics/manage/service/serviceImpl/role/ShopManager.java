package com.logistics.manage.service.serviceImpl.role;

import com.logistics.manage.entity.po.CanteenPOExample;
import com.logistics.manage.entity.po.MaintainPOExample;
import com.logistics.manage.entity.po.ShopPOExample;
import com.logistics.manage.entity.po.WindowPOExample;
import com.logistics.manage.mapper.CanteenPOMapper;
import com.logistics.manage.mapper.MaintainPOMapper;
import com.logistics.manage.mapper.ShopPOMapper;
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

@Component("role3")
public class ShopManager implements RoleAndMenuApi {

    @Autowired
    private ShopPOMapper shopPOMapper;

    @Autowired
    private MaintainPOMapper maintainPOMapper;

    @Override
    public Integer getRoleId() {
        return 3;
    }

    @Override
    public String getRoleName() {
        return "采购管理员";
    }

    @Override
    public List<LoginResult.MenuListBean> getMenuList() {

        ArrayList<LoginResult.MenuListBean> menuListBeans = new ArrayList<>();
        //采购管理员应有的操作
        menuListBeans.add(LoginResult.MenuListBean.menuWithNoDialog("采购订单", shopPOMapper.countByExample(new ShopPOExample()), "6"));

        //维修
        RoleUtil.addCommonRole(menuListBeans, maintainPOMapper.countByExample(new MaintainPOExample()));


        return menuListBeans;
    }
}
