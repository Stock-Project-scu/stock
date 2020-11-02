package com.web.stock.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.stock.bean.User;
import com.web.stock.service.Userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/lo")
public class LoginController {

    @Autowired
    private Userservice userservice;// 创建一个userservice
    @Autowired
    HttpSession session;

    

    @RequestMapping("/login")
    @ResponseBody
    public Integer login(HttpServletResponse response,
            @RequestParam(value = "username", required = true) String Username,
            @RequestParam(value = "password", required = true) String Passowrd) {
        System.out.println("开始进入登录");
        Cookie cookie = new Cookie("username", null); // cookie存放用户名
        try {
            User u1 = userservice.getUserByname(Username);
            System.out.println(u1);
            System.out.println("Username值=" + Username);
            if (Passowrd.equals(u1.getPassword())) {
                System.out.println("成功");
                session.setAttribute("username", u1.getUsername());// seesion存储username
                String un = (String) session.getAttribute("username");
                cookie.setValue(u1.getUsername());
                cookie.setPath("/");
                response.addCookie(cookie);
                
                cookie.setMaxAge(6 * 60 * 60); // 6小时cookie过期
                System.out.println("cookie=");
                System.out.println("sessionvalue=" + un);
                return 1;// 登陆成功
            } else {
                System.out.println("失败");
                return 2;// 登录失败，密码不对
            }
        } catch (Exception e) {
            System.err.println(e.toString());
            return 3;
        }
    }

    @RequestMapping("/signin")
    @ResponseBody
    public String sign(User user) {
        try {
            if (userservice.getUserByname(user.getUsername()) == null) {
                // 如果找不到就说明可以注册

                userservice.insertUser(user);
                return "注册成功";
            } else {
                return "注册失败,名称重复";
            }
        } catch (Exception e) {
            System.err.println(e.toString());
            return "注册失败，原因" + e.toString();
        }
    }

    // 跳转到gotologin
    @RequestMapping("/gotologin")
    public String gotologin(HttpServletRequest request) {
        request.getSession().invalidate();
        return "/pages/login.html";
    }

    // 注销
    @RequestMapping("/logoff")
    @ResponseBody
    public Integer logoff(HttpServletResponse response) {
        // 将Cookie的值设置为null
        Cookie cookie = new Cookie("username", null);
        // 将`Max-Age`设置为0
        cookie.setMaxAge(0);

        response.addCookie(cookie);
        session.removeAttribute("username");// 删除session
        return 1;
    }
}
