package com.web.stock.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {
    @Autowired
    HttpSession session;

    // @RequestMapping("/")
    // public String MainControl(){
    //     return "kkk";
    // }
    @RequestMapping("/test")
    public String test(){
        return "/pages/login.html";
    }
}
