package com.adouer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 原生Servlet和SpringMVC请求转发的区别
 */
@Controller
public class RequestForward {
    /*
         原生Servlet
     */
    //原生Servlet
    @RequestMapping("/forward1")
    public void forward1(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setAttribute("msg", "forward1");
        req.getRequestDispatcher("/forward.jsp").forward(req, rsp);
    }

    //原生Servlet重定向
    @RequestMapping("/forward2")
    public void forward2(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.getSession().setAttribute("msg", "forward2");
        rsp.sendRedirect("forward.jsp");
    }
    /*
        SpringMVC转发【受视图解析器的影响，所以测试前禁用视图解析器】
            -springmvc-servlet.xml中配置视图解析器
     */
    //SpringMVC请求转发方式一
    @RequestMapping("/forward3")
    public String forward3(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setAttribute("msg","forward3");
        return "/forward.jsp";
    }
    //SpringMVC请求转发方式二
    @RequestMapping("/forward4")
    public String forward4(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setAttribute("msg","forward4");
        return "forward:/forward.jsp";
    }
    //SpringMVC重定向
    @RequestMapping("/forward5")
    public String forward5(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.getSession().setAttribute("msg", "forward5");
        return "redirect:forward.jsp";
    }
}