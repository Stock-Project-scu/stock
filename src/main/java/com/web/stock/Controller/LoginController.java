package com.web.stock.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.stock.bean.User;
import com.web.stock.service.Userservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("/lo")
@CrossOrigin
public class LoginController {

    @Autowired
    private Userservice userservice;// 创建一个userservice
    @Autowired
    HttpSession session;
    Logger logger =LoggerFactory.getLogger(LoginController.class);
    @RequestMapping("/login")
    @ResponseBody
    public Integer login(HttpServletResponse response,
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String passowrd) {
                
        logger.info("开始进入登录");
        Cookie cookie = new Cookie("username", null); // cookie存放用户名
        try {
            logger.info("Username值[{}]" , username);
            User u1 = userservice.getUserByName(username);
            
            if (passowrd.equals(u1.getPassword())) {
                logger.info("成功");
                session.setAttribute("username", u1.getUsername());// seesion存储username
                String un = (String) session.getAttribute("username");
                cookie.setValue(u1.getUsername());
                cookie.setPath("/");
                response.addCookie(cookie);
                
                cookie.setMaxAge(6 * 60 * 60); // 6小时cookie过期
                logger.info("sessionvalue={}",un);
                
                return 1;// 登陆成功
            } else {
                logger.info("登录失败");
                return 2;// 登录失败，密码不对
            }
        } catch (Exception e) {
            logger.error("错误", e);
            return 3;
        }
    }

    @RequestMapping("/signin")
    @ResponseBody
    public String sign(User user) {
        logger.info("进入注册");
        logger.info("User信息={}", user.toString());
        try {
            if (userservice.getUserByName(user.getUsername()) == null) {
                // 如果找不到就说明可以注册
                userservice.insertUser(user);
                return "注册成功";
            } else {
                return "注册失败,名称重复";
            }
        } catch (Exception e) {
            logger.error("注册失败", e);
            return "注册失败，原因" + e.toString();
        }
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
        logger.info("退出");
        // 将Cookie的值设置为null
        Cookie cookie = new Cookie("username", null);
        // 将`Max-Age`设置为0
        cookie.setMaxAge(0);

        response.addCookie(cookie);
        session.removeAttribute("username");// 删除session
        return 1;
    }

    
}
