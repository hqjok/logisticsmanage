package com.logistics.manage.service.serviceImpl.role;

import com.logistics.manage.entity.po.MaintainPOExample;
import com.logistics.manage.entity.po.ShopPOExample;
import com.logistics.manage.entity.po.SuggestPOExample;
import com.logistics.manage.mapper.MaintainPOMapper;
import com.logistics.manage.mapper.ShopPOMapper;
import com.logistics.manage.mapper.SuggestPOMapper;
import com.logistics.manage.service.RoleAndMenuApi;
import com.logistics.manage.service.result.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Create 2020-03-18 22:26
 */

@Component("role4")
public class SuggestManager implements RoleAndMenuApi {

    @Autowired
    private SuggestPOMapper suggestPOMapper;

    @Autowired
    private MaintainPOMapper maintainPOMapper;

    @Override
    public Integer getRoleId() {
        return 4;
    }

    @Override
    public String getRoleName() {
        return "意见墙管理员";
    }

    @Override
    public List<LoginResult.MenuListBean> getMenuList() {

        ArrayList<LoginResult.MenuListBean> menuListBeans = new ArrayList<>();

        //类型
        ArrayList<LoginResult.MenuListBean.DialogBean.SelectType> selectTypes = new ArrayList<>();
        selectTypes.add(new LoginResult.MenuListBean.DialogBean.SelectType(8, "宿舍意见"));
        selectTypes.add(new LoginResult.MenuListBean.DialogBean.SelectType(9, "食堂意见"));
        selectTypes.add(new LoginResult.MenuListBean.DialogBean.SelectType(10, "教学楼意见"));
        selectTypes.add(new LoginResult.MenuListBean.DialogBean.SelectType(11, "其他意见"));

        //意见墙管理员应有的操作
        ArrayList<LoginResult.MenuListBean.DialogBean> dialogBeans = new ArrayList<>();

        dialogBeans.add(new LoginResult.MenuListBean.DialogBean("意见类型", "fa fa-bars", "typeId", "select", selectTypes));
        dialogBeans.add(new LoginResult.MenuListBean.DialogBean("提交人", "fa fa-user-o", "username", "text", null));
        dialogBeans.add(new LoginResult.MenuListBean.DialogBean("内容", "fa fa-exclamation-circle", "content", "text", null));
        menuListBeans.add(new LoginResult.MenuListBean("意见墙", suggestPOMapper.countByExample(new SuggestPOExample()),
                "8", true, "http://localhost:8080/suggest/add", dialogBeans));

        //维修
        RoleUtil.addCommonRole(menuListBeans, maintainPOMapper.countByExample(new MaintainPOExample()));


        return menuListBeans;
    }
}
