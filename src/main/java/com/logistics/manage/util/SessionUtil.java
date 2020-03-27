package com.logistics.manage.util;

import com.logistics.manage.entity.po.UserPO;

import javax.servlet.http.HttpSession;

/**
 * @Create 2020-02-10 6:41
 */
public class SessionUtil {

    public static Integer getSessionIdOfBackup(HttpSession session){
        UserPO memberPOForFrontend = (UserPO) session.getAttribute(HouseConstant.BACKUP_SESSION);
        return memberPOForFrontend.getId();
    }

    public static UserPO getMemberPOOFSessionBackup(HttpSession session){

        return (UserPO)session.getAttribute(HouseConstant.BACKUP_SESSION);
    }


    public static void resetSessionFrontend_userPO(UserPO userPO, HttpSession session){

        session.removeAttribute(HouseConstant.BACKUP_SESSION);

        session.setAttribute(HouseConstant.BACKUP_SESSION, userPO);
    }


    public static boolean checkFrontendLogin(HttpSession session){
        if(session.getAttribute(HouseConstant.BACKUP_SESSION) == null){
            return false;
        }
        return true;
    }

}
