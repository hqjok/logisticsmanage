package com.logistics.manage.controller.shopping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.logistics.manage.entity.ResultCustom;
import com.logistics.manage.entity.ReturnResult;
import com.logistics.manage.entity.po.ShopPO;
import com.logistics.manage.entity.po.VisitPO;
import com.logistics.manage.entity.po.ShopPO;
import com.logistics.manage.entity.po.ShopPOExample;
import com.logistics.manage.entity.searchCondition.ShopCondition;
import com.logistics.manage.mapper.ShopPOMapper;
import com.logistics.manage.util.HouseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @Create 2020-02-29 16:30
 */
@Controller
public class ShopController {

    @Autowired
    private ShopPOMapper shopPOMapper;

    /**
     * 根据条件进行查询
     *
     * @param floorCondition
     * @param pageNum
     * @param model
     * @return
     */
    @GetMapping("/shop/manage/{pageNum}")
    public String shopManage(ShopCondition shopCondition, @PathVariable("pageNum") Integer pageNum,
                               Model model) {

        //查询条件
        ShopPOExample shopPOExample = new ShopPOExample();
        shopPOExample.setOrderByClause("create_time desc");
        ShopPOExample.Criteria condition = shopPOExample.createCriteria();

        //对查询条件做处理
        //订单号
        if (!StringUtils.isEmpty(shopCondition.getOrderNum())) {
            condition.andOrderNumLike("%" + shopCondition.getOrderNum() + "%");
        }
        //订单内容
        if (!StringUtils.isEmpty(shopCondition.getOrderContent())) {
            condition.andOrderContentLike("%" + shopCondition.getOrderContent() + "%");
        }
        //采购时间
        if (!StringUtils.isEmpty(shopCondition.getShopTime())) {
            condition.andShopTimeJustDay(shopCondition.getShopTime());
        }
        //采购时间
        if (shopCondition.getTelphone() != null && shopCondition.getTelphone() > 0) {
            condition.andDirectorTelphoneEqualTo(shopCondition.getTelphone());
        }
        //负责人名字
        if (!StringUtils.isEmpty(shopCondition.getDirectorName())) {
            condition.andDirectorNameLike("%" + shopCondition.getDirectorName() + "%");
        }
        //采购类型
        if (shopCondition.getTypeId() != null && shopCondition.getTypeId() > 0) {
            condition.andTypeIdEqualTo(shopCondition.getTypeId());
        }

        PageHelper.startPage(pageNum, 10);
        List<ShopPO> shopPOS = shopPOMapper.selectByExample(shopPOExample);
        PageInfo<ShopPO> shopPOPageInfo = new PageInfo<>(shopPOS);

        //赋值
        ResultCustom result = new ResultCustom(shopPOPageInfo, shopPOMapper.countByExample(shopPOExample), shopCondition, pageNum);
        model.addAttribute("result", result);

        return "/pages/purchaseOrder/list";
    }


    /**
     * 添加
     *
     * @param floorPO
     * @return
     */
    @PostMapping("/shop/add")
    @ResponseBody
    public ReturnResult shopAdd(ShopPO shopPO) {

        if (shopPO == null) {
            return new ReturnResult(500, "添加失败！");
        }

        shopPO.setOrderNum(HouseUtils.getOrderNumber());
        shopPO.setCreateTime(new Date());
        int i = shopPOMapper.insertSelective(shopPO);

        return new ReturnResult(200, "添加成功！");
    }

    /**
     * 单个删除
     *
     * @param id
     * @return
     */
    @GetMapping("/shop/delete")
    @ResponseBody
    public ReturnResult shopPODelete(Integer id) {
        if (id == null) {
            return new ReturnResult(500, "删除失败！");
        }
        int i = shopPOMapper.deleteByPrimaryKey(id);

        return new ReturnResult(200, "删除成功！");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @PostMapping("/shop/batch/delete")
    @ResponseBody
    public ReturnResult shopBatchDelete(String ids) {
        if (ids == null) {
            return new ReturnResult(500, "删除失败！");
        }
        List<Integer> idList = HouseUtils.strToIntList(ids);
        shopPOMapper.batchDelete(idList);

        return new ReturnResult(200, "删除成功！");
    }

    //
    @PostMapping("/shop/modify")
    @ResponseBody
    public ReturnResult shopModify(ShopPO shopPO) {

        if (shopPO == null) {
            return new ReturnResult(500, "修改失败！");
        }
        shopPOMapper.updateByPrimaryKeySelective(shopPO);

        return new ReturnResult(200, "修改成功！");
    }
}
