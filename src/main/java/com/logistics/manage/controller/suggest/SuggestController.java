package com.logistics.manage.controller.suggest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.logistics.manage.entity.ResultCustom;
import com.logistics.manage.entity.ReturnResult;
import com.logistics.manage.entity.po.CanteenPO;
import com.logistics.manage.entity.po.SuggestPO;
import com.logistics.manage.entity.po.SuggestPOExample;
import com.logistics.manage.entity.po.SuggestPO;
import com.logistics.manage.entity.searchCondition.SuggestCondition;
import com.logistics.manage.mapper.SuggestPOMapper;
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
 * @Create 2020-02-29 17:30
 */
@Controller
public class SuggestController {

    @Autowired
    private SuggestPOMapper suggestPOMapper;

    /**
     * 根据条件进行查询
     *
     * @param floorCondition
     * @param pageNum
     * @param model
     * @return
     */
    @GetMapping("/suggest/manage/{pageNum}")
    public String suggestManage(SuggestCondition suggestCondition, @PathVariable("pageNum") Integer pageNum,
                                 Model model) {

        //查询条件
        SuggestPOExample suggestPOExample = new SuggestPOExample();
        suggestPOExample.setOrderByClause("create_time desc");
        SuggestPOExample.Criteria condition = suggestPOExample.createCriteria();

        //对查询条件做处理
        //提交人名字
        if (!StringUtils.isEmpty(suggestCondition.getUsername())) {
            condition.andUsernameLike("%" + suggestCondition.getUsername() + "%");
        }
        //意见内容
        if (suggestCondition.getTypeId() != null && suggestCondition.getTypeId() > 0) {
            condition.andTypeIdEqualTo(suggestCondition.getTypeId());
        }

        PageHelper.startPage(pageNum, 10);
        List<SuggestPO> suggestPOS = suggestPOMapper.selectByExampleWithBLOBs(suggestPOExample);
        PageInfo<SuggestPO> suggestPOPageInfo = new PageInfo<>(suggestPOS);

        //赋值
        ResultCustom result = new ResultCustom(suggestPOPageInfo, suggestPOMapper.countByExample(suggestPOExample), suggestCondition, pageNum);
        model.addAttribute("result", result);

        return "/pages/studentOpinion/list";
    }


    /**
     * 添加
     *
     * @param floorPO
     * @return
     */
    @PostMapping("/suggest/add")
    @ResponseBody
    public ReturnResult suggestAdd(SuggestPO suggestPO) {

        if (suggestPO == null) {
            return new ReturnResult(500, "添加失败！");
        }

        suggestPO.setCreateTime(new Date());
        int i = suggestPOMapper.insertSelective(suggestPO);

        return new ReturnResult(200, "添加成功！");
    }

    /**
     * 单个删除
     *
     * @param id
     * @return
     */
    @GetMapping("/suggest/delete")
    @ResponseBody
    public ReturnResult suggestPODelete(Integer id) {
        if (id == null) {
            return new ReturnResult(500, "删除失败！");
        }
        int i = suggestPOMapper.deleteByPrimaryKey(id);

        return new ReturnResult(200, "删除成功！");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @PostMapping("/suggest/batch/delete")
    @ResponseBody
    public ReturnResult suggestBatchDelete(String ids) {
        if (ids == null) {
            return new ReturnResult(500, "删除失败！");
        }
        List<Integer> idList = HouseUtils.strToIntList(ids);
        suggestPOMapper.batchDelete(idList);

        return new ReturnResult(200, "删除成功！");
    }

    //
    @PostMapping("/suggest/modify")
    @ResponseBody
    public ReturnResult suggestModify(SuggestPO suggestPO) {

        if (suggestPO == null) {
            return new ReturnResult(500, "修改失败！");
        }
        suggestPOMapper.updateByPrimaryKeySelective(suggestPO);

        return new ReturnResult(200, "修改成功！");
    }
}
