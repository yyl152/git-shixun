package com.xxx.admin.compont;

import com.xxx.admin.pojo.TUser;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginIntceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        TUser tuser = (TUser) request.getSession().getAttribute("tuser");
        if (tuser!=null){
            return true;
        }else{
            response.sendRedirect("/login.html");
            return false;
        }

    }
}
