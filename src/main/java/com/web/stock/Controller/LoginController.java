package com.web.stock.Controller;

import com.web.stock.bean.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    // @RequestMapping("/")
    // public String Hello(){
    //     return "kkk";
    // }
    @RequestMapping("/register")
    public void register(User u1){
        System.out.println(u1.toString());
        System.out.println(u1.getEmail());
    }
    
}
