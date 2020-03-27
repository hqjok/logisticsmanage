package com.logistics.manage.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.logistics.manage.entity.po.MaintainPO;
import com.logistics.manage.entity.po.MaintainPOExample;
import com.logistics.manage.entity.po.MaintainPOExample;
import com.logistics.manage.mapper.MaintainPOMapper;
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
@Component("7")
public class MaintainService implements ResultApi<MaintainPO> {

    @Autowired
    private MaintainPOMapper maintainPOMapper;


    @Override
    public PageInfo getInfo(Integer pageNumber, String searchName) {

        PageHelper.startPage(pageNumber, 10);

        MaintainPOExample maintainPOExample = new MaintainPOExample();
        maintainPOExample.setOrderByClause("create_time desc");
        if(!StringUtils.isEmpty(searchName)){
            //地址
            MaintainPOExample.Criteria criteria1 = maintainPOExample.createCriteria();
            criteria1.andAddressLike("%" + searchName + "%");
            //提交人
            MaintainPOExample.Criteria criteria2 = maintainPOExample.createCriteria();
            criteria2.andSubmitUsernameLike("%" + searchName + "%");
            maintainPOExample.or(criteria2);
            //电话
            MaintainPOExample.Criteria criteria3 = maintainPOExample.createCriteria();
            criteria3.andTelphoneLike("%" + searchName + "%");
            maintainPOExample.or(criteria3);
        }

        List<MaintainPO> maintainPOS = maintainPOMapper.selectByExampleWithBLOBs(maintainPOExample);
        PageInfo<MaintainPO> maintainPOPageInfo = new PageInfo<>(maintainPOS);

        return maintainPOPageInfo;
    }

    @Override
    public String getType() {
        return "7";
    }

    @Override
    public void addInfo() {

    }

    @Override
    public List<FrontendResult.TableField> getTableField() {

        ArrayList<FrontendResult.TableField> tableFields = new ArrayList<>();
        tableFields.add(new FrontendResult.TableField("维修地址", "fa fa-building-o"));
        tableFields.add(new FrontendResult.TableField("维修类型", "fa fa-bars"));
        tableFields.add(new FrontendResult.TableField("电话", "fa fa-phone"));
        tableFields.add(new FrontendResult.TableField("提交人", "fa fa-user-o"));
        tableFields.add(new FrontendResult.TableField("状态", "fa fa-exclamation-circle"));
        tableFields.add(new FrontendResult.TableField("维修描述", "fa fa-calendar"));
        tableFields.add(new FrontendResult.TableField("预约时间", "fa fa-calendar"));


        return tableFields;
    }
}
