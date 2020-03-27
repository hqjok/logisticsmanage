package com.logistics.manage.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.logistics.manage.entity.po.*;
import com.logistics.manage.mapper.FloorPOMapper;
import com.logistics.manage.mapper.VisitPOMapper;
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
@Component("3")
public class VisitService implements ResultApi<FloorPO> {

    @Autowired
    private VisitPOMapper visitPOMapper;


    @Override
    public PageInfo getInfo(Integer pageNumber, String searchName) {

        PageHelper.startPage(pageNumber, 10);

        VisitPOExample visitPOExample = new VisitPOExample();
        visitPOExample.setOrderByClause("create_time desc");
        if(!StringUtils.isEmpty(searchName)){
            //地址
            VisitPOExample.Criteria criteria1 = visitPOExample.createCriteria();
            criteria1.andAddressLike("%" + searchName + "%");
            //拜访人
            VisitPOExample.Criteria criteria2 = visitPOExample.createCriteria();
            criteria2.andVisitorLike("%" + searchName + "%");
            visitPOExample.or(criteria2);
            //电话
            VisitPOExample.Criteria criteria3 = visitPOExample.createCriteria();
            criteria3.andTelphoneLike("%" + searchName + "%");
            visitPOExample.or(criteria3);
            //拜访原因
            VisitPOExample.Criteria criteria4 = visitPOExample.createCriteria();
            criteria4.andReasonLike("%" + searchName + "%");
            visitPOExample.or(criteria4);
        }
        List<VisitPO> visitPOS = visitPOMapper.selectByExample(visitPOExample);
        PageInfo<VisitPO> visitPOPageInfo = new PageInfo<>(visitPOS);

        return visitPOPageInfo;
    }

    @Override
    public String getType() {
        return "3";
    }

    @Override
    public void addInfo() {

    }

    @Override
    public List<FrontendResult.TableField> getTableField() {

        ArrayList<FrontendResult.TableField> tableFields = new ArrayList<>();
        tableFields.add(new FrontendResult.TableField("拜访地址", "fa fa-building-o"));
        tableFields.add(new FrontendResult.TableField("拜访人", "fa fa-user-o"));
        tableFields.add(new FrontendResult.TableField("电话", "fa fa-phone"));
        tableFields.add(new FrontendResult.TableField("拜访原因", "fa fa-question-circle-o"));
        tableFields.add(new FrontendResult.TableField("拜访时间", "fa fa-calendar"));
        tableFields.add(new FrontendResult.TableField("离开时间", "fa fa-calendar"));

        return tableFields;
    }
}
