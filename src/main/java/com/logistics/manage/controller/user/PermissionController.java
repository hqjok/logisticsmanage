package com.logistics.manage.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.logistics.manage.entity.ResultCustom;
import com.logistics.manage.entity.ReturnResult;
import com.logistics.manage.entity.po.UserPO;
import com.logistics.manage.entity.po.UserPOExample;
import com.logistics.manage.entity.searchCondition.PermissionCondition;
import com.logistics.manage.entity.searchCondition.UserCondition;
import com.logistics.manage.mapper.UserPOMapper;
import com.logistics.manage.util.HouseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @Create 2020-02-29 16:52
 */
@Controller
public class PermissionController {

    @Autowired
    private UserPOMapper userPOMapper;

    /**
     * 根据条件进行查询
     *
     * @param floorCondition
     * @param pageNum
     * @param model
     * @return
     */
    @GetMapping("/permission/manage/{pageNum}")
    public String permissionManage(PermissionCondition permissionCondition, @PathVariable("pageNum") Integer pageNum,
                             Model model) {

        //查询条件
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.setOrderByClause("create_time desc");
        UserPOExample.Criteria condition = userPOExample.createCriteria();

        //对查询条件做处理
        //用户名
        if (!StringUtils.isEmpty(permissionCondition.getLoginacct())) {
            condition.andLoginacctLike("%" + permissionCondition.getLoginacct() + "%");
        }
        //权限
        if (!StringUtils.isEmpty(permissionCondition.getPermission())) {
            condition.andPermissionLike("%" + permissionCondition.getPermission() + "%");
    }

        PageHelper.startPage(pageNum, 10);
        List<UserPO> userPOS = userPOMapper.selectByExample(userPOExample);
        PageInfo<UserPO> userPOPageInfo = new PageInfo<>(userPOS);

        //赋值
        ResultCustom result = new ResultCustom(userPOPageInfo, userPOMapper.countByExample(userPOExample), permissionCondition, pageNum);
        model.addAttribute("result", result);

        return "/pages/adminPower/list";
    }

    /**
     * 单个删除
     *
     * @param id
     * @return
     */
    @GetMapping("/permission/delete")
    @ResponseBody
    public ReturnResult userPODelete(Integer id) {
        if (id == null) {
            return new ReturnResult(500, "删除失败！");
        }
        int i = userPOMapper.deleteByPrimaryKey(id);

        return new ReturnResult(200, "删除成功！");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @PostMapping("/permission/batch/delete")
    @ResponseBody
    public ReturnResult userBatchDelete(String ids) {
        if (ids == null) {
            return new ReturnResult(500, "删除失败！");
        }
        List<Integer> idList = HouseUtils.strToIntList(ids);
        userPOMapper.batchDelete(idList);

        return new ReturnResult(200, "删除成功！");
    }

    //
    @PostMapping("/permission/modify")
    @ResponseBody
    public ReturnResult userModify(UserPO userPO, @RequestParam("selectPower")List<String> permissions) {

        if (userPO == null) {
            return new ReturnResult(500, "修改失败！");
        }

        //处理权限
        String permission = StringUtils.join(permissions, ",");
        userPO.setPermission(permission);

        userPO.setModifyPermissionTime(new Date());
        userPOMapper.updateByPrimaryKeySelective(userPO);

        return new ReturnResult(200, "修改成功！");
    }
}
