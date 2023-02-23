package com.adouer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("hello")
    public String hello(Model model) {
        model.addAttribute("msg" , "hellow springmvc annotation");
        return "hello";  //被视图解析器处理
    }



}
