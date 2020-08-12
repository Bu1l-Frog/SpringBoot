package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("mybatis")
public class MyBatisCrudController {

    @Autowired
    private UserService userService;

    @Autowired
//    private Sid sid;

    @RequestMapping("/saveUser")
    public String saveUser() throws Exception{
//        String userId = sid.nextShort();
        User user = new User();
        user.setName("abc");
        //TODO
        userService.saveUser(user);
        return "OK";
    }

    //TODO

    public List<User> queryUserListPaged(Integer page){
        if (page == null){
            page = 1;
        }
        int pageSize = 10;
        User user = new User();
        List<User> userList = userService.queryUserList(user, page, pageSize);
        return userList;
    }

    public List<User> queryUserByIdCustom(String id){
        return userService.queryUserByIdCustom(id);
    }
}
