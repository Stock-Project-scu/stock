package com.web.stock.Controller;

import javax.servlet.http.HttpSession;

import com.web.stock.bean.User;
import com.web.stock.service.Userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

    @Autowired 
    private Userservice userservice;//创建一个userservice
    @Autowired
    HttpSession session;
    
    @RequestMapping("/login")
    @ResponseBody
    public boolean login(User user){
        System.out.println("开始进入登录");
        
        User u1 =userservice.getUserByname(user.getUsername());
        System.out.println(u1);
        System.out.println(user);
        if(user.getPassword().equals(u1.getPassword())){
            System.out.println("成功");
            session.setAttribute("username", user.getUsername());//seesion存储username
            String un = (String)session.getAttribute("username");
            System.out.println("un="+un);
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
    //跳转到gotologin
    @RequestMapping("/gotologin")
    public String gotologin(){
        return "/pages/login.html";
    }
    //注销
    @RequestMapping("/logoff")
    public String logoff(){
        session.removeAttribute("username");//删除session
        return "/pages/login.html";
    }
}
