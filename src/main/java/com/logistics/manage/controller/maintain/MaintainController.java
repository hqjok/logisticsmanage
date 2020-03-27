package com.logistics.manage.controller.maintain;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.logistics.manage.entity.ResultCustom;
import com.logistics.manage.entity.ReturnResult;
import com.logistics.manage.entity.po.MaintainPO;
import com.logistics.manage.entity.po.MaintainPOExample;
import com.logistics.manage.entity.searchCondition.MaintainCondition;
import com.logistics.manage.mapper.MaintainPOMapper;
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
 * @Create 2020-03-05 0:06
 */
@Controller
public class MaintainController {

    @Autowired
    private MaintainPOMapper maintainPOMapper;

    /**
     * 根据条件进行查询
     *
     * @param floorCondition
     * @param pageNum
     * @param model
     * @return
     */
    @GetMapping("/maintain/manage/{pageNum}")
    public String maintainManage(MaintainCondition maintainCondition, @PathVariable("pageNum") Integer pageNum,
                             Model model) {

        //查询条件
        MaintainPOExample maintainPOExample = new MaintainPOExample();
        maintainPOExample.setOrderByClause("create_time desc");
        MaintainPOExample.Criteria condition = maintainPOExample.createCriteria();

        //对查询条件做处理
        //维修地址
        if (!StringUtils.isEmpty(maintainCondition.getAddress())) {
            condition.andAddressLike("%" + maintainCondition.getAddress() + "%");
        }
        //预约时间
        if (!StringUtils.isEmpty(maintainCondition.getAppointTime())) {
            condition.andAppointTimeJustDay(maintainCondition.getAppointTime());
        }
        //预约人
        if (!StringUtils.isEmpty(maintainCondition.getSubmitUsername())) {
            condition.andSubmitUsernameLike(maintainCondition.getSubmitUsername());
        }
        //维修状态
        if (maintainCondition.getStatus() != null) {
            condition.andStatusEqualTo(maintainCondition.getStatus());
        }
        //维修类型
        if (maintainCondition.getTypeId() != null && maintainCondition.getTypeId() > 0) {
            condition.andTypeIdEqualTo(maintainCondition.getTypeId());
        }

        PageHelper.startPage(pageNum, 10);
        List<MaintainPO> maintainPOS = maintainPOMapper.selectByExampleWithBLOBs(maintainPOExample);
        PageInfo<MaintainPO> maintainPOPageInfo = new PageInfo<>(maintainPOS);

        //赋值
        ResultCustom result = new ResultCustom(maintainPOPageInfo, maintainPOMapper.countByExample(maintainPOExample), maintainCondition, pageNum);
        model.addAttribute("result", result);

        return "/pages/maintainOrder/list";
    }


    /**
     * 添加
     *
     * @param floorPO
     * @return
     */
    @PostMapping("/maintain/add")
    @ResponseBody
    public ReturnResult maintainAdd(MaintainPO maintainPO) {

        if (maintainPO == null) {
            return new ReturnResult(500, "添加失败！");
        }

        maintainPO.setCreateTime(new Date());
        maintainPO.setStatus(0);
        int i = maintainPOMapper.insertSelective(maintainPO);

        return new ReturnResult(200, "添加成功！");
    }

    /**
     * 单个删除
     *
     * @param id
     * @return
     */
    @GetMapping("/maintain/delete")
    @ResponseBody
    public ReturnResult maintainPODelete(Integer id) {
        if (id == null) {
            return new ReturnResult(500, "删除失败！");
        }
        int i = maintainPOMapper.deleteByPrimaryKey(id);

        return new ReturnResult(200, "删除成功！");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @PostMapping("/maintain/batch/delete")
    @ResponseBody
    public ReturnResult maintainBatchDelete(String ids) {
        if (ids == null) {
            return new ReturnResult(500, "删除失败！");
        }
        List<Integer> idList = HouseUtils.strToIntList(ids);
        maintainPOMapper.batchDelete(idList);

        return new ReturnResult(200, "删除成功！");
    }

    //
    @PostMapping("/maintain/modify")
    @ResponseBody
    public ReturnResult maintainModify(MaintainPO maintainPO) {

        if (maintainPO == null) {
            return new ReturnResult(500, "修改失败！");
        }
        maintainPOMapper.updateByPrimaryKeySelective(maintainPO);

        return new ReturnResult(200, "修改成功！");
    }
}
