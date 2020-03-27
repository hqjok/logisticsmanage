package com.logistics.manage.controller.canteen;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.logistics.manage.entity.ResultCustom;
import com.logistics.manage.entity.ReturnResult;
import com.logistics.manage.entity.po.CanteenPO;
import com.logistics.manage.entity.po.DomitoryPO;
import com.logistics.manage.entity.po.CanteenPOExample;
import com.logistics.manage.entity.searchCondition.CanteenCondition;
import com.logistics.manage.mapper.CanteenPOMapper;
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
 * @Create 2020-02-29 16:26
 */
@Controller
public class CanteenController {

    @Autowired
    private CanteenPOMapper canteenPOMapper;

    /**
     * 根据条件进行查询
     *
     * @param floorCondition
     * @param pageNum
     * @param model
     * @return
     */
    @GetMapping("/canteen/manage/{pageNum}")
    public String canteenManage(CanteenCondition canteenCondition, @PathVariable("pageNum") Integer pageNum,
                                  Model model) {

        //查询条件
        CanteenPOExample canteenPOExample = new CanteenPOExample();
        canteenPOExample.setOrderByClause("create_time desc");
        CanteenPOExample.Criteria condition = canteenPOExample.createCriteria();

        //对查询条件做处理
        //所属楼栋
        if (!StringUtils.isEmpty(canteenCondition.getAddress())) {
            condition.andAddressLike("%" + canteenCondition.getAddress() + "%");
        }
        //负责人
        if (!StringUtils.isEmpty(canteenCondition.getDirector())) {
            condition.andDirectorLike("%" + canteenCondition.getDirector() + "%");
        }
        //公司
        if (!StringUtils.isEmpty(canteenCondition.getCompany())) {
            condition.andCompanyLike("%" + canteenCondition.getCompany() + "%");
        }
        //电话号码
        if (!StringUtils.isEmpty(canteenCondition.getTelphone())) {
            condition.andTelphoneLike("%" + canteenCondition.getTelphone() + "%");
        }

        PageHelper.startPage(pageNum, 10);
        List<CanteenPO> canteenPOS = canteenPOMapper.selectByExample(canteenPOExample);
        PageInfo<CanteenPO> visitPOPageInfo = new PageInfo<>(canteenPOS);

        //赋值
        ResultCustom result = new ResultCustom(visitPOPageInfo, canteenPOMapper.countByExample(canteenPOExample), canteenCondition, pageNum);
        model.addAttribute("result", result);

        return "/pages/refectory/refectoryBuilding/list";
    }


    /**
     * 添加
     * @param floorPO
     * @return
     */
    @PostMapping("/canteen/add")
    @ResponseBody
    public ReturnResult canteenAdd(CanteenPO canteenPO) {

        if (canteenPO == null) {
            return new ReturnResult(500, "添加失败！");
        }

        canteenPO.setCreateTime(new Date());
        int i = canteenPOMapper.insertSelective(canteenPO);

        return new ReturnResult(200, "添加成功！");
    }

    /**
     * 单个删除
     * @param id
     * @return
     */
    @GetMapping("/canteen/delete")
    @ResponseBody
    public ReturnResult canteenPODelete(Integer id){
        if(id == null){
            return new ReturnResult(500, "删除失败！");
        }
        int i = canteenPOMapper.deleteByPrimaryKey(id);

        return new ReturnResult(200, "删除成功！");
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("/canteen/batch/delete")
    @ResponseBody
    public ReturnResult canteenBatchDelete(String ids){
        if(ids == null){
            return new ReturnResult(500, "删除失败！");
        }
        List<Integer> idList = HouseUtils.strToIntList(ids);
//        int i = floorPOMapper.deleteByPrimaryKey(id);
        canteenPOMapper.batchDelete(idList);

        return new ReturnResult(200, "删除成功！");
    }
    //
    @PostMapping("/canteen/modify")
    @ResponseBody
    public ReturnResult canteenModify(CanteenPO canteenPO){

        if(canteenPO == null){
            return new ReturnResult(500, "修改失败！");
        }
        canteenPOMapper.updateByPrimaryKeySelective(canteenPO);

        return new ReturnResult(200, "修改成功！");
    }
}
