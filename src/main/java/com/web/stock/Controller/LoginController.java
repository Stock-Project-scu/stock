package com.web.stock.Controller;

import com.web.stock.bean.User;
import com.web.stock.service.Userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    // @RequestMapping("/")
    // public String Hello(){
    //     return "kkk";
    // }
    @Autowired 
    private Userservice userservice;//创建一个userservice

    @RequestMapping("/login")
    public boolean login(User user){
        System.out.println("开始进入登录");
        System.out.println(user.toString());
        User u1 =userservice.getUserByname(user.getUsername());
        if(user.getPassword()==u1.getPassword()){
            System.out.println("成功");
            return true;//登陆成功
        }
        else{
            System.out.println("失败");
            return false;//登录失败，密码不对或者是其他问题
        }
    }
    @RequestMapping("/signin")
    @ResponseBody
    public String sign(User user){
        try {
            if(userservice.getUserByname(user.getUsername())==null){
                //如果找不到就说明可以注册
                userservice.insertUser(user);
                return "注册成功";
            }
            else{
                return "注册失败,名称重复";
            }
        } catch (Exception e) {
            System.err.println(e.toString());
            return "注册失败，原因"+e.toString();
        }
    }
    
}
