package com.logistics.manage.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.logistics.manage.entity.po.FloorPO;
import com.logistics.manage.entity.po.FloorPOExample;
import com.logistics.manage.mapper.FloorPOMapper;
import com.logistics.manage.service.ResultApi;
import com.logistics.manage.service.result.FrontendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Create 2020-03-18 2:00
 */
@Component("1")
public class FloorService implements ResultApi<FloorPO> {

    @Autowired
    private FloorPOMapper floorPOMapper;


    @Override
    public PageInfo getInfo(Integer pageNumber, String searchName) {

        PageHelper.startPage(pageNumber, 10);
        FloorPOExample floorPOExample = new FloorPOExample();
        floorPOExample.setOrderByClause("create_time desc");
        if(!StringUtils.isEmpty(searchName)){
            //地址模糊
            FloorPOExample.Criteria criteria1 = floorPOExample.createCriteria();
            criteria1.andAddressLike("%" + searchName + "%");
            //负责人模糊
            FloorPOExample.Criteria criteria2 = floorPOExample.createCriteria();
            criteria2.andDiretorLike("%" + searchName + "%");
            floorPOExample.or(criteria2);
            //电话
            FloorPOExample.Criteria criteria3 = floorPOExample.createCriteria();
            criteria3.andTelphoneLike("%" + searchName + "%");
            floorPOExample.or(criteria3);
            //性别
            FloorPOExample.Criteria criteria4 = floorPOExample.createCriteria();
            criteria4.andSexEqualTo(searchName);
            floorPOExample.or(criteria4);
        }
        List<FloorPO> floorPOS = floorPOMapper.selectByExample(floorPOExample);
        PageInfo<FloorPO> floorPOPageInfo = new PageInfo<>(floorPOS);

        return floorPOPageInfo;
    }

    @Override
    public String getType() {
        return "1";
    }

    @Override
    public void addInfo() {

    }

    @Override
    public List<FrontendResult.TableField> getTableField() {

        ArrayList<FrontendResult.TableField> tableFields = new ArrayList<>();
        tableFields.add(new FrontendResult.TableField("楼栋地址", "fa fa-first-order"));
        tableFields.add(new FrontendResult.TableField("负责人", "fa fa-user-o"));
        tableFields.add(new FrontendResult.TableField("性别", "fa fa-genderless"));
        tableFields.add(new FrontendResult.TableField("电话", "fa fa-phone"));

        return tableFields;
    }
}
