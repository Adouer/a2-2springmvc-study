package com.adouer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.Map;

/**
 * 这里介绍几种种视图模型
 * - Model
 * - ModelMap
 * - ModelAndView
 * - @ModelAttribute
 * - Map
 */
@Controller
public class ViewModels {

    /**
     * Model
     *
     * @param model
     * @return
     */
    @RequestMapping("/model1")
    public String model1(Model model) {
        model.addAttribute("msg", "model1");
        return "forward:/forward.jsp";
    }

    /**
     * ModelMap
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/model2")
    public String model2(ModelMap modelMap) {
        modelMap.addAttribute("msg", "model2");
        return "forward:/forward.jsp";
    }

    /**
     * ModelAndView
     *
     * @param modelAndView
     * @return
     */
    @RequestMapping("/model3")
    public ModelAndView model3(ModelAndView modelAndView) {
        modelAndView.addObject("msgg", "model3");
        modelAndView.setViewName("forward:/forward.jsp");
        return modelAndView;
    }

    /**
     * 在每个控制器类的处理方法执行前执行
     * 表示向msg中设置“model4”,等价于 model.addAttribute("msg", "model4");
     */
    @ModelAttribute("msg")
    public String message() {
        return "model4";
    }
    @RequestMapping("/model4")
    public String model4() {
        return "forward:/forward.jsp";
    }

    /**
     * Map
     * @param map
     * @return
     */
    @RequestMapping("/model5")
    public String model5(Map<String,Object> map) {
        map.put("msg", "model5");
        return "forward:/forward.jsp";
    }

}
