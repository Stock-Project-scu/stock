package com.web.stock.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.stock.bean.User;
import com.web.stock.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

@CrossOrigin
public class LoginController {
    @Autowired
    LoginService loginservice;//登录服务
    @RequestMapping("/login")
    @ResponseBody
    public Integer login(HttpServletResponse response,
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String passowrd) {
        return loginservice.loginservice(response, username, passowrd);
    }
    @RequestMapping("/signin")
    @ResponseBody
    public String sign(User user) {
        return loginservice.signservice(user);
    }

    // 跳转到gotologin
    @RequestMapping("/gotologin")
    public String gotologin(HttpServletRequest request) {
        request.getSession().invalidate();
        return "pages/login";
    }

    // 注销
    @RequestMapping("/logoff")
    @ResponseBody
    public Integer logoff(HttpServletResponse response) {
        return loginservice.logoffservice(response);
    }

}
