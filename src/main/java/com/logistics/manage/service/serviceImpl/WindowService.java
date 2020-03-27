package com.logistics.manage.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.logistics.manage.entity.po.WindowPOExample;
import com.logistics.manage.entity.po.WindowPO;
import com.logistics.manage.mapper.WindowPOMapper;
import com.logistics.manage.service.ResultApi;
import com.logistics.manage.service.result.FrontendResult;
import com.logistics.manage.util.HouseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Create 2020-03-18 2:00
 */
@Component("5")
public class WindowService implements ResultApi<WindowPO> {

    @Autowired
    private WindowPOMapper windowPOMapper;


    @Override
    public PageInfo getInfo(Integer pageNumber, String searchName) {

        PageHelper.startPage(pageNumber, 10);

        WindowPOExample windowPOExample = new WindowPOExample();
        windowPOExample.setOrderByClause("create_time desc");
        if(!StringUtils.isEmpty(searchName)){
            //食堂
            WindowPOExample.Criteria criteria1 = windowPOExample.createCriteria();
            criteria1.andCanteenLike("%" + searchName + "%");
            //窗口名
            WindowPOExample.Criteria criteria2 = windowPOExample.createCriteria();
            criteria2.andNameLike("%" + searchName + "%");
            windowPOExample.or(criteria2);
            //电话
            WindowPOExample.Criteria criteria3 = windowPOExample.createCriteria();
            criteria3.andOwnerTelphoneLike("%" + searchName + "%");
            windowPOExample.or(criteria3);
            //性别
            WindowPOExample.Criteria criteria4 = windowPOExample.createCriteria();
            criteria4.andOwnerEqualTo(searchName);
            windowPOExample.or(criteria4);
            //归属人名字
            WindowPOExample.Criteria criteria5 = windowPOExample.createCriteria();
            criteria5.andOwnerNameLike("%" + searchName + "%");
            windowPOExample.or(criteria5);
            if(HouseUtils.isNumber(searchName)){
                //窗口号
                WindowPOExample.Criteria criteria6 = windowPOExample.createCriteria();
                criteria6.andNumberEqualTo(Integer.parseInt(searchName));
                windowPOExample.or(criteria6);
            }
        }

        List<WindowPO> windowPOS = windowPOMapper.selectByExample(windowPOExample);
        PageInfo<WindowPO> windowPOPageInfo = new PageInfo<>(windowPOS);

        return windowPOPageInfo;
    }

    @Override
    public String getType() {
        return "5";
    }

    @Override
    public void addInfo() {

    }

    @Override
    public List<FrontendResult.TableField> getTableField() {

        ArrayList<FrontendResult.TableField> tableFields = new ArrayList<>();
        tableFields.add(new FrontendResult.TableField("所属食堂", "fa fa-building-o"));
        tableFields.add(new FrontendResult.TableField("窗口类型", "fa fa-window-maximize"));
        tableFields.add(new FrontendResult.TableField("窗口号", "fa fa-sort-numeric-desc"));
        tableFields.add(new FrontendResult.TableField("窗口名", "fa fa-first-order"));
        tableFields.add(new FrontendResult.TableField("归属人性别", "fa fa-genderless"));
        tableFields.add(new FrontendResult.TableField("归属人名字", "fa fa-user-o"));
        tableFields.add(new FrontendResult.TableField("归属人电话", "fa fa-phone"));

        return tableFields;
    }
}
