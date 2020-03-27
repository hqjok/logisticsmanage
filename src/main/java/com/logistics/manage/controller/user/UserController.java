package com.logistics.manage.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.logistics.manage.entity.ResultCustom;
import com.logistics.manage.entity.ReturnResult;
import com.logistics.manage.entity.po.CanteenPO;
import com.logistics.manage.entity.po.UserPO;
import com.logistics.manage.entity.po.UserPOExample;
import com.logistics.manage.entity.po.UserPO;
import com.logistics.manage.entity.searchCondition.UserCondition;
import com.logistics.manage.mapper.UserPOMapper;
import com.logistics.manage.util.HouseUtils;
import com.logistics.manage.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @Create 2020-02-29 16:45
 */
@Controller
public class UserController {

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
    @GetMapping("/user/manage/{pageNum}")
    public String userManage(UserCondition userCondition, @PathVariable("pageNum") Integer pageNum,
                                Model model) {

        //查询条件
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.setOrderByClause("create_time desc");
        UserPOExample.Criteria condition = userPOExample.createCriteria();

        //对查询条件做处理
        //创建时间
        if (!StringUtils.isEmpty(userCondition.getCreateTime())) {
            condition.andCreateTimeJustDay( userCondition.getCreateTime());
        }
        //用户名
        if (!StringUtils.isEmpty(userCondition.getLoginacct())) {
            condition.andLoginacctLike("%" + userCondition.getLoginacct() + "%");
        }
        //用户状态
        if (userCondition.getStatus() != null) {
            condition.andStatusEqualTo(userCondition.getStatus());
        }
        //电话号码
        if (!StringUtils.isEmpty(userCondition.getTelphone())) {
            condition.andTelphoneLike("%" + userCondition.getTelphone() + "%");
        }

        PageHelper.startPage(pageNum, 10);
        List<UserPO> userPOS = userPOMapper.selectByExample(userPOExample);
        PageInfo<UserPO> userPOPageInfo = new PageInfo<>(userPOS);

        //赋值
        ResultCustom result = new ResultCustom(userPOPageInfo, userPOMapper.countByExample(userPOExample), userCondition, pageNum);
        model.addAttribute("result", result);

        return "/pages/admin/list";
    }


    /**
     * 添加
     *
     * @param floorPO
     * @return
     */
    @PostMapping("/user/add")
    @ResponseBody
    public ReturnResult userAdd(UserPO userPO) {

        if (userPO == null) {
            return new ReturnResult(500, "添加失败！");
        }

        userPO.setCreateTime(new Date());
        int i = userPOMapper.insertSelective(userPO);

        return new ReturnResult(200, "添加成功！");
    }

    /**
     * 单个删除
     *
     * @param id
     * @return
     */
    @GetMapping("/user/delete")
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
    @PostMapping("/user/batch/delete")
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
    @PostMapping("/user/modify")
    @ResponseBody
    public ReturnResult userModify(UserPO userPO) {

        if (userPO == null) {
            return new ReturnResult(500, "修改失败！");
        }
        userPOMapper.updateByPrimaryKeySelective(userPO);

        return new ReturnResult(200, "修改成功！");
    }

    @GetMapping("/go/to/personinfo")
    public String getPersoninfo(HttpSession session, Model model){

        Integer userId = SessionUtil.getSessionIdOfBackup(session);
        model.addAttribute("user", userPOMapper.selectByPrimaryKey(userId));

        return "/pages/myinfo/edit";
    }
}
