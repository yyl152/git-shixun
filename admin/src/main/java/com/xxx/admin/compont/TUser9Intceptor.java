package com.xxx.admin.compont;


import com.xxx.admin.pojo.TUser;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TUser9Intceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        TUser TUser = (TUser)request.getSession().getAttribute("TUser");
        Integer level = TUser.getLevel();
        if (level.equals("9")){
            return true;
        }else{
            response.sendRedirect("/login.html");
            return false;
        }

    }
}
