package com.example.controller;

import com.example.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("th")
public class ThymeleafController {

    @RequestMapping("/index")
    public String index(ModelMap map){
        map.addAttribute("name", "thymeleaf");
        return "thymeleaf/index";
    }

    @RequestMapping("center")
    public String center(){
        return "thymeleaf/center/center";
    }

    @RequestMapping("test")
    public String test(ModelMap map){
        User u = new User();
        u.setName("abc");
        u.setAge(18);
        u.setPassword("123456");
        u.setDate(new Date());
        u.setDesc("<font color='green><b>hello</b></font>");

        List<User> userList = new ArrayList<>();
        userList.add(u);

        map.addAttribute("userList", userList);
        return "thymeleaf/test";
    }

    @PostMapping("postform")
    public String postform(User u){
        System.out.println(u.getName());
        return "redirect:/th/test";
    }

}
