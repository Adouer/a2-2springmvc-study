package com.adouer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestFulController {
    @RequestMapping("/restful/{a}/{b}")
    public String hello(@PathVariable int a, @PathVariable int b , Model model) {

        model.addAttribute("msg","结果:"+(a+b));

        return "hello";
    }

}
