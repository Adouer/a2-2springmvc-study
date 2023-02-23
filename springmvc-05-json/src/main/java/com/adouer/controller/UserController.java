package com.adouer.controller;

import com.adouer.pojo.User;
import com.adouer.utils.JsonUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller
@RestController
public class UserController {
    /**
     * jackson obj->String
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping("/json")
    //@ResponseBody
    public String test() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User("adouer",18,"男");
        String s = mapper.writeValueAsString(user);
        return s;
    }

    /**
     * jackson List->String
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping("/json2")
    public String test2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<User> list = new ArrayList<User>();

        User user1 = new User("adouer1",18,"男");
        User user2 = new User("adouer2",18,"男");
        User user3 = new User("adouer3",18,"男");
        User user4 = new User("adouer4",18,"男");
        User user5 = new User("adouer5",18,"男");

        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);

        String s = mapper.writeValueAsString(list);
        return s;
    }

    /**
     * jackson Date->String
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping("/json3")
    public String test3() throws JsonProcessingException {
        Date date = new Date();
        return JsonUtils.getJson(date , "yyyy-MM-dd HH:mm:ss");
    }
    @RequestMapping("/fastjson")
    public String test4() throws JsonProcessingException {
        List<User> list = new ArrayList<User>();

        User user1 = new User("adouer1",18,"男");
        User user2 = new User("adouer2",18,"男");
        User user3 = new User("adouer3",18,"男");
        User user4 = new User("adouer4",18,"男");
        User user5 = new User("adouer5",18,"男");

        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);

        String s = JSON.toJSONString(list); //将java对象转为json字符串
        String u1 = JSON.toJSONString(user1); //将java对象转为json字符串
        User ob1 = JSON.parseObject(u1, User.class);//将json字符串转换为Java对象
        JSONObject job = (JSONObject) JSON.toJSON(user2);//将java对象转换为json对象
        User u2 = JSON.toJavaObject(job, User.class);//将json对象转换为java对象
        return s;
    }
}
