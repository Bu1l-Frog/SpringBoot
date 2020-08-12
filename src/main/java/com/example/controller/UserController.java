package com.example.controller;

import com.example.pojo.Result;
import com.example.pojo.User;
import com.example.utils.ResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

//@Controller
@RestController // @RestController = @Controller + @ResponseBody
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUser")
//    @ResponseBody
    public Result<User> getUser(){

        User u = new User();
        u.setName("abc");
        u.setPassword("123");
        u.setAge(18);
        u.setDate(new Date());
        u.setDesc(null);

        return ResultUtils.success(u);
    }
}
