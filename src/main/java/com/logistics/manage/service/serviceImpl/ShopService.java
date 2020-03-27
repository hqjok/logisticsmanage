package com.logistics.manage.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.logistics.manage.entity.po.ShopPOExample;
import com.logistics.manage.entity.po.ShopPO;
import com.logistics.manage.entity.po.ShopPOExample;
import com.logistics.manage.mapper.ShopPOMapper;
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
@Component("6")
public class ShopService implements ResultApi<ShopPO> {

    @Autowired
    private ShopPOMapper shopPOMapper;


    @Override
    public PageInfo getInfo(Integer pageNumber, String searchName) {

        PageHelper.startPage(pageNumber, 10);

        ShopPOExample shopPOExample = new ShopPOExample();
        shopPOExample.setOrderByClause("create_time desc");
        if(!StringUtils.isEmpty(searchName)){
            //订单号
            ShopPOExample.Criteria criteria1 = shopPOExample.createCriteria();
            criteria1.andOrderNumLike("%" + searchName + "%");
            //负责人
            ShopPOExample.Criteria criteria2 = shopPOExample.createCriteria();
            criteria2.andDirectorNameLike("%" + searchName + "%");
            shopPOExample.or(criteria2);

            if(HouseUtils.isNumber(searchName)){
                //负责人电话
                ShopPOExample.Criteria criteria5 = shopPOExample.createCriteria();
                criteria5.andDirectorTelphoneEqualTo(Integer.parseInt(searchName));
                shopPOExample.or(criteria5);
            }
        }

        List<ShopPO> shopPOS = shopPOMapper.selectByExample(shopPOExample);
        PageInfo<ShopPO> shopPOPageInfo = new PageInfo<>(shopPOS);

        return shopPOPageInfo;
    }

    @Override
    public String getType() {
        return "6";
    }

    @Override
    public void addInfo() {

    }

    @Override
    public List<FrontendResult.TableField> getTableField() {

        ArrayList<FrontendResult.TableField> tableFields = new ArrayList<>();
        tableFields.add(new FrontendResult.TableField("订单号", "fa fa-first-order"));
        tableFields.add(new FrontendResult.TableField("订单类型", "fa fa-bars"));
        tableFields.add(new FrontendResult.TableField("订单内容", "fa fa-bars"));
        tableFields.add(new FrontendResult.TableField("负责人名字", "fa fa-user-o"));
        tableFields.add(new FrontendResult.TableField("负责人电话", "fa fa-phone"));
        tableFields.add(new FrontendResult.TableField("订单总价", "fa fa-jpy"));
        tableFields.add(new FrontendResult.TableField("购买时间", "fa fa-calendar"));

        return tableFields;
    }
}
