package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("err")
public class ErrorController {

    @RequestMapping("/error")
    public String error(){
        int a = 1/0;
        return "/th/error";
    }

    @RequestMapping("/ajaxerror")
    public String ajaxerror(){
        return "/th/ajaxerror";
    }

    @RequestMapping("/getAjaxerror")
    @ResponseBody
    public String getAjaxerror(){
        int a = 1/0;
        return "Error";
    }
}
