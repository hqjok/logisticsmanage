package com.logistics.manage.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.logistics.manage.entity.po.DomitoryPO;
import com.logistics.manage.entity.po.DomitoryPOExample;
import com.logistics.manage.entity.po.FloorPO;
import com.logistics.manage.entity.po.FloorPOExample;
import com.logistics.manage.mapper.DomitoryPOMapper;
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
@Component("2")
public class DormitoryService implements ResultApi<DomitoryPO> {

    @Autowired
    private DomitoryPOMapper domitoryPOMapper;


    @Override
    public PageInfo getInfo(Integer pageNumber, String searchName) {

        PageHelper.startPage(pageNumber, 10);
        DomitoryPOExample domitoryPOExample = new DomitoryPOExample();
        domitoryPOExample.setOrderByClause("create_time desc");
        if(!StringUtils.isEmpty(searchName)){
            //地址
            DomitoryPOExample.Criteria criteria1 = domitoryPOExample.createCriteria();
            criteria1.andAddressLike("%" + searchName + "%");
            //宿管
            DomitoryPOExample.Criteria criteria2 = domitoryPOExample.createCriteria();
            criteria2.andNameLike("%" + searchName + "%");
            domitoryPOExample.or(criteria2);
            //电话
            DomitoryPOExample.Criteria criteria3 = domitoryPOExample.createCriteria();
            criteria3.andTelphoneLike("%" + searchName + "%");
            domitoryPOExample.or(criteria3);
            //性别
            DomitoryPOExample.Criteria criteria4 = domitoryPOExample.createCriteria();
            criteria4.andSexEqualTo(searchName);
            domitoryPOExample.or(criteria4);

            if(HouseUtils.isNumber(searchName)){
                //宿舍号
                DomitoryPOExample.Criteria criteria5 = domitoryPOExample.createCriteria();
                criteria5.andDormitoryNumberEqualTo(Integer.parseInt(searchName));
                domitoryPOExample.or(criteria5);
                //床位
                DomitoryPOExample.Criteria criteria6 = domitoryPOExample.createCriteria();
                criteria6.andBedNumberEqualTo(Integer.parseInt(searchName));
                domitoryPOExample.or(criteria6);
            }
        }

        List<DomitoryPO> domitoryPOS = domitoryPOMapper.selectByExample(domitoryPOExample);
        PageInfo<DomitoryPO> domitoryPOPageInfo = new PageInfo<>(domitoryPOS);

        return domitoryPOPageInfo;
    }

    @Override
    public String getType() {
        return "2";
    }

    @Override
    public void addInfo() {

    }

    @Override
    public List<FrontendResult.TableField> getTableField() {

        ArrayList<FrontendResult.TableField> tableFields = new ArrayList<>();
        tableFields.add(new FrontendResult.TableField("楼栋地址", "fa fa-building-o"));
        tableFields.add(new FrontendResult.TableField("学生名字", "fa fa-user-o"));
        tableFields.add(new FrontendResult.TableField("电话", "fa fa-phone"));
        tableFields.add(new FrontendResult.TableField("性别", "fa fa-genderless"));
        tableFields.add(new FrontendResult.TableField("宿舍号", "fa fa-bed"));
        tableFields.add(new FrontendResult.TableField("床位", "fa fa-bed"));
        tableFields.add(new FrontendResult.TableField("入住时间", "fa fa-calendar"));

        return tableFields;
    }
}
