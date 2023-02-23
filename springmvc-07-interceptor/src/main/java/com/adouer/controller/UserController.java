package com.adouer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 去登录页
     * @return
     */
    @RequestMapping("/toLogPage")
    public String toLogPage() {
        return "login";
    }
    /**
     * 登录
     */
    @RequestMapping("/login")
    public String login(HttpSession session , String username , String password, Model model) {

        session.setAttribute("userSession" , username);
        model.addAttribute("username",username);
        return "admin";
    }
    /**
     * 去主页
     * @return
     */
    @RequestMapping("/toAdminPage")
    public String toAdminPage(HttpSession session,Model model) {
        model.addAttribute("username",session.getAttribute("userSession"));
        return "admin";
    }

    /**
     * 注销
     * @return
     */
    @RequestMapping("/goOut")
    public String goOut(HttpSession session) {
        session.removeAttribute("userSession");
        return "redirect:/index.jsp";
    }
}
