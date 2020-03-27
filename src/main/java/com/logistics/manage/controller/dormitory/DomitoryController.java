package com.logistics.manage.controller.dormitory;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.logistics.manage.entity.ResultCustom;
import com.logistics.manage.entity.ReturnResult;
import com.logistics.manage.entity.po.DomitoryPO;
import com.logistics.manage.entity.po.DomitoryPOExample;
import com.logistics.manage.entity.searchCondition.DormitoryCondition;
import com.logistics.manage.mapper.DomitoryPOMapper;
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
 * @Create 2020-03-04 1:05
 */
@Controller
public class DomitoryController {

    @Autowired
    private DomitoryPOMapper domitoryPOMapper;

    /**
     * 根据条件进行查询
     *
     * @param floorCondition
     * @param pageNum
     * @param model
     * @return
     */
    @GetMapping("/dormitory/manage/{pageNum}")
    public String dormitoryManage(DormitoryCondition dormitoryCondition, @PathVariable("pageNum") Integer pageNum,
                              Model model) {

        //查询条件
        DomitoryPOExample domitoryPOExample = new DomitoryPOExample();
        domitoryPOExample.setOrderByClause("create_time desc");
        DomitoryPOExample.Criteria condition = domitoryPOExample.createCriteria();

        //对查询条件做处理
        //居住时间
        if (!StringUtils.isEmpty(dormitoryCondition.getLiveTime())) {
            condition.andLiveTimeJustDay(dormitoryCondition.getLiveTime());
        }
        //所属楼栋
        if (!StringUtils.isEmpty(dormitoryCondition.getAddress())) {
            condition.andAddressLike("%" + dormitoryCondition.getAddress() + "%");
        }
        //宿舍号
        if (dormitoryCondition.getDormitoryNumber() != null && dormitoryCondition.getDormitoryNumber() > 0) {
            condition.andDormitoryNumberEqualTo(dormitoryCondition.getDormitoryNumber());
        }
        //床位号
        if (dormitoryCondition.getBedNumber() != null && dormitoryCondition.getBedNumber() > 0) {
            condition.andBedNumberEqualTo(dormitoryCondition.getBedNumber());
        }
        //名字
        if (!StringUtils.isEmpty(dormitoryCondition.getName())) {
            condition.andNameLike("%" + dormitoryCondition.getName() + "%");
        }
        //电话号码
        if (!StringUtils.isEmpty(dormitoryCondition.getTelphone())) {
            condition.andTelphoneLike("%" + dormitoryCondition.getTelphone() + "%");
        }

        PageHelper.startPage(pageNum, 10);
        List<DomitoryPO> domitoryPOS = domitoryPOMapper.selectByExample(domitoryPOExample);
        PageInfo<DomitoryPO> visitPOPageInfo = new PageInfo<>(domitoryPOS);

        //赋值
        ResultCustom result = new ResultCustom(visitPOPageInfo, domitoryPOMapper.countByExample(domitoryPOExample), dormitoryCondition, pageNum);
        model.addAttribute("result", result);

        return "/pages/dormitory/dormitoryManage/list";
    }


    /**
     * 添加
     * @param floorPO
     * @return
     */
    @PostMapping("/dormitory/add")
    @ResponseBody
    public ReturnResult dormitoryAdd(DomitoryPO domitoryPO) {

        if (domitoryPO == null) {
            return new ReturnResult(500, "添加失败！");
        }

        domitoryPO.setCreateTime(new Date());
        int i = domitoryPOMapper.insertSelective(domitoryPO);

        return new ReturnResult(200, "添加成功！");
    }

    /**
     * 单个删除
     * @param id
     * @return
     */
    @GetMapping("/dormitory/delete")
    @ResponseBody
    public ReturnResult domitoryPODelete(Integer id){
        if(id == null){
            return new ReturnResult(500, "删除失败！");
        }
        int i = domitoryPOMapper.deleteByPrimaryKey(id);

        return new ReturnResult(200, "删除成功！");
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("/dormitory/batch/delete")
    @ResponseBody
    public ReturnResult dormitoryBatchDelete(String ids){
        if(ids == null){
            return new ReturnResult(500, "删除失败！");
        }
        List<Integer> idList = HouseUtils.strToIntList(ids);
//        int i = floorPOMapper.deleteByPrimaryKey(id);
        domitoryPOMapper.batchDelete(idList);

        return new ReturnResult(200, "删除成功！");
    }
    //
    @PostMapping("/dormitory/modify")
    @ResponseBody
    public ReturnResult dormitoryModify(DomitoryPO domitoryPO){

        if(domitoryPO == null){
            return new ReturnResult(500, "修改失败！");
        }
        domitoryPOMapper.updateByPrimaryKeySelective(domitoryPO);

        return new ReturnResult(200, "修改成功！");
    }
}
