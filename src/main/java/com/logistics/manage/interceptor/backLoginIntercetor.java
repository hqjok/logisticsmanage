package com.logistics.manage.interceptor;

import com.logistics.manage.util.HouseConstant;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Create 2020-01-21 22:55
 */
public class backLoginIntercetor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object memberPO = request.getSession().getAttribute(HouseConstant.BACKUP_SESSION);
        if (memberPO != null) {
            return true;
        }

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<script>");
        out.println("window.open('" + request.getContextPath() + "/go/to/login','_self')");
        out.println("</script>");
        out.println("</html>");

        return false;

    }
}
