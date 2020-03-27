package com.logistics.manage.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.logistics.manage.entity.po.CanteenPO;
import com.logistics.manage.entity.po.CanteenPOExample;
import com.logistics.manage.entity.po.CanteenPOExample;
import com.logistics.manage.mapper.CanteenPOMapper;
import com.logistics.manage.mapper.CanteenPOMapper;
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
@Component("4")
public class CanteenService implements ResultApi<CanteenPO> {

    @Autowired
    private CanteenPOMapper canteenPOMapper;


    @Override
    public PageInfo getInfo(Integer pageNumber, String searchName) {

        PageHelper.startPage(pageNumber, 10);

        CanteenPOExample canteenPOExample = new CanteenPOExample();
        canteenPOExample.setOrderByClause("create_time desc");
        if(!StringUtils.isEmpty(searchName)){
            //地址
            CanteenPOExample.Criteria criteria1 = canteenPOExample.createCriteria();
            criteria1.andAddressLike("%" + searchName + "%");
            //公司
            CanteenPOExample.Criteria criteria2 = canteenPOExample.createCriteria();
            criteria2.andCompanyLike("%" + searchName + "%");
            canteenPOExample.or(criteria2);
            //电话
            CanteenPOExample.Criteria criteria3 = canteenPOExample.createCriteria();
            criteria3.andTelphoneLike("%" + searchName + "%");
            canteenPOExample.or(criteria3);
            //性别
            CanteenPOExample.Criteria criteria4 = canteenPOExample.createCriteria();
            criteria4.andSexEqualTo(searchName);
            canteenPOExample.or(criteria4);
            //负责人
            CanteenPOExample.Criteria criteria5 = canteenPOExample.createCriteria();
            criteria5.andDirectorLike("%" + searchName + "%");
            canteenPOExample.or(criteria5);

        }

        List<CanteenPO> canteenPOS = canteenPOMapper.selectByExample(canteenPOExample);
        PageInfo<CanteenPO> canteenPOPageInfo = new PageInfo<>(canteenPOS);

        return canteenPOPageInfo;
    }

    @Override
    public String getType() {
        return "4";
    }

    @Override
    public void addInfo() {

    }

    @Override
    public List<FrontendResult.TableField> getTableField() {

        ArrayList<FrontendResult.TableField> tableFields = new ArrayList<>();
        tableFields.add(new FrontendResult.TableField("食堂地址", "fa fa-building-o"));
        tableFields.add(new FrontendResult.TableField("所属公司", "fa fa-copyright"));
        tableFields.add(new FrontendResult.TableField("食堂负责人", "fa fa-user-o"));
        tableFields.add(new FrontendResult.TableField("电话", "fa fa-phone"));
        tableFields.add(new FrontendResult.TableField("性别", "fa fa-genderless"));
        return tableFields;
    }
}
