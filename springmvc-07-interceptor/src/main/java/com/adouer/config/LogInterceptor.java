package com.adouer.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 登录拦截
 */
public class LogInterceptor implements HandlerInterceptor {
    //
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //去登录页放行
        if(request.getRequestURI().contains("toLogPage")){
            return true;
        }
        //正在登录
        if(request.getRequestURI().contains("login")){
            return true;
        }
        //用户session不为空放行
        if(request.getSession().getAttribute("userSession")!=null){
            return true;
        }
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }
}
