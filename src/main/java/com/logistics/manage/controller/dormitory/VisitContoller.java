package com.logistics.manage.controller.dormitory;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.logistics.manage.entity.ResultCustom;
import com.logistics.manage.entity.ReturnResult;
import com.logistics.manage.entity.po.FloorPO;
import com.logistics.manage.entity.po.FloorPOExample;
import com.logistics.manage.entity.po.VisitPO;
import com.logistics.manage.entity.po.VisitPOExample;
import com.logistics.manage.entity.searchCondition.FloorCondition;
import com.logistics.manage.entity.searchCondition.VisitCondition;
import com.logistics.manage.mapper.VisitPOMapper;
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
 * @Create 2020-02-29 16:16
 */
@Controller
public class VisitContoller {

    @Autowired
    private VisitPOMapper visitPOMapper;

    /**
     * 根据条件进行查询
     *
     * @param floorCondition
     * @param pageNum
     * @param model
     * @return
     */
    @GetMapping("/visit/manage/{pageNum}")
    public String visitManage(VisitCondition visitCondition, @PathVariable("pageNum") Integer pageNum,
                              Model model) {

        //查询条件
        VisitPOExample visitPOExample = new VisitPOExample();
        visitPOExample.setOrderByClause("create_time desc");
        VisitPOExample.Criteria condition = visitPOExample.createCriteria();

        //对查询条件做处理
        //到访时间
        if (!StringUtils.isEmpty(visitCondition.getVisitTime())) {
            condition.andVisitTimeJustDay(visitCondition.getVisitTime());
        }
        //地址
        if (!StringUtils.isEmpty(visitCondition.getAddress())) {
            condition.andAddressLike("%" + visitCondition.getAddress() + "%");
        }
        //离开时间
        if (!StringUtils.isEmpty(visitCondition.getLeaveTime())) {
            condition.andLeaveTimeJustDay(visitCondition.getLeaveTime());
        }
        //电话
        if (!StringUtils.isEmpty(visitCondition.getTelphone())) {
            condition.andTelphoneLike("%" + visitCondition.getTelphone() + "%");
        }
        //到访人
        if (!StringUtils.isEmpty(visitCondition.getVisitor())) {
            condition.andVisitorLike("%" + visitCondition.getVisitor() + "%");
        }

        PageHelper.startPage(pageNum, 10);
        List<VisitPO> visitPOS = visitPOMapper.selectByExample(visitPOExample);
        PageInfo<VisitPO> visitPOPageInfo = new PageInfo<>(visitPOS);

        //赋值
        ResultCustom result = new ResultCustom(visitPOPageInfo, visitPOMapper.countByExample(visitPOExample), visitCondition, pageNum);
        model.addAttribute("result", result);

        return "/pages/dormitory/visitRecord/list";
    }


    /**
     * 添加
     * @param floorPO
     * @return
     */
    @PostMapping("/visit/add")
    @ResponseBody
    public ReturnResult visitAdd(VisitPO visitPO) {

        if (visitPO == null) {
            return new ReturnResult(500, "添加失败！");
        }

        visitPO.setCreateTime(new Date());
        int i = visitPOMapper.insertSelective(visitPO);

        return new ReturnResult(200, "添加成功！");
    }

    /**
     * 单个删除
     * @param id
     * @return
     */
    @GetMapping("/visit/delete")
    @ResponseBody
    public ReturnResult visitDelete(Integer id){
        if(id == null){
            return new ReturnResult(500, "删除失败！");
        }
        int i = visitPOMapper.deleteByPrimaryKey(id);

        return new ReturnResult(200, "删除成功！");
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("/visit/batch/delete")
    @ResponseBody
    public ReturnResult floorBatchDelete(String ids){
        if(ids == null){
            return new ReturnResult(500, "删除失败！");
        }
        List<Integer> idList = HouseUtils.strToIntList(ids);
//        int i = floorPOMapper.deleteByPrimaryKey(id);
        visitPOMapper.batchDelete(idList);

        return new ReturnResult(200, "删除成功！");
    }
//
    @PostMapping("/visit/modify")
    @ResponseBody
    public ReturnResult visitModify(VisitPO visitPO){

        if(visitPO == null){
            return new ReturnResult(500, "修改失败！");
        }
        visitPOMapper.updateByPrimaryKeySelective(visitPO);

        return new ReturnResult(200, "修改成功！");
    }
}
