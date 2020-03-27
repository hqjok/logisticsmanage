package com.logistics.manage.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.logistics.manage.entity.po.SuggestPOExample;
import com.logistics.manage.entity.po.SuggestPO;
import com.logistics.manage.entity.po.SuggestPOExample;
import com.logistics.manage.mapper.SuggestPOMapper;
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
@Component("8")
public class SuggestService implements ResultApi<SuggestPO> {

    @Autowired
    private SuggestPOMapper suggestPOMapper;


    @Override
    public PageInfo getInfo(Integer pageNumber, String searchName) {

        PageHelper.startPage(pageNumber, 10);

        SuggestPOExample suggestPOExample = new SuggestPOExample();
        suggestPOExample.setOrderByClause("create_time desc");
        if(!StringUtils.isEmpty(searchName)){
            //提交人
            SuggestPOExample.Criteria criteria1 = suggestPOExample.createCriteria();
            criteria1.andUsernameLike("%" + searchName + "%");
            //内容
            SuggestPOExample.Criteria criteria2 = suggestPOExample.createCriteria();
            criteria2.andContentLike("%" + searchName + "%");
            suggestPOExample.or(criteria2);

        }

        List<SuggestPO> suggestPOS = suggestPOMapper.selectByExampleWithBLOBs(suggestPOExample);
        PageInfo<SuggestPO> suggestPOPageInfo = new PageInfo<>(suggestPOS);

        return suggestPOPageInfo;
    }

    @Override
    public String getType() {
        return "8";
    }

    @Override
    public void addInfo() {

    }

    @Override
    public List<FrontendResult.TableField> getTableField() {

        ArrayList<FrontendResult.TableField> tableFields = new ArrayList<>();
        tableFields.add(new FrontendResult.TableField("提交人名字", "fa fa-user-o"));
        tableFields.add(new FrontendResult.TableField("意见类型", "fa fa-bars"));
        tableFields.add(new FrontendResult.TableField("意见内容", "fa fa-calendar"));

        return tableFields;
    }
}
