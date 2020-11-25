package com.web.stock.service.impl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.stock.bean.User;
import com.web.stock.service.LoginService;
import com.web.stock.service.UserPropertyService;
import com.web.stock.service.Userservice;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 代相廷
 * 实现登录服务的函数实现
 */

@Service("LoginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private Userservice userservice;// 创建一个userservice
    @Autowired
    UserPropertyService userpropertyservice;
    @Autowired
    HttpSession session;
    Logger logger =LoggerFactory.getLogger(LoginServiceImpl.class);

    @Override
    public Integer loginservice(HttpServletResponse response, String username, String passowrd) {
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

    @Override
    public Integer logoffservice(HttpServletResponse response) {
        logger.info("退出");
        // 将Cookie的值设置为null
        Cookie cookie = new Cookie("username", null);
        // 将`Max-Age`设置为0
        cookie.setMaxAge(0);

        response.addCookie(cookie);
        session.removeAttribute("username");// 删除session
        return 1;
    }

    @Override
    public String signservice(User user) {
        logger.info("进入注册");
        logger.info("User信息={}", user.toString());
        try {
            if (userservice.getUserByName(user.getUsername()) == null) {
                // 如果找不到就说明可以注册
                userservice.insertUser(user);
                userpropertyservice.insertUserProperty(user.getUsername());//建立资产表
                return "注册成功";
            } else {
                return "注册失败,名称重复";
            }
        } catch (Exception e) {
            logger.error("注册失败", e);
            return "注册失败，原因" + e.toString();
        }

    }

}