package com.logistics.manage.service.serviceImpl.role;

import com.logistics.manage.entity.po.MaintainPOExample;
import com.logistics.manage.service.result.LoginResult;

import java.util.ArrayList;

/**
 * @Create 2020-03-19 1:03
 */
public class RoleUtil {

    public static void addCommonRole(ArrayList<LoginResult.MenuListBean> menuListBeans, Integer count){

        //维修类型
        ArrayList<LoginResult.MenuListBean.DialogBean.SelectType> selectTypes = new ArrayList<>();
        selectTypes.add(new LoginResult.MenuListBean.DialogBean.SelectType(4, "门窗损坏"));
        selectTypes.add(new LoginResult.MenuListBean.DialogBean.SelectType(5, "漏水漏电"));
        selectTypes.add(new LoginResult.MenuListBean.DialogBean.SelectType(6, "电子损坏"));
        selectTypes.add(new LoginResult.MenuListBean.DialogBean.SelectType(7, "其他"));

        //维修操作
        ArrayList<LoginResult.MenuListBean.DialogBean> dialogBeans = new ArrayList<>();
        dialogBeans.add(new LoginResult.MenuListBean.DialogBean("维修类型", "fa fa-wrench", "typeId", "select", selectTypes));
        dialogBeans.add(new LoginResult.MenuListBean.DialogBean("地址", "fa fa-building-o", "address", "text", null));
        dialogBeans.add(new LoginResult.MenuListBean.DialogBean("电话", "fa fa-phone", "telphone", "text", null));
        dialogBeans.add(new LoginResult.MenuListBean.DialogBean("提交人", "fa fa-user-o", "submitUsername", "text", null));
        dialogBeans.add(new LoginResult.MenuListBean.DialogBean("维修描述", "fa fa-wrench", "description", "text", null));
        dialogBeans.add(new LoginResult.MenuListBean.DialogBean("预约时间", "fa fa-calendar", "appointTime", "dateTime", null));

        menuListBeans.add(new LoginResult.MenuListBean("预约维修", count,
                "7", true, "http://localhost:8080/maintain/add", dialogBeans));
    }

}
