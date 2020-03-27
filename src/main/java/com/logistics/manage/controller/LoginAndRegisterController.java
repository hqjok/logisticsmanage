package com.logistics.manage.controller;

import com.logistics.manage.entity.po.UserPO;
import com.logistics.manage.entity.po.UserPOExample;
import com.logistics.manage.mapper.UserPOMapper;
import com.logistics.manage.util.HouseConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

/**
 * @Create 2020-02-08 16:33
 */
@Controller
public class LoginAndRegisterController {

    @Autowired
    private UserPOMapper userPOMapper;

    /**
     *
     * 后台退出
     * @param session
     * @return
     */
    @RequestMapping("/member/logout")
    public String logout(HttpSession session) {
        session.removeAttribute(HouseConstant.BACKUP_SESSION);
        return "redirect:" + HouseConstant.PathUrl.BACKUP_LOGIN_DERECTION;
    }

    /**
     * 后台登录
     * @param
     * @param model
     * @param session
     * @return
     */
    @PostMapping("/member/login")
    @ResponseBody
    public String login(UserPO userPO, Model model, HttpSession session) {

        //为空
        if (userPO == null) {
            return HouseConstant.MESSAGE_INPUT_INVALID;
        }

        //数据库获取
        String loginAcct = userPO.getLoginacct();
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andLoginacctEqualTo(loginAcct);

        List<UserPO> userPOS = userPOMapper.selectByExample(userPOExample);
        if (userPOS == null || userPOS.size() == 0) {
            return HouseConstant.MESSAGE_DATA_EMPTY;
        }

        UserPO memberPOFromSql = userPOS.get(0);


        if (memberPOFromSql.getStatus() == 0) {
            return HouseConstant.MESSAGE_MEMBER_DO_NOT_BE_USE;
        }


        if (!Objects.equals(memberPOFromSql.getUserpswd(), userPO.getUserpswd())) {
            return HouseConstant.MESSAGE_LOGIN_FAILED;
        }

        session.setAttribute(HouseConstant.BACKUP_SESSION, memberPOFromSql);

        return "success" ;
    }
}
