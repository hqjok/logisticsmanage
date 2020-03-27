package com.logistics.manage.controller.canteen;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.logistics.manage.entity.ResultCustom;
import com.logistics.manage.entity.ReturnResult;
import com.logistics.manage.entity.po.WindowPO;
import com.logistics.manage.entity.po.WindowPOExample;
import com.logistics.manage.entity.searchCondition.WindowCondition;
import com.logistics.manage.mapper.WindowPOMapper;
import com.logistics.manage.mapper.WindowPOMapper;
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
public class WindowController {

    @Autowired
    private WindowPOMapper windowPOMapper;

    /**
     * 根据条件进行查询
     *
     * @param floorCondition
     * @param pageNum
     * @param model
     * @return
     */
    @GetMapping("/window/manage/{pageNum}")
    public String windowManage(WindowCondition windowCondition, @PathVariable("pageNum") Integer pageNum,
                               Model model) {

        //查询条件
        WindowPOExample windowPOExample = new WindowPOExample();
        windowPOExample.setOrderByClause("create_time desc");
        WindowPOExample.Criteria condition = windowPOExample.createCriteria();

        //对查询条件做处理
        //所属食堂
        if (!StringUtils.isEmpty(windowCondition.getCanteen())) {
            condition.andCanteenLike("%" + windowCondition.getCanteen() + "%");
        }
        //窗口名
        if (!StringUtils.isEmpty(windowCondition.getName())) {
            condition.andNameLike("%" + windowCondition.getName() + "%");
        }
        //窗口号
        if (windowCondition.getNumber() != null && windowCondition.getNumber() > 0) {
            condition.andNumberEqualTo(windowCondition.getNumber());
        }
        //电话号码
        if (!StringUtils.isEmpty(windowCondition.getTelphone())) {
            condition.andOwnerTelphoneLike("%" + windowCondition.getTelphone() + "%");
        }
        //所属人名字
        if (!StringUtils.isEmpty(windowCondition.getOwnerName())) {
            condition.andOwnerNameLike("%" + windowCondition.getOwnerName() + "%");
        }

        PageHelper.startPage(pageNum, 10);
        List<WindowPO> windowPOS = windowPOMapper.selectByExample(windowPOExample);
        PageInfo<WindowPO> windowPOPageInfo = new PageInfo<>(windowPOS);

        //赋值
        ResultCustom result = new ResultCustom(windowPOPageInfo, windowPOMapper.countByExample(windowPOExample), windowCondition, pageNum);
        model.addAttribute("result", result);

        return "/pages/refectory/refectoryWindow/list";
    }


    /**
     * 添加
     *
     * @param floorPO
     * @return
     */
    @PostMapping("/window/add")
    @ResponseBody
    public ReturnResult windowAdd(WindowPO windowPO) {

        if (windowPO == null) {
            return new ReturnResult(500, "添加失败！");
        }

        windowPO.setCreateTime(new Date());
        int i = windowPOMapper.insertSelective(windowPO);

        return new ReturnResult(200, "添加成功！");
    }

    /**
     * 单个删除
     *
     * @param id
     * @return
     */
    @GetMapping("/window/delete")
    @ResponseBody
    public ReturnResult windowPODelete(Integer id) {
        if (id == null) {
            return new ReturnResult(500, "删除失败！");
        }
        int i = windowPOMapper.deleteByPrimaryKey(id);

        return new ReturnResult(200, "删除成功！");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @PostMapping("/window/batch/delete")
    @ResponseBody
    public ReturnResult windowBatchDelete(String ids) {
        if (ids == null) {
            return new ReturnResult(500, "删除失败！");
        }
        List<Integer> idList = HouseUtils.strToIntList(ids);
        windowPOMapper.batchDelete(idList);

        return new ReturnResult(200, "删除成功！");
    }

    //
    @PostMapping("/window/modify")
    @ResponseBody
    public ReturnResult windowModify(WindowPO windowPO) {

        if (windowPO == null) {
            return new ReturnResult(500, "修改失败！");
        }
        windowPOMapper.updateByPrimaryKeySelective(windowPO);

        return new ReturnResult(200, "修改成功！");
    }
}
