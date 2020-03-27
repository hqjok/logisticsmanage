package com.logistics.manage.controller.dormitory;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.logistics.manage.entity.ReturnResult;
import com.logistics.manage.entity.po.FloorPO;
import com.logistics.manage.entity.po.FloorPOExample;
import com.logistics.manage.entity.ResultCustom;
import com.logistics.manage.entity.searchCondition.FloorCondition;
import com.logistics.manage.mapper.FloorPOMapper;
import com.logistics.manage.util.HouseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.NumberUtils;
import org.thymeleaf.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @Create 2020-02-29 16:15
 */
@Controller
public class FloorController {

    @Autowired
    private FloorPOMapper floorPOMapper;

    /**
     * 根据条件进行查询
     *
     * @param floorCondition
     * @param pageNum
     * @param model
     * @return
     */
    @GetMapping("/floor/manage/{pageNum}")
    public String floorManage(FloorCondition floorCondition, @PathVariable("pageNum") Integer pageNum,
                              Model model) {

        //查询条件
        FloorPOExample floorPOExample = new FloorPOExample();
        floorPOExample.setOrderByClause("create_time desc");
        FloorPOExample.Criteria condition = floorPOExample.createCriteria();

        //对查询条件做处理
        //性别
        if (!StringUtils.isEmpty(floorCondition.getSex())) {
            condition.andSexEqualTo(floorCondition.getSex());
        }
        //地址
        if (!StringUtils.isEmpty(floorCondition.getAddress())) {
            condition.andAddressLike("%" + floorCondition.getAddress() + "%");
        }
        //宿管
        if (!StringUtils.isEmpty(floorCondition.getDirector())) {
            condition.andDiretorLike("%" + floorCondition.getDirector() + "%");
        }
        //电话
        if (!StringUtils.isEmpty(floorCondition.getTelphone())) {
            condition.andTelphoneLike("%" + floorCondition.getTelphone() + "%");
        }

        PageHelper.startPage(pageNum, 10);
        List<FloorPO> floors = floorPOMapper.selectByExample(floorPOExample);
        PageInfo<FloorPO> floorPOPageInfo = new PageInfo<>(floors);

        //赋值
        ResultCustom result = new ResultCustom(floorPOPageInfo, floorPOMapper.countByExample(floorPOExample), floorCondition, pageNum);
        model.addAttribute("result", result);

        return "/pages/dormitory/dormitoryBuilding/list";
    }


    /**
     * 添加
     * @param floorPO
     * @return
     */
    @PostMapping("/floor/add")
    @ResponseBody
    public ReturnResult floorAdd(FloorPO floorPO) {

        if (floorPO == null) {
            return new ReturnResult(500, "添加失败！");
        }

        floorPO.setCreateTime(new Date());
        int i = floorPOMapper.insertSelective(floorPO);

        return new ReturnResult(200, "添加成功！");
    }

    /**
     * 单个删除
     * @param id
     * @return
     */
    @GetMapping("/floor/delete")
    @ResponseBody
    public ReturnResult floorDelete(Integer id){
        if(id == null){
            return new ReturnResult(500, "删除失败！");
        }
        int i = floorPOMapper.deleteByPrimaryKey(id);

        return new ReturnResult(200, "删除成功！");
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("/floor/batch/delete")
    @ResponseBody
    public ReturnResult floorBatchDelete(String ids){
        if(ids == null){
            return new ReturnResult(500, "删除失败！");
        }
        List<Integer> idList = HouseUtils.strToIntList(ids);
//        int i = floorPOMapper.deleteByPrimaryKey(id);
        floorPOMapper.batchDelete(idList);

        return new ReturnResult(200, "删除成功！");
    }

    @PostMapping("/floor/modify")
    @ResponseBody
    public ReturnResult floorModify(FloorPO floorPO){

        if(floorPO == null){
            return new ReturnResult(500, "修改失败！");
        }
        floorPOMapper.updateByPrimaryKeySelective(floorPO);

        return new ReturnResult(200, "修改成功！");
    }
}
