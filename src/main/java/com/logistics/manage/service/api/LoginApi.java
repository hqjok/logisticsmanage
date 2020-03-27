package com.logistics.manage.service.api;

import com.logistics.manage.entity.po.MemberPO;
import com.logistics.manage.entity.po.MemberPOExample;
import com.logistics.manage.factory.RoleFactory;
import com.logistics.manage.mapper.MemberPOMapper;
import com.logistics.manage.service.RoleAndMenuApi;
import com.logistics.manage.service.result.LoginResult;
import com.logistics.manage.util.HouseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * @Create 2020-03-18 20:54
 */

@RestController
public class LoginApi {

    @Autowired
    private MemberPOMapper memberPOMapper;

    @Autowired
    private RoleFactory roleFactory;

    @RequestMapping("/login")
    public LoginResult loginAndInitMenu(@RequestParam(value = "loginacct", required = false)String loginacct,
                                        @RequestParam(value = "userpswd", required = false)String userpswd){

        if(StringUtils.isEmpty(loginacct) || StringUtils.isEmpty(userpswd)){
            return LoginResult.faild(500, "请填写正确的登录名跟密码");
        }

        //数据库查询出用户数据
        MemberPOExample memberPOExample = new MemberPOExample();
        memberPOExample.createCriteria().andLoginacctEqualTo(loginacct);
        
        //若无此账号
        List<MemberPO> memberPOS = memberPOMapper.selectByExample(memberPOExample);

        if(!HouseUtils.collectionEffectiveCheck(memberPOS)){
            return LoginResult.faild(500, "暂无此用户，请输入正确的账户名");
        }

        MemberPO memberPOFromSql = memberPOS.get(0);

        //用户无效
        if(memberPOFromSql.getStatus() == 0){
            return LoginResult.faild(500, "用户处于无效状态");
        }

        //比对
        if(!Objects.equals(memberPOFromSql.getUserpswd(), userpswd)){
            return LoginResult.faild(500, "用户名或者密码错误");
        }

        //获取菜单列表
        String roleId = memberPOFromSql.getRoleId().toString();
        RoleAndMenuApi roleAndMenuApi = roleFactory.get("role" + roleId);

        if(roleAndMenuApi == null){
            return LoginResult.faild(500, "该用户暂时没有任何权限，请联系相关人员进行权限排查");
        }

        //权限获取的菜单列表
        List<LoginResult.MenuListBean> menuList = roleAndMenuApi.getMenuList();

        return new LoginResult(200, "登录成功", memberPOFromSql.getUsername(), roleAndMenuApi.getRoleName(), menuList);
    }

}
