package com.logistics.manage.service.serviceImpl.role;

import com.logistics.manage.entity.po.DomitoryPOExample;
import com.logistics.manage.entity.po.FloorPOExample;
import com.logistics.manage.entity.po.MaintainPOExample;
import com.logistics.manage.entity.po.VisitPOExample;
import com.logistics.manage.mapper.DomitoryPOMapper;
import com.logistics.manage.mapper.FloorPOMapper;
import com.logistics.manage.mapper.MaintainPOMapper;
import com.logistics.manage.mapper.VisitPOMapper;
import com.logistics.manage.service.RoleAndMenuApi;
import com.logistics.manage.service.result.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Create 2020-03-18 21:55
 */
@Component("role1")
public class DormitoryManager implements RoleAndMenuApi {

    @Autowired
    private FloorPOMapper floorPOMapper;

    @Autowired
    private DomitoryPOMapper domitoryPOMapper;

    @Autowired
    private VisitPOMapper visitPOMapper;

    @Autowired
    private MaintainPOMapper maintainPOMapper;

    @Override
    public Integer getRoleId() {
        return 1;
    }

    @Override
    public String getRoleName() {
        return "宿舍管理员";
    }

    @Override
    public List<LoginResult.MenuListBean> getMenuList() {

        ArrayList<LoginResult.MenuListBean> menuListBeans = new ArrayList<>();
        //宿管应有的操作
        menuListBeans.add(LoginResult.MenuListBean.menuWithNoDialog("楼栋", floorPOMapper.countByExample(new FloorPOExample()), "1"));
        menuListBeans.add(LoginResult.MenuListBean.menuWithNoDialog("宿舍", domitoryPOMapper.countByExample(new DomitoryPOExample()), "2"));
        menuListBeans.add(LoginResult.MenuListBean.menuWithNoDialog("外来人口登记", visitPOMapper.countByExample(new VisitPOExample()), "3"));

        //维修操作
        RoleUtil.addCommonRole(menuListBeans, maintainPOMapper.countByExample(new MaintainPOExample()));

        return menuListBeans;
    }
}
