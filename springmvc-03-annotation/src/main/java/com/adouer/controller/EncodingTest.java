package com.adouer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EncodingTest {
    @RequestMapping("/encoding")
    public String Test(String name , Model model){
        System.out.println(name);
        model.addAttribute("msg" , name);
        return "hello";
    }
}
